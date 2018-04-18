package com.somename.producthunt.сontent.mapper;

import com.somename.data.repository.datasource.mapper.Mapper;
import com.somename.domain.model.RootProduct;
import com.somename.producthunt.сontent.RootProductViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RootProductViewModelMapper extends Mapper<RootProduct,RootProductViewModel> {

    private final ProductViewModelMapper mProductViewModelMapper;

    @Inject
    public RootProductViewModelMapper(ProductViewModelMapper productViewModelMapper) {
        mProductViewModelMapper = productViewModelMapper;
    }

    @Override
    public RootProductViewModel map(RootProduct rootProduct) {
        RootProductViewModel rootProductViewModel = new RootProductViewModel();
        rootProductViewModel.setProductViewModel(mProductViewModelMapper.map(rootProduct.getProduct()));
        return rootProductViewModel;
    }

    @Override
    public RootProduct reverseMap(RootProductViewModel rootProductViewModel) {
        throw new UnsupportedOperationException();
    }
}
