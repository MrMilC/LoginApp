package edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Controller;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ImageSelector {
    public static String getCurrentDayImageName() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY:
                return "monday.png";
            case TUESDAY:
                return "tuesday.png";
            case WEDNESDAY:
                return "wednesday.png";
            case THURSDAY:
                return "thursday.png";
            case FRIDAY:
                return "friday.png";
            case SATURDAY:
                return "saturday.png";
            case SUNDAY:
                return "sunday.png";
            default:
                throw new IllegalStateException("Unknown day of the week: " + dayOfWeek);
        }
    }
}
