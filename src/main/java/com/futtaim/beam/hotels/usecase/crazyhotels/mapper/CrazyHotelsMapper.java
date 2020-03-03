package com.futtaim.beam.hotels.usecase.crazyhotels.mapper;

import com.futtaim.beam.hotels.usecase.domain.Hotel;
import com.futtaim.beam.hotels.service.crazyhotels.dto.CrazyHotelsHotel;
import com.futtaim.beam.hotels.service.crazyhotels.dto.CrazyHotelsRequest;
import com.futtaim.beam.hotels.usecase.domain.EnquiryRequest;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.nonNull;

public class CrazyHotelsMapper {

    public CrazyHotelsRequest mapToCrazyHotelRequest(EnquiryRequest enquiryRequest) {
        CrazyHotelsRequest crazyHotelRequest = new CrazyHotelsRequest();
        crazyHotelRequest.setCity(enquiryRequest.getCity());
        crazyHotelRequest.setFromDate(enquiryRequest.getFromDate().format(DateTimeFormatter.ISO_DATE));
        crazyHotelRequest.setToDate(enquiryRequest.getToDate().format(DateTimeFormatter.ISO_DATE));
        crazyHotelRequest.setNumberOfAdults(enquiryRequest.getNumberOfAdults());
        return crazyHotelRequest;
    }

    public Hotel mapToHotel(CrazyHotelsHotel crazyHotelsHotel) {
        Hotel hotel = new Hotel();
        hotel.setProvider("CrazyHotels");
        hotel.setAmenities(crazyHotelsHotel.getAmenities());
        hotel.setHotelName(crazyHotelsHotel.getHotelName());
        hotel.setHotelRate(hotelRate(crazyHotelsHotel));
        hotel.setFare(totalFare(crazyHotelsHotel));
        return hotel;
    }

    private long hotelRate(CrazyHotelsHotel crazyHotelsHotel) {
        return crazyHotelsHotel.getHotelRate().chars().filter(c -> c == '*').count();
    }

    private BigDecimal totalFare(CrazyHotelsHotel crazyHotelsHotel) {
        String discount = crazyHotelsHotel.getDiscount();
        String fare = crazyHotelsHotel.getFare();
        return nonNull(discount) ?
                applyDiscount(discount, fare) : new BigDecimal(fare);
    }

    private BigDecimal applyDiscount(String discount, String fare) {
        return new BigDecimal(fare)
                .subtract(new BigDecimal(discount));
    }
}
