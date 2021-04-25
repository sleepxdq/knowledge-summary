package com.xdq.consul

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 *
 * @author Seven.Xu
 * @version 2021/4/25
 *
 **/
@SpringBootApplication
class ConsulApplication

fun main(args: Array<String>) {
    runApplication<ConsulApplication>(*args)
}