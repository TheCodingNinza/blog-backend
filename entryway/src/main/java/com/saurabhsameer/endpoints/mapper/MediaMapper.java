package com.saurabhsameer.endpoints.mapper;

import com.saurabhsameer.endpoints.requests.MediaRequest;
import com.saurabhsameer.endpoints.response.MediaResponse;
import com.saurabhsameer.services.entities.Media;
import com.saurabhsameer.services.entities.Post;

public interface MediaMapper {

    MediaMapper MAPPER = new MediaMapper() {
        @Override
        public MediaResponse fromMedia(Media media) {
            if(media == null)
                return null;
            MediaResponse mediaResponse = new MediaResponse();
            mediaResponse.setMediaId(media.getMediaId());
            mediaResponse.setCaption(media.getCaption());
            mediaResponse.setUrl(media.getUrl());
            return mediaResponse;
        }

        @Override
        public Media fromMediaRequest(MediaRequest mediaRequest) {
            if(mediaRequest == null)
                return null;
            Media media = new Media();
            media.setMediaId(mediaRequest.getMediaId());
            media.setUrl(mediaRequest.getUrl());
            media.setCaption(mediaRequest.getCaption());
            return media;
        }
    };
    MediaResponse fromMedia(Media media);
    Media fromMediaRequest(MediaRequest mediaRequest);


}
