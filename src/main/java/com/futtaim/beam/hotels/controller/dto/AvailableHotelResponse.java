package com.futtaim.beam.hotels.controller.dto;

import com.futtaim.beam.hotels.usecase.domain.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class AvailableHotelResponse {
    private List<Hotel> hotels;

}
