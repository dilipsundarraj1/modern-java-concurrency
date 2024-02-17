package com.modernjava.structuredconcurrency;


import com.modernjava.domain.Product;
import com.modernjava.domain.ProductV2;
import com.modernjava.service.DeliveryService;
import com.modernjava.service.ProductInfoService;
import com.modernjava.service.ReviewService;

import java.util.concurrent.StructuredTaskScope;

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

        // With this pattern, the code logic is clear and its more readable compared to the counterpart CF.
        // We open it up as try with resources, because
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            //Fork -> Virtual Threads are created if the task requires it.
            // In this case, there will be two virtual threads created to execute the below logic
            var productInfoSubtask = scope.fork(()->productInfoService.retrieveProductInfo(productId));
            var reviewsSubtask = scope.fork(()->reviewService.retrieveReviews(productId));

            //Join
            scope.join().throwIfFailed(); // This is completely nonblocking and join completes when the subtasks completes

            var productInfo = productInfoSubtask.get();
            var reviews = reviewsSubtask.get();
            return new Product(productId, productInfo, reviews);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This function also provides delivery information along with the order.
     * @param productId
     * @return
     */
    public ProductV2 retrieveProductDetailsV2(String productId) {

        // With this pattern, the code logic is clear and its more readable compared to the counterpart CF.
        // We open it up as try with resources, because
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            //Fork -> Virtual Threads are created if the task requires it.
            // In this case, there will be two virtual threads created to execute the below logic
            var productInfoSubtask = scope.fork(()->productInfoService.retrieveProductInfo(productId));
            var reviewsSubtask = scope.fork(()->reviewService.retrieveReviews(productId));

            //Join
            scope.join(); // This is completely nonblocking and join completes when the subtasks completes
            var productInfo = productInfoSubtask.get();
            var reviews = reviewsSubtask.get();

            var deliveryDetailsTask = scope.fork(()->deliveryService.retrieveDeliveryInfo(productInfo));
            scope.join();
            var deliveryDetails = deliveryDetailsTask.get();



            return new ProductV2(productId, productInfo, reviews,
                    deliveryDetails);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ProductV2 retrieveProductDetailsHttp(String productId) {

        // With this pattern, the code logic is clear and its more readable compared to the counterpart CF.
        // We open it up as try with resources, because
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            //Fork -> Virtual Threads are created if the task requires it.
            // In this case, there will be two virtual threads created to execute the below logic
            var productInfoSubtask = scope.fork(()->productInfoService.retrieveProductInfoHttp(productId));
            var reviewsSubtask = scope.fork(()->reviewService.retrieveReviewsHttp(productId));

            //Join
            scope.join().throwIfFailed(); // This is completely nonblocking and join completes when the subtasks completes
            var productInfo = productInfoSubtask.get();
            var reviews = reviewsSubtask.get();

            var deliveryDetailsTask = scope.fork(()->deliveryService.retrieveDeliveryInfoHttp(productInfo));
            scope.join().throwIfFailed();
            var deliveryDetails = deliveryDetailsTask.get();

            return new ProductV2(productId, productInfo, reviews,
                    deliveryDetails);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
