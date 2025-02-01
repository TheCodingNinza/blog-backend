package com.saurabhsameer.services;

import com.saurabhsameer.services.entities.Media;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public interface MediaService {
    Media createMedia(InputStream file, Media media, String format);
    Media updateMedia(Media media);
    void deleteMedia(Long mediaId);

    Media getMedia(Long mediaId);
}
