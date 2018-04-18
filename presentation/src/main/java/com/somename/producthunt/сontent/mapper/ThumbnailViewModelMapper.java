package com.somename.producthunt.сontent.mapper;

import com.somename.data.repository.datasource.mapper.Mapper;
import com.somename.domain.model.Thumbnail;
import com.somename.producthunt.сontent.ThumbnailViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ThumbnailViewModelMapper extends Mapper<Thumbnail, ThumbnailViewModel> {

    @Inject
    public ThumbnailViewModelMapper() {
    }

    @Override
    public ThumbnailViewModel map(Thumbnail thumbnail) {
        ThumbnailViewModel thumbnailViewModel = new ThumbnailViewModel();
        thumbnailViewModel.setId(thumbnail.getId());
        thumbnailViewModel.setImageUrl(thumbnail.getImageUrl());
        return thumbnailViewModel;
    }

    @Override
    public Thumbnail reverseMap(ThumbnailViewModel thumbnailViewModel) {
        throw new UnsupportedOperationException();
    }
}
