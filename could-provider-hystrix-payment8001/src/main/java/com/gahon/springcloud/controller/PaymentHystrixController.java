package com.gahon.springcloud.controller;

import com.gahon.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author han
 * @date 2020/4/5
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentHystrixController {

    @Autowired
    PaymentHystrixService paymentHystrixService;


    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String s = paymentHystrixService.paymentInfoOk(id);
        log.info("***** result： " + s);
        return s;
    }


    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String s = paymentHystrixService.paymentInfoTimeout(id);
        log.info("***** result： " + s);
        return s;
    }


}
