package com.saurabhsameer.configurations.beans;

import com.saurabhsameer.endpoints.MediaResource;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("blog")
public class JerseyConfig extends ResourceConfig {


    @PostConstruct
    public void setUp() {
        System.out.println("registered");
        register(MediaResource.class);
    }

}
