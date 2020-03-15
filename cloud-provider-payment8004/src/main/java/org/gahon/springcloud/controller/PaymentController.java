package org.gahon.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author han
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public String paymentZk(){
        return "springcloud with zookeeper: "+ serverPort+"\t" + IdUtil.fastUUID();
    }



}
