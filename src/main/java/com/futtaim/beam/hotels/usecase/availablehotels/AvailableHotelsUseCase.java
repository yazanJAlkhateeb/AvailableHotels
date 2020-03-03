package com.futtaim.beam.hotels.usecase.availablehotels;

import com.futtaim.beam.hotels.controller.dto.AvailableHotelRequest;
import com.futtaim.beam.hotels.controller.dto.AvailableHotelResponse;
import com.futtaim.beam.hotels.provider.ProvidersEventBus;
import com.futtaim.beam.hotels.usecase.UseCase;
import com.futtaim.beam.hotels.usecase.availablehotels.mapper.AvailableHotelsMapper;
import com.futtaim.beam.hotels.usecase.domain.EnquiryRequest;
import com.futtaim.beam.hotels.usecase.domain.Hotel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvailableHotelsUseCase implements UseCase<AvailableHotelRequest, AvailableHotelResponse> {
    private ProvidersEventBus eventBus;
    private AvailableHotelsMapper mapper;

    public AvailableHotelsUseCase(ProvidersEventBus eventBus) {
        mapper = new AvailableHotelsMapper();
        this.eventBus = eventBus;
    }

    @Override
    public AvailableHotelResponse execute(AvailableHotelRequest request) {
        EnquiryRequest enquiryRequest = mapper.map(request);
        ArrayList<Hotel> hotels = new ArrayList<>();
        eventBus.getProviders().forEach(p -> hotels.addAll(p.provide(enquiryRequest)));
        return new AvailableHotelResponse(sortHotels(hotels));
    }

    private List<Hotel> sortHotels(ArrayList<Hotel> hotels) {
        return hotels.stream()
                .sorted(Comparator.comparing((Hotel::getHotelRate)))
                .collect(Collectors.toList());
    }

}
