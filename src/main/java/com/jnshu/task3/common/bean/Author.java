package com.jnshu.task3.common.bean;

public class Author {
    private Long id;

    private String name;

    private Long tel;

    private String img;

    private String content;

    private Short type;

    private Short status;

    private Long create_at;

    private Long update_at;

    private String created_by;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel=" + tel +
                ", img='" + img + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public Author(Long id, String name, Long tel, String img, String content, Short type, Short status, Long create_at, Long update_at, String created_by) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.img = img;
        this.content = content;
        this.type = type;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.created_by = created_by;
    }

    public Author() {
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

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
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