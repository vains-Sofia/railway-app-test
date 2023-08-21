package com.example.config;

import com.example.exchange.MineExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * Http Interface注入ioc配置
 *
 * @author vains
 */
@Configuration
public class ExchangeBeanConfig {

    /**
     * 注入MineExchange
     *
     * @return MineExchange
     */
    @Bean
    public MineExchange mineExchange() {
        WebClient webClient = WebClient.builder().baseUrl("https://api-flow.bunnyenv.com").build();
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();
        return httpServiceProxyFactory.createClient(MineExchange.class);
    }

}
