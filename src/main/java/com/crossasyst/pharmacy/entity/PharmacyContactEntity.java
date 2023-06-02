package com.crossasyst.pharmacy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pharmacy_contact")
public class PharmacyContactEntity {
    @Id
    @SequenceGenerator(name = "pharmacy_contact_seq_id", sequenceName = "pharmacy_contact_seq_id", initialValue = 3001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pharmacy_contact_seq_id")
    @Column(name = "pharmacy_contact_id")
    private Long pharmacyContactId;
    @Column(name = "contact_number")
    private  Integer contactNumber;
    @Column(name = "fax")
    private  String fax;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacy_id")
    private PharmacyEntity pharmacyEntity;

}
