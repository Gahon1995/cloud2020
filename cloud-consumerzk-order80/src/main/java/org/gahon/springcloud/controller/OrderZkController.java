package org.gahon.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author han
 * @date 2020/3/15
 **/
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderZkController {

    @Resource
    RestTemplate restTemplate;

    private final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("/payment/info")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}
