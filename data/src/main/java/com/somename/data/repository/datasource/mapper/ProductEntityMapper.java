package com.somename.data.repository.datasource.mapper;

import com.somename.data.сontent.ProductEntity;
import com.somename.domain.model.Product;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ProductEntityMapper extends Mapper<Product, ProductEntity> {

    private final ScreeenshotUrlEntityMapper mScreeenshotUrlEntityMapper;

    @Inject
    public ProductEntityMapper(ScreeenshotUrlEntityMapper screeenshotUrlEntityMapper) {
        mScreeenshotUrlEntityMapper=screeenshotUrlEntityMapper;
    }

    @Override
    public ProductEntity map(Product value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product reverseMap(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setRedirectUrl(productEntity.getRedirectUrl());
        product.setScreenshotUrl(mScreeenshotUrlEntityMapper.reverseMap(productEntity.getScreenshotUrl()));
        product.setTagline(productEntity.getTagline());
        product.setVotesCount(productEntity.getVotesCount());
        return product;
    }
}
