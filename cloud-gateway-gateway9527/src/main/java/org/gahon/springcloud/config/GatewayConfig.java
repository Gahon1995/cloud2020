package org.gahon.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gahon
 * @date 2020/5/15
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        final RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_gahon",
                     predicateSpec -> predicateSpec.path("/guonei")
                                                   .uri("https://news.baidu.com/guonei"));

        routes.route("path_route_gahon_guoji",
                     predicateSpec -> predicateSpec.path("/guoji")
                                                   .uri("https://news.baidu.com/guoji"));

        return routes.build();
    }

}
