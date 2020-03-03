package com.futtaim.beam.hotels.usecase.besthotels.mapper;

import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelRequest;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelsHotel;
import com.futtaim.beam.hotels.service.exception.ServiceBusinessException;
import com.futtaim.beam.hotels.usecase.domain.EnquiryRequest;
import com.futtaim.beam.hotels.usecase.domain.Hotel;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

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
            hotel.setFare(new BigDecimal(bestHotelsHotel.getFare()));
            return hotel;
        } catch (Exception e) {
            throw new ServiceBusinessException(e.getMessage());
        }
    }

}
