package com.futtaim.beam.hotels.usecase.besthotels;

import com.futtaim.beam.hotels.usecase.domain.Hotel;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelResponse;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelsHotel;
import com.futtaim.beam.hotels.usecase.domain.EnquiryRequest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BestHotelsUseCaseTest {

    @Test
    void testCallingBestHotelsService() {
        MockBestHotelsService service = new MockBestHotelsService(createResponse());
        new BestHotelsUseCase(service).execute(createRequest());
        assertTrue(service.isInvoked());
    }

    @Test
    void givenResponseThenReturnGeneralHotel() {
        MockBestHotelsService service = new MockBestHotelsService(createResponse());
        List<Hotel> hotels = new BestHotelsUseCase(service).execute(createRequest());
        Hotel hotel = hotels.get(0);
        assertEquals(hotel.getHotelName(), "Rixos");
        assertEquals(hotel.getProvider(), "BestHotels");
        assertEquals(hotel.getFare(), new BigDecimal("10.00"));
        assertEquals(hotel.getAmenities().get(0), "Pool");
        assertEquals(hotel.getHotelRate(), 5);
    }

    private EnquiryRequest createRequest() {
        EnquiryRequest request = new EnquiryRequest();
        request.setFromDate(LocalDate.now());
        request.setToDate(LocalDate.now());
        request.setCity("AMM");
        request.setNumberOfAdults(2);
        return request;
    }

    private BestHotelResponse createResponse() {
        BestHotelResponse response = new BestHotelResponse();
        BestHotelsHotel hotel = new BestHotelsHotel();
        hotel.setHotelName("Rixos");
        hotel.setHotelRate("5");
        hotel.setAmenities(Collections.singletonList("Pool"));
        hotel.setFare("10");
        response.setHotels(Collections.singletonList(hotel));
        return response;
    }


}