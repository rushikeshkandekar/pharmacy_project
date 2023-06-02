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

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service_timeline")
public class ServiceTimelineEntity {
    @Id
    @SequenceGenerator(name = "service_timeline_seq_id", sequenceName = "service_timeline_seq_id", initialValue = 6001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_timeline_seq_id")
    @Column(name = "service_timeline_id")
    private Long serviceTimeLineId;
    @Column(name = "open_date")
    private LocalDateTime openDate;
    @Column(name = "close_date")
    private LocalDateTime closeDate;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "serviceTimelineEntity")
    private PharmacyEntity pharmacyEntity;

}
