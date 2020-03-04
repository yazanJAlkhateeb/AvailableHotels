package com.futtaim.beam.hotels.usecase.besthotels.mapper;

import com.futtaim.beam.hotels.controller.dto.Hotel;
import com.futtaim.beam.hotels.domain.EnquiryRequest;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelRequest;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelsHotel;
import com.futtaim.beam.hotels.service.exception.ServiceTechnicalException;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class BestHotelsMapper {

    public BestHotelRequest mapToBestHotelRequest(EnquiryRequest enquiryRequest) {
        BestHotelRequest bestHotelRequest = new BestHotelRequest();
        bestHotelRequest.setCity(enquiryRequest.getCity());
        bestHotelRequest.setFromDate(enquiryRequest.getFromDate().format(DateTimeFormatter.ISO_DATE));
        bestHotelRequest.setToDate(enquiryRequest.getToDate().format(DateTimeFormatter.ISO_DATE));
        bestHotelRequest.setNumberOfAdults(enquiryRequest.getNumberOfAdults());
        return bestHotelRequest;
    }

    public Hotel mapToHotel(BestHotelsHotel bestHotelsHotel) {
        try {
            Hotel hotel = new Hotel();
            hotel.setProvider("BestHotels");
            hotel.setAmenities(bestHotelsHotel.getAmenities());
            hotel.setHotelName(bestHotelsHotel.getHotelName());
            hotel.setHotelRate(Long.parseLong(bestHotelsHotel.getHotelRate()));
            hotel.setFare(totalFare(bestHotelsHotel));
            return hotel;
        } catch (Exception e) {
            throw new ServiceTechnicalException("ERROR While Mapping Response ", e);
        }
    }

    private BigDecimal totalFare(BestHotelsHotel bestHotelsHotel) {
        return new BigDecimal(bestHotelsHotel.getFare()).setScale(2, ROUND_HALF_UP);
    }
}
