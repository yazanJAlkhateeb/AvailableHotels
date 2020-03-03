package com.futtaim.beam.hotels.usecase.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Hotel {
    private String provider;
    private String hotelName;
    private long hotelRate;
    private BigDecimal fare;
    private List<String> amenities;
}
