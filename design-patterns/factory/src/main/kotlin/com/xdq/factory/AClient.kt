package com.xdq.factory

/**
 *
 * @author Seven.Xu
 * @version 2020/4/27
 *
 **/
fun main() {
    val factory = ProductAFactory()
    val product = factory.createProduct()
    product.service()
}

