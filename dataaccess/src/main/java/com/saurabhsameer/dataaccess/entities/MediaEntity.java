package com.saurabhsameer.dataaccess.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "media")
public class MediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "media_id")
    private Long mediaId;
    @Column(name = "url")
    private String url;
    @Column(name = "caption")
    private String caption;

    @ManyToOne(fetch = FetchType.LAZY, optional = true) // Defines the owning side of the relationship
    @JoinColumn(name = "post_id", nullable = true)
    private PostEntity post;

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public MediaEntity() {
    }
}
