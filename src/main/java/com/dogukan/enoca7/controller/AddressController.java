package com.dogukan.enoca7.controller;

import com.dogukan.enoca7.converter.AddressConverter;
import com.dogukan.enoca7.dto.AddressDto;
import com.dogukan.enoca7.dto.ApiResponseDto;
import com.dogukan.enoca7.entity.Address;
import com.dogukan.enoca7.entity.Student;
import com.dogukan.enoca7.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@ResponseBody
@RequestMapping("/rest/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressConverter addressConverter;

    @PostMapping("/insert")
    public ApiResponseDto insert(@RequestBody AddressDto address) {
        addressService.save(addressConverter.converterAddress(address));
        return new ApiResponseDto("Adres Kaydedildi!", false);
    }

    @PostMapping("/update")
    public ApiResponseDto Update(@RequestBody Address address, HttpServletResponse response) {
        if (address.getId() == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return new ApiResponseDto("Adres bilgisi boş olamaz.", true);
        }
        Address addressFindById = addressService.findFindById(address.getId());
        if (addressFindById == null) {
            return new ApiResponseDto("Adres bilgisi bulunamadı!", true);
        }
        addressService.save(address);
        return new ApiResponseDto("Güncelleme yapıldı.", false);
    }

    @PostMapping("/delete/{addressId}")
    public ApiResponseDto delete(@PathVariable Long addressId) {
        Address addressById = addressService.findFindById(addressId);
        if (addressById == null) {
            return new ApiResponseDto("Adres bilgisi bulunamadı!", true);
        }
        addressService.delete(addressId);
        return new ApiResponseDto("silme işlemi yapıldı.", false);
    }

    @GetMapping("/get")
    public List<AddressDto> findAllAddress() {
        return addressService.findAllAddress().stream()
                .map(address -> addressConverter.converterAddressDto(address))
                .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public AddressDto findByCode(@PathVariable Long id, HttpServletResponse response) {
        if (id == 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        Address findById = addressService.findFindById(id);
        if (findById == null){
            return null;
        }
        return addressConverter.converterAddressDto(findById);
    }

}
