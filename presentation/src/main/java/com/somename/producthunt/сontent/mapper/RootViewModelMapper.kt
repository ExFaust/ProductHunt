package com.somename.producthunt.сontent.mapper


import com.somename.data.repository.datasource.mapper.Mapper
import com.somename.domain.model.Root
import com.somename.producthunt.сontent.PostViewModel
import com.somename.producthunt.сontent.RootViewModel

import java.util.ArrayList

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RootViewModelMapper @Inject
constructor(private val mThumbnailViewModelMapper: ThumbnailViewModelMapper) : Mapper<Root, RootViewModel>() {

    override fun map(value: Root): RootViewModel {
        val rootViewModel = RootViewModel()
        val postViewModels = ArrayList<PostViewModel>()
        value.post?.forEach { post ->
            val postViewModel = PostViewModel()
            postViewModel.name = post.name
            postViewModel.tagline = post.tagline
            postViewModel.thumbnailViewModel = post.thumbnail?.let { mThumbnailViewModelMapper.map(it) }
            postViewModel.id = post.id
            postViewModel.votesCount = post.votesCount
            postViewModels.add(postViewModel)
        }
        rootViewModel.postViewModel = postViewModels
        return rootViewModel
    }

    override fun reverseMap(value: RootViewModel): Root {
        throw UnsupportedOperationException()
    }
}
