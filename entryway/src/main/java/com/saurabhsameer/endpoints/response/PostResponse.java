package com.saurabhsameer.endpoints.response;

import com.saurabhsameer.services.entities.Media;
import com.saurabhsameer.services.entities.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostResponse {
    private Long postId;
    private String title;
    private String content;
    private LocalDateTime publishedAt;
    private LocalDateTime lastModifiedAt;
    private List<MediaResponse> mediaList;

    private User author;

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
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

    public List<MediaResponse> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<MediaResponse> mediaList) {
        this.mediaList = mediaList;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public PostResponse() {
        this.mediaList = new ArrayList<>();
    }
}
