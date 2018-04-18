package com.somename.producthunt.сontent.mapper;

import com.somename.data.repository.datasource.mapper.Mapper;
import com.somename.domain.model.Product;
import com.somename.producthunt.сontent.ProductViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ProductViewModelMapper extends Mapper<Product, ProductViewModel> {

    private final ScreeenshotUrlViewModelMapper mScreeenshotUrlViewModelMapper;

    @Inject
    public ProductViewModelMapper(ScreeenshotUrlViewModelMapper screeenshotUrlViewModelMapper) {
        mScreeenshotUrlViewModelMapper = screeenshotUrlViewModelMapper;
    }

    @Override
    public ProductViewModel map(Product product) {
        ProductViewModel productViewModel = new ProductViewModel();
        productViewModel.setId(product.getId());
        productViewModel.setName(product.getName());
        productViewModel.setRedirectUrl(product.getRedirectUrl());
        productViewModel.setScreenshotUrlViewModel(mScreeenshotUrlViewModelMapper.map(product.getScreenshotUrl()));
        productViewModel.setTagline(product.getTagline());
        productViewModel.setVotesCount(product.getVotesCount());
        return productViewModel;
    }

    @Override
    public Product reverseMap(ProductViewModel productViewModel) {
        throw new UnsupportedOperationException();
    }
}
