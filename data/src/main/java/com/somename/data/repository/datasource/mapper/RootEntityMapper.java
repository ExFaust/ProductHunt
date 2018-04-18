package com.somename.data.repository.datasource.mapper;


import com.somename.data.сontent.PostEntity;
import com.somename.data.сontent.RootEntity;
import com.somename.domain.model.Post;
import com.somename.domain.model.Root;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RootEntityMapper extends Mapper<Root, RootEntity> {

    private final ThumbnailEntityMapper mThumbnailEntityMapper;

    @Inject
    public RootEntityMapper(ThumbnailEntityMapper thumbnailEntityMapper) {
        mThumbnailEntityMapper = thumbnailEntityMapper;
    }

    @Override
    public RootEntity map(Root root) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Root reverseMap(RootEntity rootEntity) {
        Root root = new Root();
        List<Post> posts = new ArrayList<>();
        for (PostEntity postEntity: rootEntity.getPost()) {
            Post post = new Post();
            post.setName(postEntity.getName());
            post.setTagline(postEntity.getTagline());
            post.setThumbnail(mThumbnailEntityMapper.reverseMap(postEntity.getThumbnail()));
            post.setId(postEntity.getId());
            post.setVotesCount(postEntity.getVotesCount());
            posts.add(post);
        }
        root.setPost(posts);
        return root;
    }
}
