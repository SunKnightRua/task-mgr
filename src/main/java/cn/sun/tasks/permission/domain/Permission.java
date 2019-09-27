package cn.sun.tasks.permission.domain;

import java.io.Serializable;

public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String url;
    private String perCode;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getPerCode() {
        return perCode;
    }
    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }
}
