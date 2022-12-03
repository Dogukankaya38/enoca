package com.dogukan.enoca7.dto;

import lombok.Data;

@Data
public class StudentResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private String department;
    private AddressDto address;
}
