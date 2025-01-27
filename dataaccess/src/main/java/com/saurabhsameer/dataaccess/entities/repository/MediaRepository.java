package com.saurabhsameer.dataaccess.entities.repository;

import com.saurabhsameer.dataaccess.entities.MediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MediaRepository extends JpaRepository<MediaEntity, Long> {

    @Query("SELECT m FROM MediaEntity m WHERE m.post.postId = :postId")
    List<MediaEntity> findMediaByPostId(@Param("postId") Long postId);
}
