package com.modernjava.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.io.IOException;

import static com.modernjava.util.LoggerUtil.log;
import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {

    @Spy
    ReviewService reviewService = new ReviewService();

    @Test
    @Disabled
    void retrieveReviews() throws IOException, InterruptedException {
        var reviews = reviewService.retrieveReviewsHttp("ABC");
        log("reviews : " + reviews);
        assertNotNull(reviews);

    }
}