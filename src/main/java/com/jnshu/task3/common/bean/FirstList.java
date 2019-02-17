package com.jnshu.task3.common.bean;

public class FirstList {
    private Long id;

    private String name;

    private Short status;

    private Long create_at;

    private Long update_at;

    private String created_by;

    @Override
    public String toString() {
        return "FirstList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public FirstList(Long id, String name, Short status, Long create_at, Long update_at, String created_by) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.created_by = created_by;
    }

    public FirstList() {
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