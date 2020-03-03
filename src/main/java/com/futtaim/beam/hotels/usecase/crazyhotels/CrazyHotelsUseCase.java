package com.futtaim.beam.hotels.usecase.crazyhotels;

import com.futtaim.beam.hotels.usecase.domain.Hotel;
import com.futtaim.beam.hotels.service.Service;
import com.futtaim.beam.hotels.service.crazyhotels.dto.CrazyHotelsRequest;
import com.futtaim.beam.hotels.service.crazyhotels.dto.CrazyHotelsResponse;
import com.futtaim.beam.hotels.usecase.UseCase;
import com.futtaim.beam.hotels.usecase.crazyhotels.mapper.CrazyHotelsMapper;
import com.futtaim.beam.hotels.usecase.domain.EnquiryRequest;

import java.util.List;
import java.util.stream.Collectors;


public class CrazyHotelsUseCase implements UseCase<EnquiryRequest, List<Hotel>> {
    private final Service<CrazyHotelsRequest, CrazyHotelsResponse> service;
    private CrazyHotelsMapper mapper;

    public CrazyHotelsUseCase(Service<CrazyHotelsRequest, CrazyHotelsResponse> service) {
        mapper = new CrazyHotelsMapper();
        this.service = service;
    }


    @Override
    public List<Hotel> execute(EnquiryRequest request) {
        CrazyHotelsResponse response = service.serve(mapper.mapToCrazyHotelRequest(request));
        return response.getHotels().stream().map(h -> mapper.mapToHotel(h)).collect(Collectors.toList());
    }


}
