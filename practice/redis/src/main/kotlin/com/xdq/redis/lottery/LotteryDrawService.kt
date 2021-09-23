package com.xdq.redis.lottery

import com.xdq.redis.lottery.repository.PrizeRepository
import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Service
import java.util.HashMap

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
        lock.lock()
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

fun main(args: Array<String>) {
    val map = HashMap<String, String>()
    for (i in 0..19) {
        map["xdq$i"] = "xdq$i"
    }
}
