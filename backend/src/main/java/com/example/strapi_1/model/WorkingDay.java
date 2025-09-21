package com.example.strapi_1.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class WorkingDay {


    private String dayRange;
    private String hours;

    public String getDayRange() {
        return dayRange;
    }

    public void setDayRange(String dayRange) {
        this.dayRange = dayRange;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "WorkingDay{" +
                "dayRange='" + dayRange + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }
}