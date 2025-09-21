package com.example.strapi_1.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


    public class Footer {
    private String logoText;
        private String logoUrl;
        private String description;
        private String pagesTitle;
        private List<FooterLink> pageLinks = new ArrayList<>();
        private String contactTitle;

        private String hoursTitle;
        private List<WorkingDay> workHours = new ArrayList<>();
        private String copyrightText;
        private List<FooterLink> policyLinks = new ArrayList<>();
        private List<SocialLink> socialLinks = new ArrayList<>();

private List<ContactItem> contactItems = new ArrayList<>();

    public Footer() {}

        public List<ContactItem> getContactItems() {
            return contactItems;
        }

        public void setContactItems(List<ContactItem> contactItems) {
            this.contactItems = contactItems;
        }

        public String getLogoText() {
        return logoText;
    }

    public void setLogoText(String logoText) {
        this.logoText = logoText;
    }


        public String getContactTitle() {
            return contactTitle;
        }

        public void setContactTitle(String contactTitle) {
            this.contactTitle = contactTitle;
        }

        public String getCopyrightText() {
            return copyrightText;
        }

        public void setCopyrightText(String copyrightText) {
            this.copyrightText = copyrightText;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getHoursTitle() {
            return hoursTitle;
        }

        public void setHoursTitle(String hoursTitle) {
            this.hoursTitle = hoursTitle;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public List<FooterLink> getPageLinks() {
            return pageLinks;
        }

        public void setPageLinks(List<FooterLink> pageLinks) {
            this.pageLinks = pageLinks;
        }

        public String getPagesTitle() {
            return pagesTitle;
        }

        public void setPagesTitle(String pagesTitle) {
            this.pagesTitle = pagesTitle;
        }

        public List<FooterLink> getPolicyLinks() {
            return policyLinks;
        }

        public void setPolicyLinks(List<FooterLink> policyLinks) {
            this.policyLinks = policyLinks;
        }

        public List<SocialLink> getSocialLinks() {
            return socialLinks;
        }

        public void setSocialLinks(List<SocialLink> socialLinks) {
            this.socialLinks = socialLinks;
        }

        public List<WorkingDay> getWorkHours() {
            return workHours;
        }

        public void setWorkHours(List<WorkingDay> workHours) {
            this.workHours = workHours;
        }


    @Override
    public String toString() {
        return "Footer{" +
                "contactInfo=" + contactItems +
                ", logoText='" + logoText + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", description='" + description + '\'' +
                ", pagesTitle='" + pagesTitle + '\'' +
                ", pageLinks=" + pageLinks +
                ", contactTitle='" + contactTitle + '\'' +
                ", hoursTitle='" + hoursTitle + '\'' +
                ", workHours=" + workHours +
                ", copyrightText='" + copyrightText + '\'' +
                ", policyLinks=" + policyLinks +
                ", socialLinks=" + socialLinks +
                '}';
    }
}
