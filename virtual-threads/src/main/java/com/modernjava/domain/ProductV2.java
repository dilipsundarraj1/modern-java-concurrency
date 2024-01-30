package com.modernjava.domain;

public record ProductV2(String productId,
                        ProductInfo productInfo,
                        Reviews reviews,
                        DeliveryDetails deliveryDetails) {
}
