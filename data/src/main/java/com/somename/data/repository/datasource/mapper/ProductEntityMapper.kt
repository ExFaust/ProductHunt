package com.somename.data.repository.datasource.mapper

import com.somename.data.сontent.ProductEntity
import com.somename.domain.model.Product

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductEntityMapper @Inject
constructor(private val mScreenshotUrlEntityMapper: ScreenshotUrlEntityMapper) : Mapper<Product, ProductEntity>() {

    override fun map(value: Product): ProductEntity {
        throw UnsupportedOperationException()
    }

    override fun reverseMap(value: ProductEntity): Product {
        val product = Product()
        product.id = value.id
        product.name = value.name
        product.redirectUrl = value.redirectUrl
        product.screenshotUrl = value.screenshotUrl?.let { mScreenshotUrlEntityMapper.reverseMap(it) }
        product.tagline = value.tagline
        product.votesCount = value.votesCount
        return product
    }
}
