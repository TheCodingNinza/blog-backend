package com.saurabhsameer.services.impl;

import com.saurabhsameer.services.PostService;
import com.saurabhsameer.services.entities.Post;

import java.util.List;
import java.util.UUID;

public class PostServiceImpl implements PostService {
    @Override
    public Post getPostById(UUID postId) {
        return null;
    }

    @Override
    public List<Post> getPosts() {
        return null;
    }

    @Override
    public void createPost(Post post) {

    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePost(UUID postId) {

    }
}
