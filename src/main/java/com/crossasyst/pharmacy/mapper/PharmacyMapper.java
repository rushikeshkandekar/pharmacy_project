package com.crossasyst.pharmacy.mapper;

import com.crossasyst.pharmacy.entity.PharmacyEntity;
import com.crossasyst.pharmacy.model.Pharmacy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PharmacyMapper {

    @Mapping(source = "address",target = "addressEntity")
    @Mapping(source = "otherInformation",target = "otherInformationEntity")
    @Mapping(source = "serviceTimeline",target = "serviceTimelineEntity")
    @Mapping(source = "serviceList",target = "serviceEntityList")
    @Mapping(source = "pharmacyContactList",target = "pharmacyContactEntityList")

    PharmacyEntity modelToEntity(Pharmacy pharmacy);

    @Mapping(target = "address",source = "addressEntity")
    @Mapping(target = "otherInformation",source = "otherInformationEntity")
    @Mapping(target = "serviceTimeline",source = "serviceTimelineEntity")
    @Mapping(target = "serviceList",source = "serviceEntityList")
    @Mapping(target = "pharmacyContactList",source = "pharmacyContactEntityList")
    Pharmacy entityToModel(PharmacyEntity pharmacyEntity);
}
