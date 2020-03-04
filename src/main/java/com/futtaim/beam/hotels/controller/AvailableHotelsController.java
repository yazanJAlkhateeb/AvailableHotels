package com.futtaim.beam.hotels.controller;

import com.futtaim.beam.hotels.controller.dto.AvailableHotelRequest;
import com.futtaim.beam.hotels.controller.dto.AvailableHotelResponse;
import com.futtaim.beam.hotels.usecase.UseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller developed to handle
 * requests
 * and call the main usecase "availableHotelsUseCase" in order to process
 * the request
 */
@Slf4j
@RestController
@RequestMapping("/AvailableHotels")
public class AvailableHotelsController {
    private final UseCase<AvailableHotelRequest, AvailableHotelResponse> availableHotelsUseCase;

    public AvailableHotelsController(UseCase<AvailableHotelRequest, AvailableHotelResponse> availableHotelsUseCase) {
        this.availableHotelsUseCase = availableHotelsUseCase;
    }


    @GetMapping("/")
    public ResponseEntity<AvailableHotelResponse> get(@RequestBody AvailableHotelRequest request) {
        log.info("Received request to get the available hotels {}", request.toString());
        AvailableHotelResponse response = availableHotelsUseCase.execute(request);
        log.info("Produced response {}", response.toString());
        return ResponseEntity.ok(response);
    }

}
