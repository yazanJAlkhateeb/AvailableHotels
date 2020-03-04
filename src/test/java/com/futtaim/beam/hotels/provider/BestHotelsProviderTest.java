package com.futtaim.beam.hotels.provider;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BestHotelsProviderTest {
    private boolean invoked;

    @Test
    void whenCallProviderThenCallProviderUseCase() {
        new BestHotelsProvider(request -> {
            invoked = true;
            return null;
        }).provide(null);
        assertTrue(invoked);
    }
}