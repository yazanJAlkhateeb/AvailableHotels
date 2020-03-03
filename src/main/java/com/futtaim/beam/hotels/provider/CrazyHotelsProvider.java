package com.futtaim.beam.hotels.provider;

import com.futtaim.beam.hotels.usecase.UseCase;
import com.futtaim.beam.hotels.usecase.domain.EnquiryRequest;
import com.futtaim.beam.hotels.usecase.domain.Hotel;

import java.util.List;

public class CrazyHotelsProvider implements Provider {
    private final UseCase<EnquiryRequest, List<Hotel>> crazyHotelsUseCase;

    public CrazyHotelsProvider(UseCase<EnquiryRequest, List<Hotel>> crazyHotelsUseCase) {
        this.crazyHotelsUseCase = crazyHotelsUseCase;
        ProvidersEventBus.register(this);
    }

    @Override
    public List<Hotel> provide(EnquiryRequest request) {
        return crazyHotelsUseCase.execute(request);
    }

}
