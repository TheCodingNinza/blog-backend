package com.saurabhsameer.services.mapper;

import com.saurabhsameer.dataaccess.entities.MediaEntity;
import com.saurabhsameer.services.entities.Media;

public interface MediaMapper {

    MediaMapper MAPPER = new MediaMapper() {
        @Override
        public MediaEntity fromMedia(Media media) {
            if(media == null)
                return null;
            MediaEntity mediaEntity = new MediaEntity();
            mediaEntity.setCaption(media.getCaption());
            mediaEntity.setUrl(media.getUrl());
            mediaEntity.getPost().setPostId(media.getPostId());
            return mediaEntity;
        }

        @Override
        public Media fromMediaEntity(MediaEntity mediaEntity) {
            if(mediaEntity == null)
                return null;
            Media media = new Media();
            media.setMediaId(mediaEntity.getMediaId());
            media.setCaption(mediaEntity.getCaption());
            media.setUrl(mediaEntity.getUrl());
            if(mediaEntity.getPost() != null)
                media.setPostId(mediaEntity.getPost().getPostId());
            return media;
        }
    };

    MediaEntity fromMedia(Media media);
    Media fromMediaEntity(MediaEntity mediaEntity);
}
