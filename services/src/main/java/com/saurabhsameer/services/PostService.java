package com.saurabhsameer.services;

import com.saurabhsameer.services.entities.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    Post getPostById(UUID postId);

    List<Post> getPosts();

    void createPost(Post post);

    void updatePost(Post post);

    void deletePost(UUID postId);
}
