package com.example.strapi_1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



public class LandingPageContent {


    private String title;
    private String description;
    private String buttonText;
    private String heroImageUrl;
    private String buttonUrl;

    public LandingPageContent(String title, String description, String buttonText, String heroImageUrl, String buttonUrl) {
        this.title = title;
        this.description = description;
        this.buttonText = buttonText;
        this.heroImageUrl = heroImageUrl;
        this.buttonUrl= buttonUrl;

    }

    public LandingPageContent() {}
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
public String getButtonText() {
        return buttonText;
}
public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
}
public String getHeroImageUrl() {
        return heroImageUrl;
}
public void setHeroImageUrl(String heroImageUrl) {
        this.heroImageUrl = heroImageUrl;
}
public String getButtonUrl() {
    return buttonUrl;
}
public void setButtonUrl(String buttonUrl) {
        this.buttonUrl = buttonUrl;
}



    @Override
    public String toString() {
        return "LandingPageContent [title=" + title + ", description=" + description + ", buttonText="
                + buttonText + ", heroImageUrl=" + heroImageUrl + ", buttonUrl=" + buttonUrl + '}';

    }
}
