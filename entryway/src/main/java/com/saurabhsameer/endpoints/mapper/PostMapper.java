package com.saurabhsameer.endpoints.mapper;

import com.saurabhsameer.endpoints.requests.PostRequest;
import com.saurabhsameer.endpoints.response.PostResponse;
import com.saurabhsameer.services.entities.Post;

import java.util.stream.Collectors;

public interface PostMapper {
    PostMapper Mapper  = new PostMapper() {
        @Override
        public PostResponse fromPost(Post post) {
            if(post == null)
                return null;

            PostResponse postResponse = new PostResponse();
            postResponse.setPostId(post.getPostId());
            postResponse.setAuthor(post.getAuthor());
            postResponse.setContent(post.getContent());
            postResponse.setTitle(post.getTitle());
            if(post.getMediaList() != null)
                postResponse.setMediaList(post.getMediaList().stream().map(x -> MediaMapper.MAPPER.fromMedia(x)).collect(Collectors.toList()));
            postResponse.setPublishedAt(post.getPublishedAt());
            postResponse.setLastModifiedAt(post.getLastModifiedAt());

            return postResponse;

        }

        @Override
        public Post fromPostRequest(PostRequest postRequest) {
            if(postRequest == null)
                return null;

            Post post = new Post();
            post.setPostId(postRequest.getPostId());
            post.setAuthor(postRequest.getAuthor());
            post.setContent(postRequest.getContent());
            post.setTitle(postRequest.getTitle());
            post.setMediaList(postRequest.getMediaList().stream().map(x -> MediaMapper.MAPPER.fromMediaRequest(x)).collect(Collectors.toList()));
            post.setPublishedAt(postRequest.getPublishedAt());
            post.setLastModifiedAt(postRequest.getLastModifiedAt());

            return post;
        }
    };
    PostResponse fromPost(Post post);
    Post fromPostRequest(PostRequest postRequest);
}
