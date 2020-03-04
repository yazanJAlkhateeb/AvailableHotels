package com.futtaim.beam.hotels.usecase.availablehotels;

import com.futtaim.beam.hotels.controller.dto.AvailableHotelRequest;
import com.futtaim.beam.hotels.controller.dto.AvailableHotelResponse;
import com.futtaim.beam.hotels.controller.dto.Hotel;
import com.futtaim.beam.hotels.provider.Provider;
import com.futtaim.beam.hotels.provider.ProvidersEventBus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AvailableHotelsUseCaseTest {

    @Test
    void testCallingEventBus() {
        MockProvidersEventBus eventBus = new MockProvidersEventBus();
        new AvailableHotelsUseCase(eventBus).execute(createRequest());
        assertTrue(eventBus.invoked);
    }

    @Test
    void givenRequestThenReturnResponseHotelsSorted() {
        MockProvidersEventBus eventBus = new MockProvidersEventBus();
        AvailableHotelResponse response = new AvailableHotelsUseCase(eventBus).execute(createRequest());
        Hotel firstHotel = response.getHotels().get(0);
        Hotel secondHotel = response.getHotels().get(1);
        assertEquals(firstHotel.getHotelRate(), 2);
        assertEquals(secondHotel.getHotelRate(), 3);
    }

    private AvailableHotelRequest createRequest() {
        AvailableHotelRequest request = new AvailableHotelRequest();
        request.setCity("AMM");
        request.setFromDate(LocalDate.now().toString());
        request.setToDate(LocalDate.now().toString());
        request.setNumberOfAdults("2");
        return request;
    }

    private class MockProvidersEventBus extends ProvidersEventBus {
        private boolean invoked;

        @Override
        public List<Provider> getProviders() {
            invoked = true;
            return Collections.singletonList(req ->
                    Arrays.asList(hotel(3), hotel(2)));
        }

        private Hotel hotel(int hotelRate) {
            Hotel hotel = new Hotel();
            hotel.setHotelRate(hotelRate);
            hotel.setFare(BigDecimal.ZERO);
            hotel.setHotelName("Rixos");
            hotel.setProvider("BestHotels");
            return hotel;
        }

    }
}