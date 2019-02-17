package com.jnshu.task3.common.bean;

public class Banner {
    private Long id;

    private String name;

    private String img;

    private String img_url;

    private Short status;

    private Long create_at;

    private Long update_at;

    private String created_by;

    public Banner(Long id, String name, String img, String img_url, Short status, Long create_at, Long update_at, String created_by) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.img_url = img_url;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", img_url='" + img_url + '\'' +
                ", status=" + status +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public Banner() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url == null ? null : img_url.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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