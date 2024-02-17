package com.modernjava.service;

import com.modernjava.util.LoggerUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductInfoServiceTest {

    @Spy
    ProductInfoService productInfoService = new ProductInfoService();

    @Test
    void retrieveProductInfo() {
        // In this case, the time it takes is close to the first task which completes in 1 second.
        var productInfo = productInfoService.retrieveProductInfo_MultipleSources("ABC");
        assertNotNull(productInfo);

    }

    @Test
    void retrieveProductInfo_simulateError() {
        // In this case, the time it takes is close to the first task which completes in 1 second.
        when(productInfoService.retrieveProductInfo(anyString()))
                .thenThrow(new RuntimeException("Exception Occurred!"));
        var productInfo = productInfoService.retrieveProductInfo_MultipleSources("ABC");
        assertNotNull(productInfo);

    }

    @Test
    @Disabled
    void retrieveProductInfo_http() throws IOException, InterruptedException {
        var productInfo = productInfoService.retrieveProductInfoHttp("ABC");
        LoggerUtil.log("productInfo : "+ productInfo);
        assertNotNull(productInfo);

    }
}