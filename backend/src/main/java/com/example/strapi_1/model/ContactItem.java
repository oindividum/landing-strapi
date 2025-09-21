package com.example.strapi_1.model;

public class ContactItem {
    private String iconUrl;
    private String value;
    private String type;

public ContactItem() {}
    public ContactItem(String iconUrl, String value, String type) {
        this.iconUrl = iconUrl;
        this.value = value;
        this.type = type;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ContactItem{" +
                "iconUrl='" + iconUrl + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
