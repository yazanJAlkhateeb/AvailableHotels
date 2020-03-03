package com.futtaim.beam.hotels.service.crazyhotels.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class CrazyHotelsRequest {
    private String city;
    private String fromDate;
    private String toDate;
    private int numberOfAdults;
}
