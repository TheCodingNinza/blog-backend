package com.saurabhsameer.services.mapper;

import com.saurabhsameer.dataaccess.entities.PostEntity;
import com.saurabhsameer.services.entities.Post;

import java.util.ArrayList;
import java.util.stream.Collectors;

public interface PostMapper {

    PostMapper MAPPER = new PostMapper() {

        @Override
        public PostEntity fromPost(Post post) {
            if(post == null)
                return null;
            PostEntity postEntity = new PostEntity();
            postEntity.setMediaList(new ArrayList<>());
            postEntity.setPostId(post.getPostId());
            postEntity.setAuthor(UserMapper.MAPPER.fromUser(post.getAuthor()));
            postEntity.setContent(post.getContent());
            postEntity.setLastModifiedAt(post.getLastModifiedAt());
            postEntity.setTitle(post.getTitle());
            postEntity.setPublishedAt(post.getPublishedAt());
            if(post.getMediaList() != null && post.getMediaList().size() > 0)
                postEntity.setMediaList(post.getMediaList().stream()
                    .map(x -> MediaMapper.MAPPER.fromMedia(x)).collect(Collectors.toList()));
            return postEntity;
        }

        @Override
        public Post fromPostEntity(PostEntity postEntity) {
            if(postEntity == null)
                return null;
            Post post = new Post();
            post.setPostId(postEntity.getPostId());
            post.setAuthor(UserMapper.MAPPER.fromUserEntity(postEntity.getAuthor()));
            post.setContent(postEntity.getContent());
            post.setLastModifiedAt(postEntity.getLastModifiedAt());
            post.setTitle(postEntity.getTitle());
            post.setPublishedAt(postEntity.getPublishedAt());
            if(postEntity.getMediaList() != null && postEntity.getMediaList().size() > 0)
                post.setMediaList(postEntity.getMediaList().stream()
                    .map(x -> MediaMapper.MAPPER.fromMediaEntity(x)).collect(Collectors.toList()));
            return post;
        }
    };

    PostEntity fromPost(Post post);
    Post fromPostEntity(PostEntity postEntity);

}
