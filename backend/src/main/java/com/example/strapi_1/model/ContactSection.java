package com.example.strapi_1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContactSection {

    private String title;
    private String description;
    private String backgroundImage;
    private String namePlaceholder;
    private String phonePlaceholder;
    private String messagePlaceholder;

            private String buttonText;

    public ContactSection() {
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessagePlaceholder() {
        return messagePlaceholder;
    }

    public void setMessagePlaceholder(String messagePlaceholder) {
        this.messagePlaceholder = messagePlaceholder;
    }

    public String getNamePlaceholder() {
        return namePlaceholder;
    }

    public void setNamePlaceholder(String namePlaceholder) {
        this.namePlaceholder = namePlaceholder;
    }

    public String getPhonePlaceholder() {
        return phonePlaceholder;
    }

    public void setPhonePlaceholder(String phonePlaceholder) {
        this.phonePlaceholder = phonePlaceholder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override


        public String toString() {
            return "ContactSection{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", namePlaceholder='" + namePlaceholder + '\'' +
                ", phonePlaceholder='" + phonePlaceholder + '\'' +
                ", messagePlaceholder='" + messagePlaceholder + '\'' +
                ", buttonText='" + buttonText + '\'' +
                '}';
    }



}