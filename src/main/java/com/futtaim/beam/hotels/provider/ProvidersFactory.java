package com.futtaim.beam.hotels.provider;

import com.futtaim.beam.hotels.controller.dto.Hotel;
import com.futtaim.beam.hotels.domain.EnquiryRequest;
import com.futtaim.beam.hotels.usecase.UseCase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this factory to register the providers
 */
@Component
public class ProvidersFactory {

    public ProvidersFactory(ProvidersEventBus eventBus,
                            UseCase<EnquiryRequest, List<Hotel>> crazyHotelsUseCase,
                            UseCase<EnquiryRequest, List<Hotel>> bestHotelsUseCase) {
        eventBus.register(new BestHotelsProvider(bestHotelsUseCase));
        eventBus.register(new CrazyHotelsProvider(crazyHotelsUseCase));

    }
}
