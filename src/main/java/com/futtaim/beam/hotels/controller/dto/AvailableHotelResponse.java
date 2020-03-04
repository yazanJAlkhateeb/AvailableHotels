package com.futtaim.beam.hotels.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


@Getter
@AllArgsConstructor
@ToString
public class AvailableHotelResponse {
    private List<Hotel> hotels;

}
