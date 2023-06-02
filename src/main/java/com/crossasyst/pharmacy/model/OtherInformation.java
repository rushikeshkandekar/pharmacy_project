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
public class OtherInformation {
    private String systemVersion;
    private String licenseNumber;
    private Boolean digitalSignatureSupport;
}
