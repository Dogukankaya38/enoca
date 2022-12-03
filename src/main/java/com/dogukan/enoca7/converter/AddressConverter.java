package com.dogukan.enoca7.converter;

import com.dogukan.enoca7.dto.AddressDto;
import com.dogukan.enoca7.entity.Address;
import com.dogukan.enoca7.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AddressConverter {

    public AddressDto converterAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCode(address.getCode());
        addressDto.setCity(address.getCity());
        addressDto.setProvince(address.getProvince());
        addressDto.setStreet(address.getStreet());
        return addressDto;
    }

    public Address converterAddress(AddressDto dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setCode(dto.getCode());
        address.setCity(dto.getCity());
        address.setProvince(dto.getProvince());
        address.setStreet(dto.getStreet());
        return address;
    }
}
