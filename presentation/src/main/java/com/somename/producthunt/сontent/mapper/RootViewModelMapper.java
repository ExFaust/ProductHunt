package com.somename.producthunt.сontent.mapper;


import com.somename.data.repository.datasource.mapper.Mapper;
import com.somename.domain.model.Post;
import com.somename.domain.model.Root;
import com.somename.producthunt.сontent.PostViewModel;
import com.somename.producthunt.сontent.RootViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RootViewModelMapper extends Mapper<Root, RootViewModel> {

    private final ThumbnailViewModelMapper mThumbnailViewModelMapper;

    @Inject
    public RootViewModelMapper(ThumbnailViewModelMapper thumbnailViewModelMapper) {
        mThumbnailViewModelMapper = thumbnailViewModelMapper;
    }

    @Override
    public RootViewModel map(Root root) {
        RootViewModel rootViewModel = new RootViewModel();
        List<PostViewModel> postViewModels = new ArrayList<>();
        for (Post post: root.getPost()) {
            PostViewModel postViewModel = new PostViewModel();
            postViewModel.setName(post.getName());
            postViewModel.setTagline(post.getTagline());
            postViewModel.setThumbnailViewModel(mThumbnailViewModelMapper.map(post.getThumbnail()));
            postViewModel.setId(post.getId());
            postViewModel.setVotesCount(post.getVotesCount());
            postViewModels.add(postViewModel);
        }
        rootViewModel.setPostViewModel(postViewModels);
        return rootViewModel;
    }

    @Override
    public Root reverseMap(RootViewModel rootViewModel) {
        throw new UnsupportedOperationException();
    }
}
