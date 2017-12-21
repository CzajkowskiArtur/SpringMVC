package pl.sdacademy.dto;

import java.time.LocalDateTime;

public class DaysDto {
    private Integer daysAfter;
    private LocalDateTime after;

    public Integer getDaysAfter() {
        return daysAfter;
    }

    public void setDaysAfter(Integer daysAfter) {
        this.daysAfter = daysAfter;
    }

    public LocalDateTime getAfter() {
        return after;
    }

    public void setAfter(LocalDateTime after) {
        this.after = after;
    }
}
