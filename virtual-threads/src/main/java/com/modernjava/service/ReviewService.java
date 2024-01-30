package com.modernjava.service;

import com.modernjava.domain.Reviews;
import com.modernjava.util.CommonUtil;
import com.modernjava.util.LoggerUtil;

public class ReviewService {


    public Reviews retrieveReviews(String productId) {
        CommonUtil.sleep(2000);
        LoggerUtil.log("retrieveReviews after Delay");
        return new Reviews(200, 4.5);
    }
}
