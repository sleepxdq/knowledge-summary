package com.xdq.redis.lottery

import com.xdq.redis.lottery.repository.PrizeRepository
import org.redisson.api.RedissonClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 *
 * @author Seven.Xu
 * @version 2021/4/15
 *
 **/
@Service
class LotteryDrawService(
    private val client: RedissonClient,
    private val prizeRepository: PrizeRepository
) {

    fun draw() {
        val prize = prizeRepository.findDistinctByName("Prize1")
        prize.reduce()
        prizeRepository.save(prize)
    }

}

fun sleep() {
    Thread.sleep(10)
}
