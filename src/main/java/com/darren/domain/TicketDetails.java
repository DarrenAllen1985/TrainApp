package com.darren.domain;

import java.util.Objects;

public class TicketDetails {
    private String DDate;
    private String Destination;
    private String depature;
    private String TrianNo ;

    public TicketDetails() {
    }

    public TicketDetails(TicketDetails builder) {
        this.DDate = builder.DDate;
        this.Destination = builder.Destination;
        this.depature = builder.depature;
        this.TrianNo = builder.TrianNo;
    }
    public String getDDate() {
        return DDate;
    }
    public String getDestination() {
        return Destination;
    }
    public String getdepature() {
        return depature;
    }
    public String getTrianNo() {
        return TrianNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketDetails)) return false;
        TicketDetails TickDetail = (TicketDetails) o;
        return getTrianNo().equals(TickDetail.TrianNo);
    }

    @Override
    public int hashCode(){
        return Objects.hash(getTrianNo());
    }


    @Override
    public String toString() {
        return "TicketDetails{" +
                "DDate='" + DDate + '\'' +
                ", Destination='" + Destination + '\'' +
                ", depature='" + depature + '\'' +
                ", TrianNo='" + TrianNo + '\'' +
                '}';
    }

    public int compareTo(TicketDetails ManCon) {
        return this.getTrianNo().compareTo(ManCon.getTrianNo());
    }

    public static class Builder{
        private String DDate;
        private String Destination;
        private String depature;
        private String TrianNo ;

        public Builder DDate(String DDate ) {
            this.DDate= DDate;
            return this;
        }

        public Builder Destination(String Destination){
            this.Destination = Destination;
            return this;
        }

        public Builder depature(String depature){
            this.depature = depature;
            return this;
        }
        public Builder TrianNo(String TrianNo){
            this.TrianNo = TrianNo;
            return this;
        }

        public Builder copy (TicketDetails ManCon){
            this.DDate = ManCon.DDate;
            this.Destination= ManCon.Destination;
            this.depature= ManCon.depature;
            this.TrianNo= ManCon.TrianNo;
            return this;
        }
        public TicketDetails build(){return new TicketDetails();}

    }
    
}
