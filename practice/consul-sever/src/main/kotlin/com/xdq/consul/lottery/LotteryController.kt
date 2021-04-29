package com.xdq.consul.lottery

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author Seven.Xu
 * @version 2021/4/26
 *
 **/
@RestController
class LotteryController(private val lotteryService: LotteryService) {

    @PostMapping("/_draw")
    fun draw() {
        doDraw()
    }

    private fun doDraw() {
        lotteryService.draw()
    }
}