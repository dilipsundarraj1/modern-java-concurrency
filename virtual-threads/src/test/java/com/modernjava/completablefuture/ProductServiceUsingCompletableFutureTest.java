package com.modernjava.completablefuture;

import com.domain.Product;
import com.service.ProductInfoService;
import com.service.ReviewService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceUsingCompletableFutureTest {

    @Spy
    ProductInfoService productInfoService;
    @Spy
    ReviewService reviewService;
    @InjectMocks
    ProductServiceUsingCompletableFuture productServiceUsingCF;

    @Test
    void retrieveProductDetails() {

        //given
        String productId = "ABC123";

        //when
        Product product = productServiceUsingCF.retrieveProductDetails(productId);

        //then
        assertNotNull(product);
        assertTrue(!product.productInfo().productOptions().isEmpty());
        assertNotNull(product.reviews());

    }

    @Test
    void retrieveProductDetails_Exception_productInfo() {

        //given
        String productId = "ABC123";
        when(productInfoService.retrieveProductInfo(anyString())).thenThrow(new RuntimeException("Exception Occurred in ProductInfo"));

        //when and then
        var exception = Assertions.assertThrows(CompletionException.class, () -> productServiceUsingCF.retrieveProductDetails_exceptionhandling(productId));
        assertEquals("java.lang.RuntimeException: Exception Occurred in ProductInfo", exception.getMessage());

    }

    @Test
    void retrieveProductDetails_Exception_reviews() {

        //given
        String productId = "ABC123";
        when(reviewService.retrieveReviews(anyString())).thenThrow(new RuntimeException("Exception Occurred in Reviews"));

        //when and then
        var exception = Assertions.assertThrows(CompletionException.class, () -> productServiceUsingCF.retrieveProductDetails_exceptionhandling(productId));
        assertEquals("java.lang.RuntimeException: Exception Occurred in Reviews", exception.getMessage());

    }

    @Test
    @Disabled
    void retrieveProductDetails_Exception_reviews_exceptionally() {

        //given
        String productId = "ABC123";
        when(reviewService.retrieveReviews(anyString())).thenThrow(new RuntimeException("Exception Occurred in Reviews"));

        //when and then
        var product =  productServiceUsingCF.retrieveProductDetails_exceptionhandling(productId);
        assertNotNull(product);
        assertEquals(0.0, product.reviews().noOfReviews());

    }



    @Test
    void retrieveProductDetails_CF() {

        //given
        String productId = "ABC123";

        //when
        CompletableFuture<Product> cfProduct = productServiceUsingCF.retrieveProductDetails_CF(productId);

        //then
        cfProduct
                .thenAccept((product -> {
                    assertNotNull(product);
                    assertTrue(!product.productInfo().productOptions().isEmpty());
                    assertNotNull(product.reviews());
                }))
                .join();

    }

}