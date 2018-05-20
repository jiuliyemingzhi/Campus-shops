package com.jiuli.campusshops.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Area {
    private Integer id;
    private String name;
    private Integer priority;
    private long createAt = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    private long updateAt = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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
