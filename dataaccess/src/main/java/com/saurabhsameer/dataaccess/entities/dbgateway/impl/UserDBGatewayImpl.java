package com.saurabhsameer.dataaccess.entities.dbgateway.impl;

import com.saurabhsameer.dataaccess.entities.UserEntity;
import com.saurabhsameer.dataaccess.entities.dbgateway.UserDBGateway;
import com.saurabhsameer.dataaccess.entities.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

public class UserDBGatewayImpl implements UserDBGateway {

    private final UserRepository userRepository;

    public UserDBGatewayImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserEntity getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
