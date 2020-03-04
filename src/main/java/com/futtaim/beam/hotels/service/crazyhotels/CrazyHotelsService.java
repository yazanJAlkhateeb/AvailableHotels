package com.futtaim.beam.hotels.service.crazyhotels;

import com.futtaim.beam.hotels.service.Service;
import com.futtaim.beam.hotels.service.crazyhotels.dto.CrazyHotelsRequest;
import com.futtaim.beam.hotels.service.crazyhotels.dto.CrazyHotelsResponse;
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
public class CrazyHotelsService implements Service<CrazyHotelsRequest, CrazyHotelsResponse> {
    public static final String SERVICE_URL_IS_UNREACHABLE = "Service Service URL is unreachable";
    private static final Logger LOGGER = LoggerFactory.getLogger(CrazyHotelsService.class);
    private final RestTemplate restTemplate;
    private final String CrazyHotelsUrl;

    public CrazyHotelsService(RestTemplate restTemplate,
                              @Value("${crazy.hotels.url}") String CrazyHotelsUrl) {
        this.restTemplate = restTemplate;
        this.CrazyHotelsUrl = CrazyHotelsUrl;
    }

    @Override
    public CrazyHotelsResponse serve(CrazyHotelsRequest request) {
        try {
            LOGGER.info("Calling CrazyHotels Service");
            CrazyHotelsResponse response = response(request);
            if (isNull(response))
                throw new ServiceTechnicalException(SERVICE_URL_IS_UNREACHABLE);
            return response;
        } catch (RestClientException e) {
            LOGGER.error("Exception while calling CrazyHotelsService ", e);
            throw new ServiceTechnicalException(SERVICE_URL_IS_UNREACHABLE, e);
        }
    }

    private CrazyHotelsResponse response(CrazyHotelsRequest request) {
        return restTemplate.postForObject(CrazyHotelsUrl, request, CrazyHotelsResponse.class);
    }
}
