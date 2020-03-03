package com.futtaim.beam.hotels.provider;

import com.futtaim.beam.hotels.usecase.domain.EnquiryRequest;
import com.futtaim.beam.hotels.usecase.domain.Hotel;

import java.util.List;

public interface Provider {
    List<Hotel> provide(EnquiryRequest req);
}
