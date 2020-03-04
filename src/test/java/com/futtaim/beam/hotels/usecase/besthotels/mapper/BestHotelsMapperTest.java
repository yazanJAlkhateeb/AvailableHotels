package com.futtaim.beam.hotels.usecase.besthotels.mapper;

import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelsHotel;
import com.futtaim.beam.hotels.service.exception.ServiceTechnicalException;
import com.futtaim.beam.hotels.usecase.domain.Hotel;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BestHotelsMapperTest {


    private final BestHotelsMapper mapper = new BestHotelsMapper();

    @Test
    void assertDefaultMapping() {
        Hotel hotel = mapper.mapToHotel(createHotelResponse("10"));
        assertEquals(hotel.getHotelName(), "Rixos");
        assertEquals(hotel.getProvider(), "BestHotels");
        assertEquals(hotel.getFare(), new BigDecimal("10.00"));
        assertEquals(hotel.getAmenities().get(0), "Pool");
        assertEquals(hotel.getHotelRate(), 5);
    }

    @Test
    void givenHotelFiveDecimalsTotalFareWhenMappingThenRoundIt() {
        Hotel hotel = mapper.mapToHotel(createHotelResponse("10.29445"));
        assertEquals(hotel.getHotelName(), "Rixos");
        assertEquals(hotel.getProvider(), "BestHotels");
        assertEquals(hotel.getFare(), BigDecimal.valueOf(10.29));
        assertEquals(hotel.getAmenities().get(0), "Pool");
        assertEquals(hotel.getHotelRate(), 5);
    }

    @Test
    void givenWrongFareThenThrowBusinessException() {
        assertThrows(ServiceTechnicalException.class,
                () -> mapper.mapToHotel(createHotelResponse("notDigit")));
    }

    private BestHotelsHotel createHotelResponse(String fare) {
        BestHotelsHotel hotel = new BestHotelsHotel();
        hotel.setHotelName("Rixos");
        hotel.setHotelRate("5");
        hotel.setAmenities(Collections.singletonList("Pool"));
        hotel.setFare(fare);
        return hotel;
    }
}