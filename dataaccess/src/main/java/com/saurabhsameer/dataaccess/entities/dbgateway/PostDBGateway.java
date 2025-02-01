package com.saurabhsameer.dataaccess.entities.dbgateway;

import com.saurabhsameer.dataaccess.entities.MediaEntity;
import com.saurabhsameer.dataaccess.entities.PostEntity;
import com.saurabhsameer.dataaccess.entities.UserEntity;

import java.util.List;

public interface PostDBGateway {

    List<PostEntity> getPostsList();
    void deletePost(Long postId);
    PostEntity updatePost(PostEntity post);
    PostEntity createPost(PostEntity post, Long userId);
    PostEntity getPost(Long postId);

}
