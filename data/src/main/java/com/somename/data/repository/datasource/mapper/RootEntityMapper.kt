package com.somename.data.repository.datasource.mapper


import com.somename.data.сontent.RootEntity
import com.somename.domain.model.Post
import com.somename.domain.model.Root

import java.util.ArrayList

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RootEntityMapper @Inject
constructor(private val mThumbnailEntityMapper: ThumbnailEntityMapper) : Mapper<Root, RootEntity>() {

    override fun map(value: Root): RootEntity {
        throw UnsupportedOperationException()
    }

    override fun reverseMap(value: RootEntity): Root {
        val root = Root()
        val posts = ArrayList<Post>()
        value.post?.forEach { postEntity ->
            val post = Post()
            post.name = postEntity.name
            post.tagline = postEntity.tagline
            post.thumbnail = postEntity.thumbnail?.let { mThumbnailEntityMapper.reverseMap(it) }
            post.id = postEntity.id
            post.votesCount = postEntity.votesCount
            posts.add(post)
        }
        root.post = posts
        return root
    }
}
