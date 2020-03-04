package com.futtaim.beam.hotels.provider;

import com.futtaim.beam.hotels.usecase.UseCase;
import com.futtaim.beam.hotels.usecase.domain.EnquiryRequest;
import com.futtaim.beam.hotels.usecase.domain.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BestHotelsProvider implements Provider{
    private final UseCase<EnquiryRequest, List<Hotel>> bestHotelsUseCase;

    public BestHotelsProvider(UseCase<EnquiryRequest, List<Hotel>> bestHotelsUseCase) {
        this.bestHotelsUseCase = bestHotelsUseCase;
    }

    @Override
    public List<Hotel> provide(EnquiryRequest request) {
        return bestHotelsUseCase.execute(request);
    }

}
