package com.somename.data.repository.datasource.mapper;

import com.somename.data.сontent.RootProductEntity;
import com.somename.domain.model.RootProduct;


import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RootProductEntityMapper extends Mapper<RootProduct,RootProductEntity>{

    private final ProductEntityMapper mProductEntityMapper;

    @Inject
    public RootProductEntityMapper(ProductEntityMapper productEntityMapper) {
        mProductEntityMapper = productEntityMapper;
    }

    @Override
    public RootProductEntity map(RootProduct rootProduct) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RootProduct reverseMap(RootProductEntity rootProductEntity) {
        RootProduct rootProduct = new RootProduct();
        rootProduct.setProduct(mProductEntityMapper.reverseMap(rootProductEntity.getProduct()));
        return rootProduct;
    }
}
