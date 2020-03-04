package com.futtaim.beam.hotels.provider;

import com.futtaim.beam.hotels.controller.dto.Hotel;
import com.futtaim.beam.hotels.domain.EnquiryRequest;

import java.util.List;

@FunctionalInterface
public interface Provider {
    List<Hotel> provide(EnquiryRequest req);
}
