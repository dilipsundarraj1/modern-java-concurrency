package com.modernjava.service;


import com.modernjava.domain.DeliveryDetails;
import com.modernjava.domain.DeliveryOptionEnum;
import com.modernjava.domain.ProductInfo;
import com.modernjava.domain.Reviews;
import com.modernjava.util.CommonUtil;
import com.modernjava.util.LoggerUtil;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static com.modernjava.util.CommonUtil.objectMapper;
import static com.modernjava.util.CommonUtil.requestBuilder;
import static com.modernjava.util.LoggerUtil.log;

public class DeliveryService {

    public  static String DELIVERY_DETAILS_URL = "http://127.0.0.1:8000/virtual-threads/src/main/resources/deliveryDetails.json";
    public DeliveryDetails retrieveDeliveryInfo(ProductInfo productInfo){
        log("retrieving dleivery details for productInfo : " + productInfo);
        CommonUtil.sleep(1000);
        log("retrieveDeliveryInfo after Delay");
        return new DeliveryDetails(List.of(DeliveryOptionEnum.NEXT_DAY, DeliveryOptionEnum.TWO_DAY));

    }

    public DeliveryDetails retrieveDeliveryInfoHttp(ProductInfo productInfo) throws IOException, InterruptedException {
      return null;

    }
}
