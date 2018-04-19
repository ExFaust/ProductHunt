package com.somename.data.repository.datasource.mapper


import com.somename.data.сontent.ThumbnailEntity
import com.somename.domain.model.Thumbnail
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThumbnailEntityMapper @Inject
constructor() : Mapper<Thumbnail, ThumbnailEntity>() {

    override fun map(value: Thumbnail): ThumbnailEntity {
        throw UnsupportedOperationException()
    }

    override fun reverseMap(value: ThumbnailEntity): Thumbnail {
        val thumbnail = Thumbnail()
        thumbnail.id = value.id
        thumbnail.imageUrl = value.imageUrl
        return thumbnail
    }
}
