package com.futtaim.beam.hotels.provider;

import com.futtaim.beam.hotels.controller.dto.Hotel;
import com.futtaim.beam.hotels.domain.EnquiryRequest;
import com.futtaim.beam.hotels.usecase.UseCase;
import com.futtaim.beam.hotels.usecase.availablehotels.AvailableHotelsUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * every subscriber have a usecase related ,
 * in order to handle the process of calling them service
 * and mapping the request to domain objects and vise versa
 * (from EnquiryRequest to BestHotels Request and from  best hotel Response to hotel)
 */
@Component
public class CrazyHotelsProvider implements Provider {
    private static final Logger logger = LoggerFactory.getLogger(AvailableHotelsUseCase.class);
    private final UseCase<EnquiryRequest, List<Hotel>> crazyHotelsUseCase;

    public CrazyHotelsProvider(UseCase<EnquiryRequest, List<Hotel>> crazyHotelsUseCase) {
        this.crazyHotelsUseCase = crazyHotelsUseCase;
    }

    @Override
    public List<Hotel> provide(EnquiryRequest request) {
        logger.info("Calling CrazyHotels Usecase");
        return crazyHotelsUseCase.execute(request);
    }

}
