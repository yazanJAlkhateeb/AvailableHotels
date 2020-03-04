package com.futtaim.beam.hotels.usecase.availablehotels;

import com.futtaim.beam.hotels.controller.dto.AvailableHotelRequest;
import com.futtaim.beam.hotels.controller.dto.AvailableHotelResponse;
import com.futtaim.beam.hotels.controller.dto.Hotel;
import com.futtaim.beam.hotels.domain.EnquiryRequest;
import com.futtaim.beam.hotels.provider.ProvidersEventBus;
import com.futtaim.beam.hotels.usecase.UseCase;
import com.futtaim.beam.hotels.usecase.availablehotels.mapper.AvailableHotelsMapper;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this usecase to get all the providers by calling them on eventBus
 * (publisher and subscriber) and then process the result from provider into
 * list of hotels and after that sort them based on hotels rate
 * and return the response
 */
@Component
public class AvailableHotelsUseCase implements UseCase<AvailableHotelRequest, AvailableHotelResponse> {
    private final AvailableHotelsMapper mapper;
    private final ProvidersEventBus eventBus;

    public AvailableHotelsUseCase(ProvidersEventBus eventBus) {
        this.eventBus = eventBus;
        mapper = new AvailableHotelsMapper();
    }

    @Override
    public AvailableHotelResponse execute(AvailableHotelRequest request) {
        EnquiryRequest enquiryRequest = mapper.map(request);
        List<Hotel> hotels = eventBus.getProviders().stream()
                .map(p -> p.provide(enquiryRequest))
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Hotel::getHotelRate))
                .collect(Collectors.toList());
        return new AvailableHotelResponse(hotels);
    }
}
