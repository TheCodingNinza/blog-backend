package com.saurabhsameer.configurations.beans;


import com.saurabhsameer.dataaccess.entities.dbgateway.MediaDBGateway;
import com.saurabhsameer.services.MediaService;
import com.saurabhsameer.services.impl.MediaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class ServiceConfig {

    @Bean
    public MediaService mediaService(final MediaDBGateway mediaDBGateway, final S3Client s3Client){
        System.out.println("Media service bean bna");
        return new MediaServiceImpl(mediaDBGateway, s3Client);
    }

}
