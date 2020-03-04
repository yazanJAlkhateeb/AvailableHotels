package com.futtaim.beam.hotels.controller;

import com.futtaim.beam.hotels.controller.dto.AvailableHotelRequest;
import com.futtaim.beam.hotels.controller.dto.AvailableHotelResponse;
import com.futtaim.beam.hotels.usecase.UseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RestController
@RequestMapping("/AvailableHotels")
public class AvailableHotelsController {


    private static final Logger logger = LoggerFactory.getLogger(AvailableHotelsController.class);
    private final UseCase<AvailableHotelRequest, AvailableHotelResponse> availableHotelsUseCase;

    public AvailableHotelsController(UseCase<AvailableHotelRequest, AvailableHotelResponse> availableHotelsUseCase) {
        this.availableHotelsUseCase = availableHotelsUseCase;
    }


    @GetMapping("/")
    public ResponseEntity<AvailableHotelResponse> get(@RequestBody AvailableHotelRequest request) {
        logger.info("Received request to get the available hotels");
        AvailableHotelResponse response = availableHotelsUseCase.execute(request);
        return ResponseEntity.ok(response);
    }

}
