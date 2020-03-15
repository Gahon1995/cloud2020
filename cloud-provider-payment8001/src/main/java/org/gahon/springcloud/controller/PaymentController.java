package org.gahon.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.gahon.springcloud.entity.CommonResult;
import org.gahon.springcloud.entity.Payment;
import org.gahon.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

/**
 * @author Gahon
 * @date 2020/3/13
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        final int result = paymentService.create(payment);
        log.info("插入结果: " + result);
        if (result > 0) {
            return new CommonResult(200, "数据库插入成功, serverPort: " + serverPort, result);
        }
        return new CommonResult(500, "插入失败, serverPort: " + serverPort);
    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        final Payment payment = paymentService.getPaymentById(id);
        if (Objects.nonNull(payment)) {
            return new CommonResult(200, "查询成功, serverPort: " + serverPort, payment);
        }
        return new CommonResult(500, "没有对应记录， 查询id： " + id + " , serverPort: " + serverPort);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        final List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:  {}", service);
        }

        final List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(
                    "instance: " + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() +
                            "\t" + instance
                            .getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLb(){
        return serverPort;
    }

}
