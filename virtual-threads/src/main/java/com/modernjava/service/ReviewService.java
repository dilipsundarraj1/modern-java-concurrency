package com.modernjava.service;

import com.domain.Reviews;
import com.util.CommonUtil;
import com.util.LoggerUtil;

public class ReviewService {


    public Reviews retrieveReviews(String productId) {
        CommonUtil.sleep(2000);
        LoggerUtil.log("retrieveReviews after Delay");
        return new Reviews(200, 4.5);
    }
}
