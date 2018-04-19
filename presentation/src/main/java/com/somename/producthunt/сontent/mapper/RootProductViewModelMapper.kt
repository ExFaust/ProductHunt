package com.somename.producthunt.сontent.mapper

import com.somename.data.repository.datasource.mapper.Mapper
import com.somename.domain.model.RootProduct
import com.somename.producthunt.сontent.RootProductViewModel

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RootProductViewModelMapper @Inject
constructor(private val mProductViewModelMapper: ProductViewModelMapper) : Mapper<RootProduct, RootProductViewModel>() {

    override fun map(value: RootProduct): RootProductViewModel {
        val rootProductViewModel = RootProductViewModel()
        rootProductViewModel.productViewModel = value.product?.let { mProductViewModelMapper.map(it) }
        return rootProductViewModel
    }

    override fun reverseMap(value: RootProductViewModel): RootProduct {
        throw UnsupportedOperationException()
    }
}
