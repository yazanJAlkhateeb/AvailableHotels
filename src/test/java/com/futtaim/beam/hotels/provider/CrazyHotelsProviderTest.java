package com.futtaim.beam.hotels.provider;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CrazyHotelsProviderTest {

    private boolean invoked;

    @Test
    void whenCallProviderThenCallProviderUseCase() {
        new CrazyHotelsProvider(request -> {
            invoked = true;
            return null;
        }).provide(null);
        assertTrue(invoked);
    }
}