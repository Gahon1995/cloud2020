package org.gahon.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author han
 * @date 2020/3/15
 **/
@Configuration
public class MySelfRule {

    @Bean
    IRule myRule(){
        return new RandomRule();
    }

}
