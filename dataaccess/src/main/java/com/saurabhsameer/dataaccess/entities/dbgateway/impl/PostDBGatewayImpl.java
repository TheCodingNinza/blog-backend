package com.saurabhsameer.dataaccess.entities.dbgateway.impl;

import com.saurabhsameer.dataaccess.entities.MediaEntity;
import com.saurabhsameer.dataaccess.entities.PostEntity;
import com.saurabhsameer.dataaccess.entities.UserEntity;
import com.saurabhsameer.dataaccess.entities.dbgateway.PostDBGateway;
import com.saurabhsameer.dataaccess.entities.repository.MediaRepository;
import com.saurabhsameer.dataaccess.entities.repository.PostRepository;
import com.saurabhsameer.dataaccess.entities.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostDBGatewayImpl implements PostDBGateway {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    private final MediaRepository mediaRepository;

    public PostDBGatewayImpl(PostRepository postRepository, UserRepository userRepository, MediaRepository mediaRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.mediaRepository = mediaRepository;
    }

    @Override
    @Transactional
    public List<PostEntity> getPostsList() {
        return postRepository.findAll();
    }

    @Override
    @Transactional
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    @Transactional
    public PostEntity updatePost(PostEntity post) {
        PostEntity foundEntity = postRepository.findById(post.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (post.getTitle() != null)
            foundEntity.setTitle(post.getTitle());
        if (post.getContent() != null)
            foundEntity.setContent(post.getContent());

        if (post.getMediaList() != null && !post.getMediaList().isEmpty()) {
            foundEntity.getMediaList().clear();
            foundEntity.getMediaList().addAll(post.getMediaList());
        }

        return postRepository.save(foundEntity);
    }

    @Override
    @Transactional
    public PostEntity createPost(PostEntity post, Long userId) {

        post.setPublishedAt(LocalDateTime.now());
        post.setLastModifiedAt(LocalDateTime.now());
        UserEntity user = userRepository.findById(userId).orElseThrow();
        post.setAuthor(user);
        List<MediaEntity> medias = new ArrayList<>();
        for(MediaEntity media: post.getMediaList()){
            if(media.getMediaId() == null)
                throw new RuntimeException("Media id not found");
            MediaEntity foundEntity = mediaRepository.findById(media.getMediaId()).orElseThrow();
            medias.add(foundEntity);
        }
        post.setMediaList(medias);
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public PostEntity getPost(Long postId) {
        Optional<PostEntity> foundEntity = postRepository.findById(postId);
        if(!foundEntity.isEmpty())
            return foundEntity.get();
        else
            throw new RuntimeException("Not found");
    }
}
