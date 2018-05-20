package com.jiuli.campusshops.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Headline {
    private Long id;
    private String lineName;
    private String lineLink;
    private String lineImage;
    private Integer priority;
    private Boolean enable;
    private long createAt = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    private long updateAt = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineLink() {
        return lineLink;
    }

    public void setLineLink(String lineLink) {
        this.lineLink = lineLink;
    }

    public String getLineImage() {
        return lineImage;
    }

    public void setLineImage(String lineImage) {
        this.lineImage = lineImage;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }
}
