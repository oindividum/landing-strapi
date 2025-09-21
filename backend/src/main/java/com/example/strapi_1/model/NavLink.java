package com.example.strapi_1.model;

import lombok.Data;

@Data
public class NavLink {
    private String text;
    private String url;

    public String getText() {





        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}