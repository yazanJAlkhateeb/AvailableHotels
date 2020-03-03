package com.futtaim.beam.hotels.usecase.besthotels;

import com.futtaim.beam.hotels.service.Service;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelRequest;
import com.futtaim.beam.hotels.service.besthotels.dto.BestHotelResponse;

public class MockBestHotelsService implements Service<BestHotelRequest, BestHotelResponse> {

        private boolean invoked;
        private BestHotelRequest request;
        private BestHotelResponse response;

        public MockBestHotelsService(BestHotelResponse response) {
            this.response = response;
        }

        @Override
        public BestHotelResponse serve(BestHotelRequest request) {
            this.request = request;
            invoked = true;
            return response;
        }

        public boolean isInvoked() {
            return invoked;
        }
    }
