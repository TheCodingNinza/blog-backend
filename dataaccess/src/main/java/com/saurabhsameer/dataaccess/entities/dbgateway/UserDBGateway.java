package com.saurabhsameer.dataaccess.entities.dbgateway;

import com.saurabhsameer.dataaccess.entities.UserEntity;

public interface UserDBGateway {
    UserEntity getUser(Long userId);
}
