package com.futtaim.beam.hotels.service.besthotels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelRequest;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelResponse;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelsHotel;
import com.futtaim.beam.hotels.service.exception.ServiceTechnicalException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.ResponseActions;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

class BestHotelsServiceTest {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8080";
    ObjectMapper mapper = new ObjectMapper();
    private BestHotelsService service;
    private MockRestServiceServer server;

    @BeforeEach
    public void setUp() {
        server = MockRestServiceServer.createServer(restTemplate);
        service = new BestHotelsService(restTemplate, url);
    }

    @Test
    void givenServiceRequestThenThrowException() {

        ServiceTechnicalException ex = assertThrows(ServiceTechnicalException.class, () -> {
            responseActions()
                    .andRespond(withServerError());
            service.serve(serviceRequest());
            server.verify();
        });
        assertEquals("Service Service URL is unreachable", ex.getMessage());

    }

    @Test
    void givenServiceRequestThenReturnSuccess() throws JsonProcessingException {
        BestHotelRequest request = serviceRequest();


        responseActions()
                .andExpect(content().string(mapper.writeValueAsString(request)))
                .andRespond(withStatus(HttpStatus.OK)
                        .body(createResponse())
                        .contentType(MediaType.APPLICATION_JSON));

        BestHotelResponse response = service.serve(request);
        server.verify();
        BestHotelsHotel hotel = response.getHotels().get(0);
        assertEquals(request.getCity(), "AMM");
        assertEquals(hotel.getHotelName(), "Rixos");
        assertEquals(hotel.getFare(), "10");
        assertEquals(hotel.getAmenities().get(0), "Pool");


    }

    private String createResponse() throws JsonProcessingException {
        BestHotelResponse response = new BestHotelResponse();
        BestHotelsHotel hotel = new BestHotelsHotel();
        hotel.setHotelName("Rixos");
        hotel.setHotelRate("5");
        hotel.setAmenities(Collections.singletonList("Pool"));
        hotel.setFare("10");
        response.setHotels(Collections.singletonList(hotel));
        return mapper.writeValueAsString(response);
    }

    private ResponseActions responseActions() {
        return server.expect(once(), requestTo(url))
                .andExpect(method(HttpMethod.POST));
    }


    private BestHotelRequest serviceRequest() {
        BestHotelRequest request = new BestHotelRequest();
        request.setFromDate(LocalDate.now().toString());
        request.setToDate(LocalDate.now().toString());
        request.setCity("AMM");
        request.setNumberOfAdults(2);
        return request;
    }
}