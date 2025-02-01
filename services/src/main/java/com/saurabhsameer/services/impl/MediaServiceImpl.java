package com.saurabhsameer.services.impl;

import com.saurabhsameer.dataaccess.entities.MediaEntity;
import com.saurabhsameer.dataaccess.entities.dbgateway.MediaDBGateway;
import com.saurabhsameer.services.MediaService;
import com.saurabhsameer.services.entities.Media;
import com.saurabhsameer.services.mapper.MediaMapper;
import org.springframework.transaction.annotation.Transactional;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class MediaServiceImpl implements MediaService {
    private final MediaDBGateway mediaDBGateway;

    private final S3Client s3Client;

    public MediaServiceImpl(MediaDBGateway mediaDBGateway, S3Client s3Client) {
        this.mediaDBGateway = mediaDBGateway;
        this.s3Client = s3Client;
    }

    @Override
    @Transactional
    public Media createMedia(InputStream file, Media media, String format) {
        String fileName = UUID.randomUUID() + "."+format;

        // Upload the file to S3
        String bucketName = "blog-backend-saurabh";
        try{

            // Upload the file to S3
            s3Client.putObject(PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(fileName)
                            .build(),
                    software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.readAllBytes()));

            // Generate S3 URL
            String fileUrl = String.format("https://%s.s3.amazonaws.com/%s", bucketName, fileName);;
            MediaEntity mediaEntity = new MediaEntity();
            mediaEntity.setUrl(fileUrl);
            mediaEntity.setCaption(media.getCaption());
            MediaEntity savedEntity = mediaDBGateway.createMedia(mediaEntity);
            return MediaMapper.MAPPER.fromMediaEntity(savedEntity);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public Media updateMedia(Media media) {

        MediaEntity savedEntity = mediaDBGateway.updateMedia(MediaMapper.MAPPER.fromMedia(media));
        return MediaMapper.MAPPER.fromMediaEntity(savedEntity);
    }

    @Override
    @Transactional
    public void deleteMedia(Long mediaId) {
        mediaDBGateway.deleteMedia(mediaId);
    }

    @Override
    public Media getMedia(Long mediaId) {
        return MediaMapper.MAPPER.fromMediaEntity(mediaDBGateway.getMedia(mediaId));
    }


}
