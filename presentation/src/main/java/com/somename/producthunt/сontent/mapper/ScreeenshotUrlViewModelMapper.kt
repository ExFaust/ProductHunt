package com.somename.producthunt.сontent.mapper

import com.somename.data.repository.datasource.mapper.Mapper
import com.somename.domain.model.ScreenshotUrl
import com.somename.producthunt.сontent.ScreenshotUrlViewModel

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScreeenshotUrlViewModelMapper @Inject
constructor() : Mapper<ScreenshotUrl, ScreenshotUrlViewModel>() {

    override fun map(value: ScreenshotUrl): ScreenshotUrlViewModel {
        val screenshotUrlViewModel = ScreenshotUrlViewModel()
        screenshotUrlViewModel.image850px = value.image850px
        return screenshotUrlViewModel
    }

    override fun reverseMap(value: ScreenshotUrlViewModel): ScreenshotUrl {
        throw UnsupportedOperationException()
    }
}
