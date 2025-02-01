package com.saurabhsameer.services.impl;

import com.saurabhsameer.dataaccess.entities.UserEntity;
import com.saurabhsameer.dataaccess.entities.dbgateway.PostDBGateway;
import com.saurabhsameer.dataaccess.entities.dbgateway.UserDBGateway;
import com.saurabhsameer.services.PostService;
import com.saurabhsameer.services.entities.Post;
import com.saurabhsameer.services.mapper.PostMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {

    private final PostDBGateway postDBGateway;

    private final UserDBGateway userDBGateway;

    public PostServiceImpl(PostDBGateway postDBGateway, UserDBGateway userDBGateway) {
        this.postDBGateway = postDBGateway;
        this.userDBGateway = userDBGateway;
    }


    @Override
    @Transactional
    public Post getPostById(Long postId) {
        return PostMapper.MAPPER.fromPostEntity(postDBGateway.getPost(postId));
    }

    @Override
    @Transactional
    public List<Post> getPosts() {
        return postDBGateway.getPostsList().stream().map(x -> PostMapper.MAPPER.fromPostEntity(x))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Post createPost(Post post) {
        UserEntity user = userDBGateway.getUser(1l);
        return PostMapper.MAPPER.fromPostEntity(postDBGateway.createPost(PostMapper.MAPPER.fromPost(post), 1L));
    }

    @Override
    @Transactional
    public Post updatePost(Post post) {
        return PostMapper.MAPPER.fromPostEntity(postDBGateway.updatePost(PostMapper.MAPPER.fromPost(post)));
    }
    @Override
    @Transactional
    public void deletePost(Long postId) {
        postDBGateway.deletePost(postId);
    }
}
