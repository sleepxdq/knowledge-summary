package com.xdq.redis.lottery

import com.xdq.redis.lottery.repository.PrizeRepository
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Service

/**
 *
 * @author Seven.Xu
 * @version 2021/4/15
 *
 **/
@Service
class LotteryDrawService(
    private val redClient: RedissonClient,
    private val prizeRepository: PrizeRepository
) {

//    @Synchronized
    fun draw() {
        val lock = redClient.getLock("Lottery")
        if (lock.tryLock()) {
            try {
                val prize = prizeRepository.findDistinctByName("Prize1")
                prize.reduce()
                prizeRepository.save(prize)
            } finally {
                lock.unlock()
            }
        }

    }

}
