package org.gahon.springcloud.config;

import ch.qos.logback.classic.joran.action.LoggerAction;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author han
 * @date 2020/3/15
 **/
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
