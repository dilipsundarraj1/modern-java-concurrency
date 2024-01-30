package com.modernjava.structuredconcurrency;

import com.modernjava.service.DeliveryService;
import com.modernjava.service.ProductInfoService;
import com.modernjava.service.ReviewService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceStructuredConcurrencyTest {

    /*
    ProductInfoService productInfoService = Mockito.spy(ProductInfoService.class);
    ReviewService reviewService = Mockito.spy(ReviewService.class);
     DeliveryService deliveryService = Mockito.spy(DeliveryService.class);

    ProductServiceStructuredConcurrency productServiceStructuredConcurrency
            = new ProductServiceStructuredConcurrency(productInfoService, reviewService, deliveryService);
    */
    @Spy
    ProductInfoService productInfoService;

    @Spy
    ReviewService reviewService;

    @Spy
    DeliveryService deliveryService;

    @InjectMocks
    ProductServiceStructuredConcurrency productServiceStructuredConcurrency;

    @Test
    void retrieveProductDetails() {

        var product = productServiceStructuredConcurrency.retrieveProductDetails("ABC");
        assertNotNull(product);
        assertNotNull(product.productInfo());
        assertNotNull(product.reviews());

    }

    @Test
    void retrieveProductDetails_Exception() {
        when(productInfoService.retrieveProductInfo(anyString())).thenThrow(new RuntimeException("Exception calling review Service"));

        var exception = Assertions.assertThrows(RuntimeException.class,()-> productServiceStructuredConcurrency.retrieveProductDetails("ABC") );
        System.out.println("Exception is " + exception.getMessage());
        assertNotNull(exception);
        var expectedErrorMessage = "java.util.concurrent.ExecutionException: java.lang.RuntimeException: Exception calling review Service";
        assertEquals(expectedErrorMessage, exception.getMessage());

    }

    @Test
    void retrieveProductDetailsV2() {
        var product = productServiceStructuredConcurrency.retrieveProductDetailsV2("ABC");
        assertNotNull(product);
        assertNotNull(product.productInfo());
        assertNotNull(product.reviews());
        assertNotNull(product.deliveryDetails());

    }
}