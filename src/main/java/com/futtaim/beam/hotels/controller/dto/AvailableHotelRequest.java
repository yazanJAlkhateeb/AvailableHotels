package com.futtaim.beam.hotels.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class AvailableHotelRequest {
    private String fromDate;
    private String toDate;
    private String city;
    private String numberOfAdults;
}
