package org.gahon.springcloud.service.impl;

import org.gahon.springcloud.dao.PaymentDao;
import org.gahon.springcloud.entity.Payment;
import org.gahon.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Gahon
 * @date 2020/3/13
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
