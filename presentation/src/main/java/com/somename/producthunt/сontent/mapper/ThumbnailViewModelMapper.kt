package com.somename.producthunt.сontent.mapper

import com.somename.data.repository.datasource.mapper.Mapper
import com.somename.domain.model.Thumbnail
import com.somename.producthunt.сontent.ThumbnailViewModel

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThumbnailViewModelMapper @Inject
constructor() : Mapper<Thumbnail, ThumbnailViewModel>() {

    override fun map(value: Thumbnail): ThumbnailViewModel {
        val thumbnailViewModel = ThumbnailViewModel()
        thumbnailViewModel.id = value.id
        thumbnailViewModel.imageUrl = value.imageUrl
        return thumbnailViewModel
    }

    override fun reverseMap(value: ThumbnailViewModel): Thumbnail {
        throw UnsupportedOperationException()
    }
}
