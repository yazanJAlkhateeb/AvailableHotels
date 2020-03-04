package com.futtaim.beam.hotels.usecase.crazyhotels.mapper;

import com.futtaim.beam.hotels.usecase.domain.Hotel;
import com.futtaim.beam.hotels.service.crazyhotels.dto.CrazyHotelsHotel;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrazyHotelsMapperTest {
    private final CrazyHotelsMapper mapper = new CrazyHotelsMapper();

    @Test
    void givenResponseWithoutDiscountThenReturnFareOnly() {
        Hotel hotel = mapper.mapToHotel(createHotelResponse(null));
        assertEquals(hotel.getHotelName(), "Rixos");
        assertEquals(hotel.getProvider(), "CrazyHotels");
        assertEquals(hotel.getFare(), BigDecimal.TEN);
        assertEquals(hotel.getAmenities().get(0), "Pool");
        assertEquals(hotel.getHotelRate(), 3);
    }

    @Test
    void givenResponseWithDiscountThenReturnTotalFareAfterDiscount() {
        Hotel hotel = mapper.mapToHotel(createHotelResponse("5"));
        assertEquals(hotel.getHotelName(), "Rixos");
        assertEquals(hotel.getProvider(), "CrazyHotels");
        assertEquals(hotel.getFare(), BigDecimal.valueOf(5));
        assertEquals(hotel.getAmenities().get(0), "Pool");
        assertEquals(hotel.getHotelRate(), 3);
    }

    @Test
    void givenResponseWithThreeStarsThenReturnHotelRateInDigits() {
        Hotel hotel = mapper.mapToHotel(createHotelResponse(null));
        assertEquals(hotel.getHotelName(), "Rixos");
        assertEquals(hotel.getProvider(), "CrazyHotels");
        assertEquals(hotel.getFare(), BigDecimal.valueOf(10));
        assertEquals(hotel.getAmenities().get(0), "Pool");
        assertEquals(hotel.getHotelRate(), 3);
    }


    private CrazyHotelsHotel createHotelResponse(String discount) {
        CrazyHotelsHotel hotel = new CrazyHotelsHotel();
        hotel.setHotelName("Rixos");
        hotel.setHotelRate("***");
        hotel.setDiscount(discount);
        hotel.setAmenities(Collections.singletonList("Pool"));
        hotel.setFare("10");
        return hotel;
    }
}