package com.futtaim.beam.hotels.usecase.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class EnquiryRequest {
    private LocalDate fromDate;
    private LocalDate toDate;
    private String city;
    private int numberOfAdults;
}
