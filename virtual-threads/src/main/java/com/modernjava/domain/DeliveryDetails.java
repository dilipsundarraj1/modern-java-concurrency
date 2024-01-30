package com.modernjava.domain;

import java.util.List;

public record DeliveryDetails(List<DeliveryOptionEnum> deliveryOptions) {
}
