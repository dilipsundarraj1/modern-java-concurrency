package com.modernjava.service;


import com.modernjava.domain.DeliveryDetails;
import com.modernjava.domain.DeliveryOptionEnum;
import com.modernjava.domain.ProductInfo;
import com.modernjava.util.CommonUtil;
import com.modernjava.util.LoggerUtil;

import java.util.List;

import static com.modernjava.util.LoggerUtil.log;

public class DeliveryService {

    public DeliveryDetails retrieveDeliveryInfo(ProductInfo productInfo){
        log("retrieving dleivery details for productInfo : " + productInfo);
        CommonUtil.sleep(1000);
        log("retrieveDeliveryInfo after Delay");
        return new DeliveryDetails(List.of(DeliveryOptionEnum.NEXT_DAY, DeliveryOptionEnum.TWO_DAY));

    }
}
