package com.futtaim.beam.hotels.provider;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProvidersEventBusTest {

    @Test
    void whenRegisterProviderThenAddItIntoSubscribers() {
        ProvidersEventBus providersEventBus = new ProvidersEventBus();
        providersEventBus.register(req -> null);
        assertEquals(providersEventBus.getProviders().size(), 1);

    }
}