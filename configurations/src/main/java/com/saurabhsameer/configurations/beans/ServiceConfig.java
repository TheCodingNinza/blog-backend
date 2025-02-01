package com.saurabhsameer.configurations.beans;


import com.saurabhsameer.dataaccess.entities.dbgateway.MediaDBGateway;
import com.saurabhsameer.dataaccess.entities.dbgateway.PostDBGateway;
import com.saurabhsameer.dataaccess.entities.dbgateway.UserDBGateway;
import com.saurabhsameer.services.MediaService;
import com.saurabhsameer.services.PostService;
import com.saurabhsameer.services.impl.MediaServiceImpl;
import com.saurabhsameer.services.impl.PostServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class ServiceConfig {

    @Bean
    public MediaService mediaService(final MediaDBGateway mediaDBGateway, final S3Client s3Client){
        return new MediaServiceImpl(mediaDBGateway, s3Client);
    }

    @Bean
    public PostService postService(final PostDBGateway postDBGateway, final UserDBGateway userDBGateway){
        return new PostServiceImpl(postDBGateway, userDBGateway);
    }

}
