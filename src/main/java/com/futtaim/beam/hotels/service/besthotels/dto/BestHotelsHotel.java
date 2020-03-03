package com.futtaim.beam.hotels.service.besthotels.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class BestHotelsHotel {
    private String hotelName;
    private String hotelRate;
    private String fare;
    private List<String> amenities;
}
