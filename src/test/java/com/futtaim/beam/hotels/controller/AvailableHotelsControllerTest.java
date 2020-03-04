package com.futtaim.beam.hotels.controller;

import com.futtaim.beam.hotels.controller.dto.AvailableHotelResponse;
import com.futtaim.beam.hotels.controller.dto.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AvailableHotelsControllerTest {
    public static final String BEST_HOTELS = "BestHotels";
    private final AvailableHotelResponse response = createResponse();
    private boolean useCaseCalled;

    @Test
    void testCallingAvailableHotelsUseCase() {
        new AvailableHotelsController(request -> {
            useCaseCalled = true;
            return null;
        }).get(null);
        assertTrue(useCaseCalled);
    }

    @Test
    void givenRequestWhenProcessThenReturnResponse() {
        ResponseEntity<AvailableHotelResponse> responseEntity =
                new AvailableHotelsController(request -> response).get(null);
        AvailableHotelResponse responseBody = responseEntity.getBody();
        assertNotNull(responseBody);
        Hotel hotel = responseBody.getHotels().get(0);
        assertEquals(hotel.getFare(), BigDecimal.TEN);
        assertEquals(hotel.getHotelName(), "Rixos");
        assertEquals(hotel.getProvider(), BEST_HOTELS);
    }

    private AvailableHotelResponse createResponse() {
        Hotel hotel = new Hotel();
        hotel.setFare(BigDecimal.TEN);
        hotel.setHotelName("Rixos");
        hotel.setProvider(BEST_HOTELS);
        return new AvailableHotelResponse(Collections.singletonList(hotel));
    }
}