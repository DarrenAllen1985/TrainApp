package com.darren.factories;


import com.darren.domain.Website;

public class WebsiteFactory {

    public static Website buildWebsite(String WebsiteName,String Username,String Password)
    {
        Website Website = new Website.Builder()
                .WebsiteName(WebsiteName)
                .Username(Username)
                .Password(Password)
                .build();
        return Website ;
    }
}