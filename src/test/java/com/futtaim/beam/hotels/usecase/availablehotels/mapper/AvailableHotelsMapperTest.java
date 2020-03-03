package com.futtaim.beam.hotels.usecase.availablehotels.mapper;

import com.futtaim.beam.hotels.controller.dto.AvailableHotelRequest;
import com.futtaim.beam.hotels.usecase.domain.EnquiryRequest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static org.junit.jupiter.api.Assertions.*;

class AvailableHotelsMapperTest {


    @Test
    void testDefaultMapping() {
        AvailableHotelRequest availableHotelRequest = createAvailableHotelRequest();
        EnquiryRequest enquiryRequest = new AvailableHotelsMapper().map(availableHotelRequest);
        assertNotNull(availableHotelRequest);
        assertEquals(enquiryRequest.getCity(),"AMM");
        assertEquals(enquiryRequest.getNumberOfAdults(),3);
        assertEquals(enquiryRequest.getFromDate(),LocalDate.now());
        assertEquals(enquiryRequest.getToDate(),LocalDate.now());



    }

    private AvailableHotelRequest createAvailableHotelRequest() {
        AvailableHotelRequest request = new AvailableHotelRequest();
        request.setCity("AMM");
        request.setFromDate(LocalDate.now().format(ISO_LOCAL_DATE));
        request.setToDate(LocalDate.now().format(ISO_LOCAL_DATE));
        request.setNumberOfAdults("3");
        return request;
    }
}