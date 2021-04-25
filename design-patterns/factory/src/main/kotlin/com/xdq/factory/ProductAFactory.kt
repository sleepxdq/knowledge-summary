package com.xdq.factory

/**
 *
 * @author Seven.Xu
 * @version 2020/4/27
 *
 **/
class ProductAFactory : AbstractProductFactory {

    override fun createProduct(): Product {
        return ProductA()
    }

}