package com.somename.producthunt.сontent.mapper;

import com.somename.data.repository.datasource.mapper.Mapper;
import com.somename.data.сontent.ScreenshotUrlEntity;
import com.somename.domain.model.ScreenshotUrl;
import com.somename.producthunt.сontent.ScreenshotUrlViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ScreeenshotUrlViewModelMapper extends Mapper<ScreenshotUrl, ScreenshotUrlViewModel> {

    @Inject
    public ScreeenshotUrlViewModelMapper() {
    }

    @Override
    public ScreenshotUrlViewModel map(ScreenshotUrl screenshotUrl) {
        ScreenshotUrlViewModel screenshotUrlViewModel = new ScreenshotUrlViewModel();
        screenshotUrlViewModel.setImage850px(screenshotUrl.getImage850px());
        return screenshotUrlViewModel;
    }

    @Override
    public ScreenshotUrl reverseMap(ScreenshotUrlViewModel screenshotUrlViewModel) {
        throw new UnsupportedOperationException();
    }
}
