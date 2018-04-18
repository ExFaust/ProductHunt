package com.somename.data.repository.datasource.mapper;

import com.somename.data.сontent.ThumbnailEntity;
import com.somename.domain.model.Thumbnail;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ThumbnailEntityMapper extends Mapper<Thumbnail, ThumbnailEntity> {

    @Inject
    public ThumbnailEntityMapper() {
    }

    @Override
    public ThumbnailEntity map(Thumbnail value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Thumbnail reverseMap(ThumbnailEntity thumbnailEntity) {
        Thumbnail thumbnail = new Thumbnail();
        thumbnail.setId(thumbnailEntity.getId());
        thumbnail.setImageUrl(thumbnailEntity.getImageUrl());
        return thumbnail;
    }
}
