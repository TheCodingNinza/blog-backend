package com.saurabhsameer.endpoints.requests;

import com.saurabhsameer.services.entities.Post;

import java.util.UUID;

public class MediaRequest {
    private Long mediaId;
    private String url;
    private String caption;
    private String format;

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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

}
