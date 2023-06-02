package com.crossasyst.pharmacy.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pharmacy {
    private Integer ncpdpdNpi;
    private String pharmacyName;
    private  Long storeNumber;
    private Address address;
    private OtherInformation otherInformation;
    private ServiceTimeline serviceTimeline;
    private List<Services> serviceList;
    private List<PharmacyContact> pharmacyContactList;


}
