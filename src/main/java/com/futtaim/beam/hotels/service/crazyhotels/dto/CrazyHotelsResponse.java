package com.futtaim.beam.hotels.service.crazyhotels.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class CrazyHotelsResponse {
    private List<CrazyHotelsHotel> hotels;
}
