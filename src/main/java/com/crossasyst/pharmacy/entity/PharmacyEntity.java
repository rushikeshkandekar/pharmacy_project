package com.crossasyst.pharmacy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pharmacy")
public class PharmacyEntity {
    @Id
    @SequenceGenerator(name = "pharmacy_seq_id", sequenceName = "pharmacy_seq_id", initialValue = 4001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pharmacy_seq_id")
    @Column(name = "pharmacy_id")
    private Long pharmacyId;
    @Column(name = "pharmacy_name")
    private String pharmacyName;
    @Column(name = "ncpdpd_npi")
    private Integer ncpdpdNpi;
    @Column(name = "store_number")
    private Long storeNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "otherInformation_id")
    private OtherInformationEntity otherInformationEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "service_timeline_id")
    private ServiceTimelineEntity serviceTimelineEntity;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacy_id")
    private List<ServicesEntity> serviceEntityList;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacy_id")
    private List<PharmacyContactEntity> pharmacyContactEntityList;


}
