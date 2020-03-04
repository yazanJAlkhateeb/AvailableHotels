package com.futtaim.beam.hotels.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class AvailableHotelResponse {
    private List<Hotel> hotels;

}
