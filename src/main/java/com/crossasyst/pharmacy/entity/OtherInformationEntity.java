package com.crossasyst.pharmacy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "other_information")
public class OtherInformationEntity {
    @Id
    @SequenceGenerator(name = "otherInformation_seq_id", sequenceName = "otherInformation_seq_id", initialValue = 2001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "otherInformation_seq_id")
    @Column(name = "otherInformation_id")
    private Long otherInformationId;
    @Column(name = "system_version")
    private String systemVersion;
    @Column(name = "license_number")
    private String licenseNumber;
    @Column(name = "digital_signature_support")
    private Boolean digitalSignatureSupport;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "otherInformationEntity")
    private PharmacyEntity pharmacyEntity;


}
