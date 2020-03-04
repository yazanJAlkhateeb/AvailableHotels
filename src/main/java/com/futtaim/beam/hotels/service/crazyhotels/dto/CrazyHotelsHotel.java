package com.futtaim.beam.hotels.service.crazyhotels.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CrazyHotelsHotel {
    private String hotelName;
    private String hotelRate;
    private String discount;
    private String fare;
    private List<String> amenities;
}
