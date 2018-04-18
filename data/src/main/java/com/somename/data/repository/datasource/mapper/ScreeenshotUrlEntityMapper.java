package com.somename.data.repository.datasource.mapper;

import com.somename.data.сontent.ScreenshotUrlEntity;
import com.somename.domain.model.ScreenshotUrl;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ScreeenshotUrlEntityMapper extends Mapper<ScreenshotUrl, ScreenshotUrlEntity> {

    @Inject
    public ScreeenshotUrlEntityMapper() {
    }

    @Override
    public ScreenshotUrlEntity map(ScreenshotUrl value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ScreenshotUrl reverseMap(ScreenshotUrlEntity screenshotUrlEntity) {
        ScreenshotUrl screenshotUrl = new ScreenshotUrl();
        screenshotUrl.setImage850px(screenshotUrlEntity.getImage850px());
        return screenshotUrl;
    }
}
