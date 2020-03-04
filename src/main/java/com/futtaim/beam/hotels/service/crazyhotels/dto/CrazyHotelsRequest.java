package com.futtaim.beam.hotels.service.crazyhotels.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class CrazyHotelsRequest {
    private String city;
    private String fromDate;
    private String toDate;
    private int numberOfAdults;
}
