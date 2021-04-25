package com.xdq.redis.lottery

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.concurrent.thread

/**
 *
 * @author Seven.Xu
 * @version 2021/4/15
 *
 **/
@RestController
@RequestMapping("/api/lottery")
class LotteryDrawApi(
    private val drawService: LotteryDrawService
) {

    @PostMapping("/_draw")
    fun draw() {
        var i = 120
        while (i > 0) {
            drawService.draw()
            i--
        }
    }
}