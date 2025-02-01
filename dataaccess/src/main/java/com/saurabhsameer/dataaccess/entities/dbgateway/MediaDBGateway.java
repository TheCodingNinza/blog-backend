package com.saurabhsameer.dataaccess.entities.dbgateway;

import com.saurabhsameer.dataaccess.entities.MediaEntity;
import java.util.List;
import java.util.UUID;

public interface MediaDBGateway {
        void deleteMedia(Long mediaId);
        MediaEntity updateMedia(MediaEntity mediaEntity);
        MediaEntity createMedia(MediaEntity mediaEntity);
        MediaEntity getMedia(Long mediaId);
}
