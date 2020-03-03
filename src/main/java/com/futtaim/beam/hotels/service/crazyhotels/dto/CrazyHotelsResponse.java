package com.futtaim.beam.hotels.service.crazyhotels.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CrazyHotelsResponse {
    private List<CrazyHotelsHotel> hotels;
}
