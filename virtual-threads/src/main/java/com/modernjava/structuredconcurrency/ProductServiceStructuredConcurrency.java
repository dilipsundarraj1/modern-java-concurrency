package com.modernjava.structuredconcurrency;


import com.modernjava.domain.Product;
import com.modernjava.domain.ProductV2;
import com.modernjava.service.DeliveryService;
import com.modernjava.service.ProductInfoService;
import com.modernjava.service.ReviewService;


public class ProductServiceStructuredConcurrency {

    private final ProductInfoService productInfoService;
    private final ReviewService reviewService;
    private final DeliveryService deliveryService;

    public ProductServiceStructuredConcurrency(ProductInfoService productInfoService, ReviewService reviewService, DeliveryService deliveryService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
        this.deliveryService = deliveryService;
    }

    public ProductServiceStructuredConcurrency(ProductInfoService productInfoService, ReviewService reviewService) {
        this.productInfoService = productInfoService;
        this.reviewService = reviewService;
        this.deliveryService = null;
    }


    public Product retrieveProductDetails(String productId) {

      return null;
    }

}
