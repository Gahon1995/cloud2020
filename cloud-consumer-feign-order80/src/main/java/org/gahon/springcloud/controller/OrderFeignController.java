package org.gahon.springcloud.controller;

import org.gahon.springcloud.entity.CommonResult;
import org.gahon.springcloud.entity.Payment;
import org.gahon.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author han
 * @date 2020/3/15
 **/
@RestController
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

}
