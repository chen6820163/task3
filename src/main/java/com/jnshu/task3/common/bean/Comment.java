package com.jnshu.task3.common.bean;

public class Comment {
    private Long id;

    private Long w_id;

    private String content;

    private String nick;

    private Short status;

    private Long create_at;

    private Long update_at;

    private String created_by;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", w_id=" + w_id +
                ", content='" + content + '\'' +
                ", nick='" + nick + '\'' +
                ", status=" + status +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", created_by='" + created_by + '\'' +
                '}';
    }

    public Comment(Long id, Long w_id, String content, String nick, Short status, Long create_at, Long update_at, String created_by) {
        this.id = id;
        this.w_id = w_id;
        this.content = content;
        this.nick = nick;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.created_by = created_by;
    }

    public Comment() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getW_id() {
        return w_id;
    }

    public void setW_id(Long w_id) {
        this.w_id = w_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
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