package com.xdq.consul.lottery

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import java.io.File
import kotlin.concurrent.thread

/**
 *
 * @author Seven.Xu
 * @version 2021/4/26
 *
 **/
@Service
class LotteryService(private val restTemplate: RestTemplate) {
    val url = "http://redis/redis/api/lottery/_draw"

    val log: Logger = LoggerFactory.getLogger("Draw")

    @Async
    fun draw() {
        doDraw()
    }

    private fun doDraw() {
        val result = restTemplate.postForObject(url, null, String::class.java)
        log.info("线程${Thread.currentThread().name}执行,结果:$result")
    }
}