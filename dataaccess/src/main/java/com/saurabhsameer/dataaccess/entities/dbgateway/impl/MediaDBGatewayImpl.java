package com.saurabhsameer.dataaccess.entities.dbgateway.impl;

import com.saurabhsameer.dataaccess.entities.MediaEntity;
import com.saurabhsameer.dataaccess.entities.PostEntity;
import com.saurabhsameer.dataaccess.entities.dbgateway.MediaDBGateway;
import com.saurabhsameer.dataaccess.entities.repository.MediaRepository;
import com.saurabhsameer.dataaccess.entities.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MediaDBGatewayImpl implements MediaDBGateway {
    private final MediaRepository mediaRepository;
    private final PostRepository postRepository;

    public MediaDBGatewayImpl(MediaRepository mediaRepository, PostRepository postRepository) {
        this.mediaRepository = mediaRepository;
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public List<MediaEntity> getMediaList(Long postId) {
        return mediaRepository.findMediaByPostId(postId);
    }

    @Override
    @Transactional
    public void deleteMedia(Long mediaId) {
        mediaRepository.deleteById(mediaId);
    }

    @Override
    @Transactional
    public MediaEntity updateMedia(MediaEntity mediaEntity) {
        Optional<MediaEntity> foundEntity = mediaRepository.findById(mediaEntity.getMediaId());
        if(foundEntity.isEmpty())
            return null;
        MediaEntity updatedEntity = foundEntity.get();
        if(mediaEntity.getCaption() != null)
            updatedEntity.setCaption(mediaEntity.getCaption());
        if(mediaEntity.getUrl() != null)
            updatedEntity.setUrl(mediaEntity.getUrl());

        return mediaRepository.save(updatedEntity);
    }

    @Override
    @Transactional
    public MediaEntity createMedia(MediaEntity mediaEntity, Long postId) {
        Optional<PostEntity> post = null;

        if(postId != null)
            post = postRepository.findById(postId);
        if(post != null && !post.isEmpty())
            mediaEntity.setPost(post.get());
        return mediaRepository.save(mediaEntity);
    }

}
