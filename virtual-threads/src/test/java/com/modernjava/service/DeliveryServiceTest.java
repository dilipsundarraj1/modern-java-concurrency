package com.modernjava.service;

import com.modernjava.domain.ProductInfo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.modernjava.util.LoggerUtil.log;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceTest {

    DeliveryService deliveryService= new DeliveryService();

    @Test
    @Disabled
    void retrieveDeliveryInfoHttp() throws IOException, InterruptedException {

        var deliveryDetails = deliveryService.retrieveDeliveryInfoHttp(new ProductInfo("ABC", List.of()));
        log("deliveryDetails : "+ deliveryDetails);
        assertNotNull(deliveryDetails);

    }
}