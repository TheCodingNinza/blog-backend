package com.saurabhsameer.dataaccess.entities.repository;

import com.saurabhsameer.dataaccess.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
