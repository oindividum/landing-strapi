package com.example.strapi_1.service;

import com.example.strapi_1.model.*;
import com.example.strapi_1.model.ContactItem;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import com.example.strapi_1.model.Footer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class StrapiService {

    private final String BASE_URL = "http://localhost:1337/api/";
    private final RestTemplate restTemplate = new RestTemplate();

    private Map<String, Object> getStrapiData(String endpoint) {
        String url = BASE_URL + endpoint;
        try {
            return restTemplate.getForObject(url, Map.class);
        } catch (Exception e) {
            System.err.println("Ошибка: " + url + " | " + e.getMessage());
            return null;
        }
    }


    public Header getHeaderContent() {
        Map<String, Object> response = getStrapiData("header?populate=*");
        Header header = new Header();

        if (response == null || response.get("data") == null) {
            return header;
        }
        Map<String, Object> data = (Map<String, Object>) response.get("data");
        Map<String, Object> attributes;

        if (data.containsKey("attributes")) {
            attributes = (Map<String, Object>) data.get("attributes");
        } else {
            attributes = data;
        }

        if (attributes == null) {
            return header;
        }

//        System.out.println("debug" + attributes.get("logo"));

        Object logoDataObj = attributes.get("logo");
        if (logoDataObj instanceof java.util.List) {
            List<Map<String, Object>> logoList = (List<Map<String, Object>>) logoDataObj;
            if (!logoList.isEmpty()) {
                Map<String, Object> imageDetails = logoList.get(0);
                if (imageDetails != null && imageDetails.containsKey("url")) {
                    String partialUrl = String.valueOf(imageDetails.get("url"));
                    header.setLogoUrl("http://localhost:1337" + partialUrl);
                }
            }

        }


        List<Map<String, Object>> navLinksData = (List<Map<String, Object>>) attributes.get("nav_links");
        List<NavLink> navLinks = new ArrayList<>();
        if (navLinksData != null) {
            for (Map<String, Object> linkData : navLinksData) {
                NavLink navLink = new NavLink();
                navLink.setText((String) linkData.get("text"));
                navLink.setUrl((String) linkData.get("url"));
                navLinks.add(navLink);
            }
        }
        header.setNavLinks(navLinks);
        header.setPhoneNumber((String) attributes.get("phone_number"));
        return header;
    }


    public LandingPageContent getLandingPageContent() {
        Map<String, Object> response = getStrapiData("landing-page?populate=*");

        if (response == null || response.get("data") == null) {
            return new LandingPageContent();
        }

        Map<String, Object> contentData = (Map<String, Object>) response.get("data");

        LandingPageContent content = new LandingPageContent();
        content.setTitle((String) contentData.get("title"));
        content.setDescription((String) contentData.get("description"));
        content.setButtonText((String) contentData.get("button_text"));
        content.setButtonUrl((String) contentData.get("button_url"));

        Object imageDataObj = contentData.get("hero_image");

        if (imageDataObj instanceof java.util.List) {
            List<Map<String, Object>> imageList = (List<Map<String, Object>>) imageDataObj;
            if (!imageList.isEmpty()) {
                Map<String, Object> imageDetails = imageList.get(0);
                if (imageDetails != null && imageDetails.get("url") != null) {
                    content.setHeroImageUrl("http://localhost:1337" + imageDetails.get("url"));
                }
            }
        }

        return content;
    }


    public AboutSection getAboutSection() {
        Map<String, Object> response = getStrapiData("about-section?populate=*");

        if (response == null || response.get("data") == null) {
            return new AboutSection();
        }


        Map<String, Object> data = (Map<String, Object>) response.get("data");
        AboutSection about = new AboutSection();

        AboutSection aboutSection = new AboutSection();

        aboutSection.setHeaderTitle((String) data.get("header_title"));
        aboutSection.setHeaderDescription((String) data.get("header_description"));


        List<Map<String, Object>> cardsData = (List<Map<String, Object>>) data.get("info_card");
        List<InfoCard> cards = new ArrayList<>();
        if (cardsData != null) {
            for (Map<String, Object> cardData : cardsData) {
                InfoCard card = new InfoCard();
//                System.out.println("cardsData" + cardsData);
                card.setNumber((String) cardData.get("number"));
                card.setTitle((String) cardData.get("title"));
                card.setDescription((String) cardData.get("description"));
                cards.add(card);
            }
        }


        aboutSection.setInfoCards(cards);

        List<Map<String, Object>> image1List = (List<Map<String, Object>>) data.get("image_1");
        if (image1List != null && !image1List.isEmpty()) {
            Map<String, Object> imageObject = (Map<String, Object>) image1List.get(0);
            if (imageObject.get("url") != null) {
                aboutSection.setImage1Url("http://localhost:1337" + String.valueOf(imageObject.get("url")));


            }
        }

        List<Map<String, Object>> image2List = (List<Map<String, Object>>) data.get("image_2");
        if (image1List != null && !image1List.isEmpty()) {
            Map<String, Object> imageObject = (Map<String, Object>) image2List.get(0);
            if (imageObject.get("url") != null) {
                aboutSection.setImage2Url("http://localhost:1337" + String.valueOf(imageObject.get("url")));

            }
        }

        List<Map<String, Object>> image3List = (List<Map<String, java.lang.Object>>) data.get("image_3");
        if (image1List != null && !image1List.isEmpty()) {
            Map<String, Object> imageObject = (Map<String, Object>) image3List.get(0);
            if (imageObject.get("url") != null) {
                aboutSection.setImage3Url("http://localhost:1337" + String.valueOf(imageObject.get("url")));

            }
        }
        return aboutSection;
    }


    public List<Product> getProducts() {
        Map<String, Object> response = getStrapiData("products?populate=*");

        List<Product> productList = new ArrayList<>();
        if (response == null || response.get("data") == null) {
            return productList;
        }
        List<Map<String, Object>> productsData = (List<Map<String, Object>>) response.get("data");
        for (Map<String, Object> productData : productsData) {
            Product product = new Product();
            product.setName((String) productData.get("name"));
            product.setPrice((String) productData.get("price"));

            Object imageDataObj = productData.get("image");
            if (imageDataObj instanceof java.util.List) {
                List<Map<String, Object>> imageList = (List<Map<String, Object>>) imageDataObj;
                if (!imageList.isEmpty()) {
                    Map<String, Object> imageDetails = imageList.get(0);
                    if (imageDetails != null && imageDetails.get("url") != null) {
                        String partialUrl = String.valueOf(imageDetails.get("url"));
                        product.setImageUrl("http://localhost:1337" + partialUrl);
                    }
                }
            }

            Object categoryDataObj = productData.get("category");
            if (categoryDataObj instanceof java.util.Map) {
                Map<String, Object> categoryData = (Map<String, Object>) categoryDataObj;
                if (categoryData != null && categoryData.get("name") != null) {
                    product.setCategoryName((String) categoryData.get("name"));
                }
            }

            productList.add(product);
        }

        return productList;
    }



    public ContactSection getContactSection() {
        Map<String, Object> response = getStrapiData("contact-section?populate=*");
        ContactSection contactSection = new ContactSection();
        if (response == null || response.get("data") == null) {
            return contactSection;
        }
        Map<String, Object> dataMap = (Map<String, Object>) response.get("data");
        contactSection.setTitle((String) dataMap.get("title"));
        contactSection.setDescription((String) dataMap.get("description"));
        contactSection.setNamePlaceholder((String) dataMap.get("name_placeholder"));
        contactSection.setPhonePlaceholder((String) dataMap.get("phone_placeholder"));
        contactSection.setMessagePlaceholder((String) dataMap.get("message_placeholder"));
        contactSection.setButtonText((String) dataMap.get("button_text"));

        Object imageDataObj = dataMap.get("background_image");
        if (imageDataObj instanceof java.util.List) {
            List<Map<String, Object>> imageList = (List<Map<String, Object>>) imageDataObj;

            if (!imageList.isEmpty()) {
                Map<String, Object> imageDetails = imageList.get(0);

                if (imageDetails != null && imageDetails.get("url") != null) {
                    String partialUrl = String.valueOf(imageDetails.get("url"));
                    contactSection.setBackgroundImage("http://localhost:1337" + partialUrl);
                }
            }
        }

        return contactSection;
    }




//    HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH


    public LineLogo getLineLogo() {
        Map<String, Object> response = getStrapiData("line-logo?populate=*");
        LineLogo lineLogo = new LineLogo();
        if (response == null || response.get("data") == null) return lineLogo;

        Map<String, Object> dataMap = (Map<String, Object>) response.get("data");
        lineLogo.setLineLogoUrl(getImageUrlFromMediaObject(dataMap.get("lineLogo")));
        return lineLogo;
    }



    private String getImageUrlFromMediaObject(Object mediaObject) {
        if (mediaObject == null) {
            return null;
        }

        if (mediaObject instanceof List) {
            List<?> mediaList = (List<?>) mediaObject;
            if (!mediaList.isEmpty()) {
                Object firstItem = mediaList.get(0);
                if (firstItem instanceof Map) {
                    Map<String, Object> itemMap = (Map<String, Object>) firstItem;
                    if (itemMap.containsKey("url")) {
                        return "http://localhost:1337" + itemMap.get("url");
                    }
                    if (itemMap.containsKey("attributes") && ((Map<?,?>)itemMap.get("attributes")).get("url") != null) {
                        return "http://localhost:1337" + ((Map<?,?>)itemMap.get("attributes")).get("url");
                    }
                }
            }
        }

        if (mediaObject instanceof Map) {
            Map<String, Object> mediaMap = (Map<String, Object>) mediaObject;
            if (mediaMap.containsKey("data") && mediaMap.get("data") instanceof Map) {
                Map<String, Object> dataMap = (Map<String, Object>) mediaMap.get("data");
                if (dataMap.containsKey("attributes") && dataMap.get("attributes") instanceof Map) {
                    Map<String, Object> attributesMap = (Map<String, Object>) dataMap.get("attributes");
                    if (attributesMap.containsKey("url")) {
                        return "http://localhost:1337" + attributesMap.get("url");
                    }
                }
            }
        }

        return null;
    }





    public Footer getFooter() {
        Map<String, Object> response = getStrapiData("footer?populate=*");

        Footer footer = new Footer();
        if (response == null || response.get("data") == null) {
            return footer;
        }
        Map<String, Object> dataMap = (Map<String, Object>) response.get("data");

        footer.setDescription((String) dataMap.get("description"));
        footer.setPagesTitle((String) dataMap.get("pages_title"));
        footer.setContactTitle((String) dataMap.get("contact_title"));
        footer.setHoursTitle((String) dataMap.get("hours_title"));

        footer.setLogoText((String) dataMap.get("logo_text"));
        footer.setCopyrightText((String) dataMap.get("copyright_text"));

        Object logoObj = dataMap.get("logo");
        if (logoObj instanceof Map) {
            Map<String, Object> logoDetails = (Map<String, Object>) logoObj;
            if (logoDetails.get("url") != null) {
                footer.setLogoUrl("http://localhost:1337" + logoDetails.get("url"));
            }
        }

        List<Map<String, Object>> pageLinksData = (List<Map<String, Object>>) dataMap.get("page_links");
        if (pageLinksData != null) {
            for (Map<String, Object> linkData : pageLinksData) {
                FooterLink link = new FooterLink();
                link.setText((String) linkData.get("text"));
                link.setUrl((String) linkData.get("url"));
                footer.getPageLinks().add(link);
            }
        }

        List<Map<String, Object>> contactItemsData = (List<Map<String, Object>>) dataMap.get("contact_items");
        if (contactItemsData != null) {
            for (Map<String, Object> itemData : contactItemsData) {



                ContactItem item = new ContactItem();
                item.setValue((String) itemData.get("value"));
                item.setType((String) itemData.get("type"));

                item.setIconUrl(getImageUrlFromMediaObject(itemData.get("icon")));
                footer.getContactItems().add(item);
            }
        }


        List<Map<String, Object>> workHoursData = (List<Map<String, Object>>) dataMap.get("work_hours");
        if (workHoursData != null) {
            for (Map<String, Object> dayData : workHoursData) {
                WorkingDay day = new WorkingDay();
                day.setDayRange((String) dayData.get("day_range"));
                day.setHours((String) dayData.get("hours"));
                footer.getWorkHours().add(day);
            }
        }

        List<Map<String, Object>> policyLinksData = (List<Map<String, Object>>) dataMap.get("policy_links");
        if (policyLinksData != null) {
            for (Map<String, Object> linkData : policyLinksData) {
                FooterLink link = new FooterLink();
                link.setText((String) linkData.get("text"));
                link.setUrl((String) linkData.get("url"));
                footer.getPolicyLinks().add(link);
            }
        }

        List<Map<String, Object>> socialLinksData = (List<Map<String, Object>>) dataMap.get("social_links");
        if (socialLinksData != null) {
            for (Map<String, Object> linkData : socialLinksData) {
                SocialLink link = new SocialLink();
                link.setUrl((String) linkData.get("url"));
                link.setType((String) linkData.get("type"));
                footer.getSocialLinks().add(link);
            }
        }

        return footer;
    }
}














