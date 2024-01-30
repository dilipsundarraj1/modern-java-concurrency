package com.modernjava.service;


import com.modernjava.domain.DeliveryDetails;
import com.modernjava.domain.DeliveryOptionEnum;
import com.modernjava.domain.ProductInfo;
import com.modernjava.util.CommonUtil;
import com.modernjava.util.LoggerUtil;

import java.util.List;

public class DeliveryService {

    public DeliveryDetails retrieveDeliveryInfo(ProductInfo productInfo){
        CommonUtil.sleep(1000);
        LoggerUtil.log("retrieveDeliveryInfo after Delay");
        return new DeliveryDetails(List.of(DeliveryOptionEnum.NEXT_DAY, DeliveryOptionEnum.TWO_DAY));

    }
}
