package com.crossasyst.pharmacy.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String country;
    private Long zipCode;
    private Double latitude;
    private Double longitude;

}
