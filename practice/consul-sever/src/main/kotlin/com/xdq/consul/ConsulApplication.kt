package com.xdq.consul

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.web.client.RestTemplate

/**
 *
 * @author Seven.Xu
 * @version 2021/4/25
 *
 **/
@SpringBootApplication
@EnableAsync
class ConsulApplication {

    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate {
        return RestTemplateBuilder().build()
    }

}

fun main(args: Array<String>) {
    runApplication<ConsulApplication>(*args)
}