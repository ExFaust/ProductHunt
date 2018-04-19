package com.somename.producthunt.сontent.mapper

import com.somename.data.repository.datasource.mapper.Mapper
import com.somename.domain.model.Product
import com.somename.producthunt.сontent.ProductViewModel

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductViewModelMapper @Inject
constructor(private val mScreeenshotUrlViewModelMapper: ScreeenshotUrlViewModelMapper) : Mapper<Product, ProductViewModel>() {

    override fun map(value: Product): ProductViewModel {
        val productViewModel = ProductViewModel()
        productViewModel.id = value.id
        productViewModel.name = value.name
        productViewModel.redirectUrl = value.redirectUrl
        productViewModel.screenshotUrlViewModel = value.screenshotUrl?.let { mScreeenshotUrlViewModelMapper.map(it) }
        productViewModel.tagline = value.tagline
        productViewModel.votesCount = value.votesCount
        return productViewModel
    }

    override fun reverseMap(value: ProductViewModel): Product {
        throw UnsupportedOperationException()
    }
}
