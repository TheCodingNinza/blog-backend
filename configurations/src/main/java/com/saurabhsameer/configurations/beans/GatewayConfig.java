package com.saurabhsameer.configurations.beans;

import com.saurabhsameer.dataaccess.entities.dbgateway.MediaDBGateway;
import com.saurabhsameer.dataaccess.entities.dbgateway.impl.MediaDBGatewayImpl;
import com.saurabhsameer.dataaccess.entities.repository.MediaRepository;
import com.saurabhsameer.dataaccess.entities.repository.PostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public MediaDBGateway mediaDBGateway(final MediaRepository mediaRepository, final PostRepository postRepository){
        return new MediaDBGatewayImpl(mediaRepository, postRepository);
    }

}
