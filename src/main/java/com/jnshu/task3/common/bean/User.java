package com.jnshu.task3.common.bean;

public class User {
    private Long id;

    private String username;

    private String password;

    private String role;

    private Long create_at;

    private Long update_at;

    private String created_by;

    public User(Long id, String username, String password, String role, Long create_at, Long update_at, String created_by) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.create_at = create_at;
        this.update_at = update_at;
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
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