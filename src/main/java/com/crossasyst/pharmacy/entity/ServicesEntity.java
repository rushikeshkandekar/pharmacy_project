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
@Table(name = "services")
public class ServicesEntity {
    @Id
    @SequenceGenerator(name = "service_seq_id", sequenceName = "service_seq_id", initialValue = 5001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_seq_id")
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "service_type")
    private  String serviceType;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacy_id")
    private PharmacyEntity pharmacyEntity;
}
