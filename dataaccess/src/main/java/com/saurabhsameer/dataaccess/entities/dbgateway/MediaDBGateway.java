package com.saurabhsameer.dataaccess.entities.dbgateway;

import com.saurabhsameer.dataaccess.entities.MediaEntity;
import java.util.List;
import java.util.UUID;

public interface MediaDBGateway {
        List<MediaEntity> getMediaList(Long postId);
        void deleteMedia(Long mediaId);
        MediaEntity updateMedia(MediaEntity media);

        MediaEntity createMedia(MediaEntity mediaEntity, Long postId);
}
