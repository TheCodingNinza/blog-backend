package com.saurabhsameer.dataaccess.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long postId;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<MediaEntity> mediaEntityList;

    @OneToOne(fetch = FetchType.LAZY) // Enable lazy loading
    @JoinColumn(name = "author_id", referencedColumnName = "user_id")
    private UserEntity author;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public List<MediaEntity> getMediaEntityList() {
        return mediaEntityList;
    }

    public void setMediaEntityList(List<MediaEntity> mediaEntityList) {
        this.mediaEntityList = mediaEntityList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public List<MediaEntity> getMediaList() {
        return mediaEntityList;
    }

    public void setMediaList(List<MediaEntity> mediaEntityList) {
        this.mediaEntityList = mediaEntityList;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public PostEntity() {
        this.mediaEntityList = new ArrayList<>();
    }
}
