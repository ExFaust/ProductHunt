package com.somename.data.repository.datasource.mapper

import com.somename.data.сontent.ScreenshotUrlEntity
import com.somename.domain.model.ScreenshotUrl

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScreenshotUrlEntityMapper @Inject
constructor() : Mapper<ScreenshotUrl, ScreenshotUrlEntity>() {

    override fun map(value: ScreenshotUrl): ScreenshotUrlEntity {
        throw UnsupportedOperationException()
    }

    override fun reverseMap(value: ScreenshotUrlEntity): ScreenshotUrl {
        val screenshotUrl = ScreenshotUrl()
        screenshotUrl.image850px = value.image850px
        return screenshotUrl
    }
}
