package springcloud.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.service.PaymentHystrixService;

import javax.annotation.Resource;

/**
 * @author han
 * @date 2020/3/15
 **/
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

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
