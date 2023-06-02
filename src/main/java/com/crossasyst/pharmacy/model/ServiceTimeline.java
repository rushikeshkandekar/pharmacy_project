package com.crossasyst.pharmacy.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceTimeline {
    private LocalDateTime openDate;
    private LocalDateTime closeDate;
}
