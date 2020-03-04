package com.futtaim.beam.hotels.service.besthotels;

import com.futtaim.beam.hotels.service.Service;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelRequest;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelResponse;
import com.futtaim.beam.hotels.service.exception.ServiceTechnicalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.isNull;

/**
 * here the service of BestHotels used restTemplate to handle communication
 * to send request and retrieve response
 * after that validating the response and deliver it to the usecase
 */
@Component
public class BestHotelsService implements Service<BestHotelRequest, BestHotelResponse> {
    public static final String SERVICE_URL_IS_UNREACHABLE = "Service Service URL is unreachable";
    private static final Logger LOGGER = LoggerFactory.getLogger(BestHotelsService.class);
    private final RestTemplate restTemplate;
    private final String bestHotelsUrl;

    public BestHotelsService(RestTemplate restTemplate, @Value("${best.hotels.url}") String bestHotelsUrl) {
        this.restTemplate = restTemplate;
        this.bestHotelsUrl = bestHotelsUrl;
    }

    @Override
    public BestHotelResponse serve(BestHotelRequest request) {
        try {
            BestHotelResponse response = response(request);
            if (isNull(response))
                throw new ServiceTechnicalException(SERVICE_URL_IS_UNREACHABLE);
            return response;
        } catch (RestClientException e) {
            LOGGER.error("Exception while calling BestHotelsService ", e);
            throw new ServiceTechnicalException(SERVICE_URL_IS_UNREACHABLE, e);
        }
    }

    private BestHotelResponse response(BestHotelRequest request) {
        return restTemplate.postForObject(bestHotelsUrl, request, BestHotelResponse.class);
    }
}
