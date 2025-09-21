package com.example.strapi_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;





@Getter
@Setter
public class AboutSection {

    private String headerTitle;
    private String headerDescription;
    private List<InfoCard> infoCards;
    private String image1Url;
    private String image2Url;
    private String image3Url;


    public AboutSection() {}
    public AboutSection(String headerTitle, String headerDescription) {
        this.headerTitle = headerTitle;
        this.headerDescription = headerDescription;

    }
    public AboutSection(String headerTitle, String headerDescription, List<InfoCard> infoCards) {
        this.headerTitle = headerTitle;
        this.headerDescription = headerDescription;
        this.infoCards = new ArrayList<>();

    }
    public String getHeaderTitle() {
        return headerTitle;
    }
    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;

    }
    public String getHeaderDescription() {
        return headerDescription;
    }
    public void setHeaderDescription(String headerDescription) {
        this.headerDescription = headerDescription;

    }
    public List<InfoCard> getInfoCards() {
        return infoCards;
    }
    public void setInfoCards(List<InfoCard> infoCards) {
        this.infoCards = infoCards;
    }
    public String getImage1Url() {
        return image1Url;

    }
    public void setImage1Url(String image1Url) {
        this.image1Url = image1Url;
    }
    public String getImage2Url() {
        return image2Url;
    }
    public void setImage2Url(String image2Url) {
        this.image2Url = image2Url;
    }
    public String getImage3Url() {
        return image3Url;
    }
    public void setImage3Url(String image3Url) {
        this.image3Url = image3Url;
    }


    @Override
    public String toString (){
        return "AboutSection [headerTitle=" + headerTitle + ", headerDescription=" + headerDescription + ", infoCards=" + infoCards + "]";
    }

}