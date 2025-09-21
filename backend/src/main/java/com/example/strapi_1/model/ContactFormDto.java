package com.example.strapi_1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactFormDto {
    private String name;
    private String phone;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}