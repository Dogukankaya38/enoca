package com.dogukan.enoca7.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private Long code;
    private String city;
    private String province;
    private String street;
}
