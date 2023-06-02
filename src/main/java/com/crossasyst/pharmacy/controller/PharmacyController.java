package com.crossasyst.pharmacy.controller;

import com.crossasyst.pharmacy.model.Pharmacy;
import com.crossasyst.pharmacy.response.PharmacyResponse;
import com.crossasyst.pharmacy.service.PharmacyService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("v1")
public class PharmacyController {
    private final PharmacyService pharmacyService;

    @Autowired
    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(value = "/pharmacies", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PharmacyResponse> createPharmacy(@RequestBody Pharmacy pharmacy) {
        log.info(" Start Creating Pharmacy Master Data");
        PharmacyResponse pharmacyResponse = pharmacyService.createPharmacy(pharmacy);
        return new ResponseEntity<>(pharmacyResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(value = "/pharmacies/{pharmacyId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePharmacyById(@RequestBody Pharmacy pharmacy, @PathVariable Long pharmacyId) {
        log.info("Start Updating Pharmacy Master Data");
        pharmacyService.updatePharmacyById(pharmacy, pharmacyId);
        return ResponseEntity.ok().build();
    }
}
