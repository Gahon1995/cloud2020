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
public class OrderConsulController {

    @Resource
    RestTemplate restTemplate;

    private final String INVOKE_URL = "http://consul-provider-payment";

    @GetMapping("/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }
}
