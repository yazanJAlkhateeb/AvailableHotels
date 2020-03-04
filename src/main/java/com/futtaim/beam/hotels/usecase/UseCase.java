package com.futtaim.beam.hotels.usecase;
@FunctionalInterface
public interface UseCase<REQ, RES> {
    RES execute(REQ req);
}
