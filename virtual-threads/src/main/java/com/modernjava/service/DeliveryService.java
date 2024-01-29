package com.modernjava.service;

import com.domain.DeliveryDetails;
import com.domain.DeliveryOptionEnum;
import com.domain.ProductInfo;
import com.util.CommonUtil;

import java.util.List;

public class DeliveryService {

    public DeliveryDetails retrieveDeliveryInfo(ProductInfo productInfo){
        CommonUtil.sleep(1000);
        return new DeliveryDetails(List.of(DeliveryOptionEnum.NEXT_DAY, DeliveryOptionEnum.TWO_DAY));

    }
}
