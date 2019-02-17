package com.jnshu.task3.common.bean;

public class Work {
    private Long id;

    private Long s_id;

    private String name;

    private Short status;

    private String introduction;

    private String thumbnail;

    private String url;

    private String content;

    private Long create_at;

    private Long update_at;

    private String created_by;

    public Work(Long id, Long s_id, String name, Short status, String introduction, String thumbnail, String url, String content, Long create_at, Long update_at, String created_by) {
        this.id = id;
        this.s_id = s_id;
        this.name = name;
        this.status = status;
        this.introduction = introduction;
        this.thumbnail = thumbnail;
        this.url = url;
        this.content = content;
        this.create_at = create_at;
        this.update_at = update_at;
        this.created_by = created_by;
    }

    public Work() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by == null ? null : created_by.trim();
    }
}