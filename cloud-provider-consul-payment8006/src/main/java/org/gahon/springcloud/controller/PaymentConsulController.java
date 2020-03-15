package org.gahon.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author han
 * @date 2020/3/15
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String paymentConsul(){
        return "springcloud with consul: "+ serverPort+"\t" + IdUtil.fastUUID();
    }

}
