package com.crossasyst.pharmacy.service;

import com.crossasyst.pharmacy.entity.AddressEntity;
import com.crossasyst.pharmacy.entity.OtherInformationEntity;
import com.crossasyst.pharmacy.entity.PharmacyEntity;
import com.crossasyst.pharmacy.entity.ServiceTimelineEntity;
import com.crossasyst.pharmacy.mapper.PharmacyMapper;
import com.crossasyst.pharmacy.model.Pharmacy;
import com.crossasyst.pharmacy.repository.PharmacyRepository;
import com.crossasyst.pharmacy.response.PharmacyResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PharmacyService {

    private final PharmacyRepository pharmacyRepository;
    private final PharmacyMapper pharmacyMapper;

    @Autowired
    public PharmacyService(PharmacyRepository pharmacyRepository, PharmacyMapper pharmacyMapper) {
        this.pharmacyRepository = pharmacyRepository;
        this.pharmacyMapper = pharmacyMapper;
    }

    public PharmacyResponse createPharmacy(Pharmacy pharmacy) {
        PharmacyEntity pharmacyEntity = pharmacyMapper.modelToEntity(pharmacy);
        pharmacyRepository.save(pharmacyEntity);
        log.info("PharmacyRepository Save Successfully");
        PharmacyResponse pharmacyResponse = new PharmacyResponse();
        pharmacyResponse.setPharmacyId(pharmacyEntity.getPharmacyId());
        log.info("Pharmacy Master Data Create Successfully With Id={}", pharmacyResponse.getPharmacyId());
        return pharmacyResponse;
    }

    public void updatePharmacyById(Pharmacy pharmacy, Long pharmacyId) {
        PharmacyEntity pharmacyEntity = pharmacyRepository.findById(pharmacyId).get();
        AddressEntity addressEntity = pharmacyEntity.getAddressEntity();
        Long addressId = addressEntity.getAddressId();

        OtherInformationEntity otherInformationEntity = pharmacyEntity.getOtherInformationEntity();
        Long otherInfoId = otherInformationEntity.getOtherInformationId();

        ServiceTimelineEntity serviceTimelineEntity = pharmacyEntity.getServiceTimelineEntity();
        Long serviceTimelineId = serviceTimelineEntity.getServiceTimeLineId();

        PharmacyEntity pharmacyEntity1 = pharmacyMapper.modelToEntity(pharmacy);

        pharmacyEntity1.setPharmacyId(pharmacyEntity.getPharmacyId());
        pharmacyEntity1.getAddressEntity().setAddressId(addressId);
        pharmacyEntity1.getOtherInformationEntity().setOtherInformationId(otherInfoId);
        pharmacyEntity1.getServiceTimelineEntity().setServiceTimeLineId(serviceTimelineId);
        pharmacyRepository.save(pharmacyEntity1);

        log.info("Pharmacy Master Data Update Successfully");

    }
}