package com.saurabhsameer.services;

import com.saurabhsameer.services.entities.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    Post getPostById(Long postId);

    List<Post> getPosts();

    Post createPost(Post post);

    Post updatePost(Post post);

    void deletePost(Long postId);
}
