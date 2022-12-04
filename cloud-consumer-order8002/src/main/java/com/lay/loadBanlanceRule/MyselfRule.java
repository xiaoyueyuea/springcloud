package com.lay.loadBanlanceRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Ribbon自定义负载均衡策略配置不能和启动类在同一包下
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();//Ribbon负载均衡策略自定义为随机，默认为轮询
    }
}
