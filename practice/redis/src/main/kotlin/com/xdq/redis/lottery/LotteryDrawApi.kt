package com.xdq.redis.lottery

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
        drawService.draw()
    }
}