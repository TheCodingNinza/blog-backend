package com.saurabhsameer.dataaccess.entities.dbgateway.impl;

import com.saurabhsameer.dataaccess.entities.MediaEntity;
import com.saurabhsameer.dataaccess.entities.PostEntity;
import com.saurabhsameer.dataaccess.entities.dbgateway.MediaDBGateway;
import com.saurabhsameer.dataaccess.entities.repository.MediaRepository;
import com.saurabhsameer.dataaccess.entities.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;


public class MediaDBGatewayImpl implements MediaDBGateway {
    private final MediaRepository mediaRepository;
    private final PostRepository postRepository;

    public MediaDBGatewayImpl(MediaRepository mediaRepository, PostRepository postRepository) {
        this.mediaRepository = mediaRepository;
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public void deleteMedia(Long mediaId) {
        PostEntity postEntity = postRepository.findByMediaId(mediaId);
        if (postEntity != null) {
            postEntity.getMediaList().removeIf(media -> media.getMediaId().equals(mediaId));
            postRepository.save(postEntity); // Persist the change
        }
    }

    @Override
    @Transactional
    public MediaEntity updateMedia(MediaEntity mediaEntity) {
        if(mediaEntity.getMediaId() != null){
            MediaEntity foundEntity = mediaRepository.findById(mediaEntity.getMediaId()).orElseThrow();
            if(mediaEntity.getUrl() != null)
                foundEntity.setUrl(mediaEntity.getUrl());
            if(mediaEntity.getCaption() != null)
                foundEntity.setCaption(mediaEntity.getCaption());
        }else{
            throw new RuntimeException("Not Found!");
        }

        return mediaRepository.save(mediaEntity);
    }

    @Override
    @Transactional
    public MediaEntity createMedia(MediaEntity mediaEntity) {
        return mediaRepository.save(mediaEntity);
    }

    @Override
    @Transactional
    public MediaEntity getMedia(Long mediaId) {
        Optional<MediaEntity> foundEntity = mediaRepository.findById(mediaId);
        if(foundEntity.isEmpty())
            throw new RuntimeException("Not found");
        return foundEntity.get();
    }

}
