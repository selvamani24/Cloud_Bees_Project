package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Seat {
    private String section;
    private int seatNumber;


    @Override
    public String toString() {
        return "Seat{" +
                "section='" + section + '\'' +
                ", seatNumber=" + seatNumber +
                '}';
    }
}

