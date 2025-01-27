package com.saurabhsameer.starter;

import com.saurabhsameer.configurations.beans.ConfigurationsModuleBase;
import com.saurabhsameer.dataaccess.entities.MediaEntity;
import com.saurabhsameer.dataaccess.entities.repository.MediaRepository;
import com.saurabhsameer.endpoints.EntrywayModuleBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScans(@ComponentScan(basePackageClasses = {ConfigurationsModuleBase.class, EntrywayModuleBase.class}))
@EnableJpaRepositories(basePackageClasses = MediaRepository.class)
@EntityScan(basePackageClasses = MediaEntity.class)
public class Blog {
    public static void main(String[] args) {
        SpringApplication.run(Blog.class, args);
    }
}