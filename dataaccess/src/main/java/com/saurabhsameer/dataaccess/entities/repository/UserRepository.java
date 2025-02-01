package com.saurabhsameer.dataaccess.entities.repository;

import com.saurabhsameer.dataaccess.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
}
