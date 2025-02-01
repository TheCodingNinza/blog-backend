package com.saurabhsameer.services.mapper;

import com.saurabhsameer.dataaccess.entities.UserEntity;
import com.saurabhsameer.services.entities.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserMapper {

    UserMapper MAPPER = new UserMapper() {

        @Override
        @Transactional
        public UserEntity fromUser(User user) {
            if(user == null)
                return null;
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(user.getEmail());
            userEntity.setName(user.getName());
            return userEntity;
        }

        @Override
        @Transactional
        public User fromUserEntity(UserEntity userEntity) {
            if(userEntity == null)
                return null;
            User user = new User();
            user.setUserId(userEntity.getUserId());
            user.setEmail(userEntity.getEmail());
            user.setName(userEntity.getName());
            return user;
        }
    };

    UserEntity fromUser(User user);
    User fromUserEntity(UserEntity userEntity);


}
