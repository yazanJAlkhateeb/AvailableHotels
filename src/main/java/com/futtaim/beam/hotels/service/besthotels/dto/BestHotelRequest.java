package com.futtaim.beam.hotels.service.besthotels.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BestHotelRequest {
    private String city;
    private String fromDate;
    private String toDate;
    private int numberOfAdults;
}
