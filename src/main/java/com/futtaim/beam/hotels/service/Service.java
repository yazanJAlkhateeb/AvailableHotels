package com.futtaim.beam.hotels.service;

@FunctionalInterface
public interface Service<REQ, RES> {
    RES serve(REQ request);
}
