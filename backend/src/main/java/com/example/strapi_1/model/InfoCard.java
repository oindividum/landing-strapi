package com.example.strapi_1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoCard {


    private String number;
    private String title;
    private String description;

    public InfoCard ( String number, String title, String description) {
        this.number = number;
        this.title = title;
        this.description = description;

    }
    public InfoCard() {

    }
    public String getNumber() {
        return number;

    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}