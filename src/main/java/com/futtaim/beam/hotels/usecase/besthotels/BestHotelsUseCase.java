package com.futtaim.beam.hotels.usecase.besthotels;

import com.futtaim.beam.hotels.controller.dto.Hotel;
import com.futtaim.beam.hotels.domain.EnquiryRequest;
import com.futtaim.beam.hotels.service.Service;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelRequest;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelResponse;
import com.futtaim.beam.hotels.usecase.UseCase;
import com.futtaim.beam.hotels.usecase.besthotels.mapper.BestHotelsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This Usecase to handle the request and response of Best hotels service
 * and mapping them
 */
@Slf4j
@Component
public class BestHotelsUseCase implements UseCase<EnquiryRequest, List<Hotel>> {
    private final Service<BestHotelRequest, BestHotelResponse> service;
    private BestHotelsMapper mapper;

    public BestHotelsUseCase(Service<BestHotelRequest, BestHotelResponse> service) {
        mapper = new BestHotelsMapper();
        this.service = service;
    }

    @Override
    public List<Hotel> execute(EnquiryRequest request) {
        log.debug("calling BestHotels service");
        BestHotelResponse response = service.serve(mapper.mapToBestHotelRequest(request));
        log.debug("mapping bestHotels response to general hotel");
        return response.getHotels().stream()
                .map(h -> mapper.mapToHotel(h))
                .collect(Collectors.toList());
    }
}
