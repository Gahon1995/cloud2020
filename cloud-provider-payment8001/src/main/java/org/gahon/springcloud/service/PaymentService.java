package org.gahon.springcloud.service;

import org.apache.ibatis.annotations.Param;
import org.gahon.springcloud.entity.Payment;

/**
 * @author Gahon
 * @date 2020/3/13
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
