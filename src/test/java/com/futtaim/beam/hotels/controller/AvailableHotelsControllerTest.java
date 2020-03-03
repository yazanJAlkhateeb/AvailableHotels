package com.futtaim.beam.hotels.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AvailableHotelsControllerTest {
    private boolean useCaseCalled;

    @Test
    void testCallingAvailableHotelsUseCase() {
        new AvailableHotelsController(request -> {
            useCaseCalled = true;
            return null;
        }).get(null);
        assertTrue(useCaseCalled);
    }
}