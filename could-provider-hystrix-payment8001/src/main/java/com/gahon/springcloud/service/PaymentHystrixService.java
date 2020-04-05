package com.gahon.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author han
 * @date 2020/4/5
 **/
@Service
@Slf4j
public class PaymentHystrixService {

    public String paymentInfoOk(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "\t paymentInfo_OK, id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }


    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id) {
        int timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池: " + Thread.currentThread().getName()
                + "\t paymentInfoTimeout, id: " + id + "\t"
                + "O(∩_∩)O哈哈~"
                + "\t 耗时: " + timeout;
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName()
                + "\t paymentInfoTimeoutHandler, id: " + id + "\t"
                + "o(╥﹏╥)o";
    }

}
