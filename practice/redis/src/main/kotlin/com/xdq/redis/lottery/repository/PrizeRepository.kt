package com.xdq.redis.lottery.repository

import com.xdq.redis.lottery.domain.Prize
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 *
 * @author Seven.Xu
 * @version 2021/4/25
 *
 **/
@Repository
interface PrizeRepository : MongoRepository<Prize, String> {
    fun findDistinctByName(name: String): Prize
}