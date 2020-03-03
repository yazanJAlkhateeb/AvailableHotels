package com.futtaim.beam.hotels.usecase;

public interface UseCase<REQ, RES> {
    RES execute(REQ req);
}
