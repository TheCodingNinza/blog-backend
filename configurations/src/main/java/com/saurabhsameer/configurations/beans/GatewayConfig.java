package com.saurabhsameer.configurations.beans;

import com.saurabhsameer.dataaccess.entities.dbgateway.MediaDBGateway;
import com.saurabhsameer.dataaccess.entities.dbgateway.PostDBGateway;
import com.saurabhsameer.dataaccess.entities.dbgateway.UserDBGateway;
import com.saurabhsameer.dataaccess.entities.dbgateway.impl.MediaDBGatewayImpl;
import com.saurabhsameer.dataaccess.entities.dbgateway.impl.PostDBGatewayImpl;
import com.saurabhsameer.dataaccess.entities.dbgateway.impl.UserDBGatewayImpl;
import com.saurabhsameer.dataaccess.entities.repository.MediaRepository;
import com.saurabhsameer.dataaccess.entities.repository.PostRepository;
import com.saurabhsameer.dataaccess.entities.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public MediaDBGateway mediaDBGateway(final MediaRepository mediaRepository, final PostRepository postRepository){
        return new MediaDBGatewayImpl(mediaRepository, postRepository);
    }

    @Bean
    public PostDBGateway postDBGateway(final PostRepository postRepository, final UserRepository userRepository, final MediaRepository mediaRepository){
        return new PostDBGatewayImpl(postRepository, userRepository, mediaRepository);
    }

    @Bean
    public UserDBGateway userDBGateway(final UserRepository userRepository){
        return new UserDBGatewayImpl(userRepository);
    }

}
