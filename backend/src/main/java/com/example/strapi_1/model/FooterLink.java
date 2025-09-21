package com.example.strapi_1.model;

public class FooterLink {
    private String url;
    private String text;
    public FooterLink(String url, String text) {
        this.url = url;
        this.text = text;

    }

    public FooterLink() {

    }

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
