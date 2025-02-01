package com.saurabhsameer.dataaccess.entities.repository;

import com.saurabhsameer.dataaccess.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    @Query("SELECT p FROM PostEntity p JOIN p.mediaList m WHERE m.mediaId = :mediaId")
    PostEntity findByMediaId(@Param("mediaId") Long mediaId);
}
