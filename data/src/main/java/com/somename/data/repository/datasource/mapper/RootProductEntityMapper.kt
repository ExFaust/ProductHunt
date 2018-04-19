package com.somename.data.repository.datasource.mapper

import com.somename.data.сontent.RootProductEntity
import com.somename.domain.model.RootProduct


import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RootProductEntityMapper @Inject
constructor(private val mProductEntityMapper: ProductEntityMapper) : Mapper<RootProduct, RootProductEntity>() {

    override fun map(value: RootProduct): RootProductEntity {
        throw UnsupportedOperationException()
    }

    override fun reverseMap(value: RootProductEntity): RootProduct {
        val rootProduct = RootProduct()
        rootProduct.product = value.product?.let { mProductEntityMapper.reverseMap(it) }
        return rootProduct
    }
}
