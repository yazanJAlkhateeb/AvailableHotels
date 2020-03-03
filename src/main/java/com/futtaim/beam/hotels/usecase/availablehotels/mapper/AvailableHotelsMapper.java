package com.futtaim.beam.hotels.usecase.availablehotels.mapper;

import com.futtaim.beam.hotels.controller.dto.AvailableHotelRequest;
import com.futtaim.beam.hotels.usecase.domain.EnquiryRequest;

import java.time.LocalDate;

public class AvailableHotelsMapper {

    public EnquiryRequest map(AvailableHotelRequest request) {
        EnquiryRequest enquiryRequest = new EnquiryRequest();
        enquiryRequest.setCity(request.getCity());
        enquiryRequest.setFromDate(LocalDate.parse(request.getFromDate()));
        enquiryRequest.setToDate(LocalDate.parse(request.getToDate()));
        enquiryRequest.setNumberOfAdults(Integer.parseInt(request.getNumberOfAdults()));

        return enquiryRequest;
    }
}
