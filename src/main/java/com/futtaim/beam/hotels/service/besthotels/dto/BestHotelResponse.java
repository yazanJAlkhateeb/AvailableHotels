package com.futtaim.beam.hotels.service.besthotels.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BestHotelResponse {
    private List<BestHotelsHotel> hotels;

}
