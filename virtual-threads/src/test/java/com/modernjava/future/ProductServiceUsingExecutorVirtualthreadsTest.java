package com.modernjava.future;


import com.service.ProductInfoService;
import com.service.ReviewService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductServiceUsingExecutorVirtualthreadsTest {

    @Spy
    ProductInfoService productInfoService;

    @Spy
    ReviewService reviewService;

    @InjectMocks
    ProductServiceUsingExecutorVirtualThreads productServiceUsingExecutorVirtualThreads;


    @Test
    void retrieveProductDetails() throws ExecutionException, InterruptedException, TimeoutException {
        var product = productServiceUsingExecutorVirtualThreads.retrieveProductDetails("ABC");
        assertNotNull(product);
    }

    @Test
    void retrieveProductDetailsException() throws InterruptedException {
        when(productInfoService.retrieveProductInfo(anyString())).thenThrow(new RuntimeException("Exception Occurred"));
        var exception = Assertions.assertThrows(ExecutionException.class, () -> productServiceUsingExecutorVirtualThreads.retrieveProductDetails("ABC"));
        assertEquals("java.lang.RuntimeException: Exception Occurred", exception.getMessage());

        Thread.sleep(2000);
    }
}