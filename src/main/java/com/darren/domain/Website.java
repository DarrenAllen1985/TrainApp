package com.darren.domain;

public class Website {
    private String WebsiteName ;
    private String Username ;
    private String Password;

    public String getWebsiteName () {
        return WebsiteName ;
    }

    public String getUsername () {
        return Username ;
    }

    public String getPassword() {
        return Password;
    }

    private Website() {
    }

    public Website(Website.Builder builder) {
        this.WebsiteName  = builder.WebsiteName ;
        this.Username  = builder.Username ;
        this.Password = builder.Password;
    }

    public static class Builder{
        private String WebsiteName ;
        private String Username ;
        private String Password;

        public Website.Builder WebsiteName (String value){
            this.WebsiteName  = value;
            return this;
        }

        public Website.Builder Username (String value){
            this.Username  = value;
            return this;
        }

        public Website.Builder Password(String value){
            this.Password = value;
            return this;
        }

        public Website build(){

            return new Website(this);
        }

        public Website.Builder copy(Website website) {
            this.WebsiteName  = website.WebsiteName ;
            this.Username  = website.Username ;
            this.Password = website.Password;

            return this;
        }
    }

}
