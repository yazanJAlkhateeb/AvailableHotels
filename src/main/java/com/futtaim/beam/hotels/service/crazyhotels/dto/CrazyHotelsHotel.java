package com.futtaim.beam.hotels.service.crazyhotels.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CrazyHotelsHotel {
    private String hotelName;
    private String hotelRate;
    private String discount;
    private String fare;
    private List<String> amenities;
}
