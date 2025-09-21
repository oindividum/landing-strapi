package com.example.strapi_1.model;

import lombok.Data;
import java.util.List;

@Data
public class Header {
    private String logoUrl;
    private List<NavLink> navLinks;
    private String phoneNumber;


    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<NavLink> getNavLinks() {
        return navLinks;
    }

    public void setNavLinks(List<NavLink> navLinks) {
        this.navLinks = navLinks;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Header [logoUrl=" + logoUrl + "] " + "navLinks=" + navLinks + ", phoneNumber=" + phoneNumber + "]";
    }

}