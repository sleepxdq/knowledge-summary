package com.xdq.redis.lottery.domain

import com.xdq.redis.lottery.sleep
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 *
 * @author Seven.Xu
 * @version 2021/4/25
 *
 **/
@Document(collection = Prize.Collection.NAME)
class Prize {
    @Id
    lateinit var id: String
    lateinit var name: String

    var stock: Int = 0

    fun reduce() {
        if (stock > 0) {
            sleep()
            stock -= 1
        }
        log.info("${Thread.currentThread().name}:$stock")
    }

    object Collection {
        const val NAME = "Prize"
    }

    companion object {

        fun create(name: String, stock: Int): Prize {
            return Prize().apply {
                this.name = name
                this.stock = stock
            }
        }

        val log: Logger = LoggerFactory.getLogger("Prize")
    }
}