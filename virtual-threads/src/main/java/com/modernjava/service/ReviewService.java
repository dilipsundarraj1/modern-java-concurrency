package com.modernjava.service;

import com.modernjava.domain.ProductInfo;
import com.modernjava.domain.Reviews;
import com.modernjava.util.CommonUtil;
import com.modernjava.util.LoggerUtil;

import java.io.IOException;
import java.net.http.HttpResponse;

import static com.modernjava.util.CommonUtil.objectMapper;
import static com.modernjava.util.CommonUtil.requestBuilder;

public class ReviewService {

    public  static String REVIEWS_URL = "http://127.0.0.1:8000/virtual-threads/src/main/resources/reviews.json";
    public Reviews retrieveReviews(String productId) {
        CommonUtil.sleep(2000);
        LoggerUtil.log("retrieveReviews after Delay");
        return new Reviews(200, 4.5);
    }

    public Reviews retrieveReviewsHttp(String productId) throws IOException, InterruptedException {
       return null;
    }
}
