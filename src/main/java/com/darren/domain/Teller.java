package com.darren.domain;

public class Teller {

    private String tellerId;
    private String tellerName;
    private String tellerPassword;

    public String getTellerId() {
        return tellerId;
    }

    public String getName() {
        return tellerName;
    }

    public String getPassword() {
        return tellerPassword;
    }

    private Teller() {
    }

    public Teller(Builder builder) {
        this.tellerId = builder.tellerId;
        this.tellerName = builder.tellerName;
        this.tellerPassword = builder.tellerPassword;
    }

    public static class Builder{
        private String tellerId;
        private String tellerName;
        private String tellerPassword;

        public Builder tellerId(String value){
            this.tellerId = value;
            return this;
        }

        public Builder tellerName(String value){
            this.tellerName = value;
            return this;
        }

        public Builder tellerPassword(String value){
            this.tellerPassword = value;
            return this;
        }

        public Teller build(){

            return new Teller(this);
        }

        public Builder copy(Teller savedTeller) {
            this.tellerId = savedTeller.tellerId;
            this.tellerName = savedTeller.tellerName;
            this.tellerPassword = savedTeller.tellerPassword;

            return this;
        }
    }
}
