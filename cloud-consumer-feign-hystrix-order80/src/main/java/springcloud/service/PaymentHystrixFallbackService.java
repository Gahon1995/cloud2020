package springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author han
 * @date 2020/4/5
 **/
@Service
public class PaymentHystrixFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "访问超时";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "访问超时";
    }
}
