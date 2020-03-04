package com.futtaim.beam.hotels.provider;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * this class implemented to aggregate providers
 * by make them subscribers into providers event bus
 * and to make it easy to implement another providers
 * just to register them into Provider Factory
 * and implement them separately.
 */
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
