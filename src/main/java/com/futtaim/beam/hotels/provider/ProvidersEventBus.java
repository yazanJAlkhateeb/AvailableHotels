package com.futtaim.beam.hotels.provider;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProvidersEventBus {
    private List<Provider> subscribers = new ArrayList<>();

    public void register(Provider subscriber) {
        subscribers.add(subscriber);
    }

    public List<Provider> getProviders() {
        return Collections.unmodifiableList(subscribers);
    }
}
