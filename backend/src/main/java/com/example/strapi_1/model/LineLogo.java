package com.example.strapi_1.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineLogo {
    private String lineLogoUrl;


    public String getLineLogoUrl() {
        return lineLogoUrl;
    }

    public void setLineLogoUrl(String lineLogoUrl) {
        this.lineLogoUrl = lineLogoUrl;
    }
}
