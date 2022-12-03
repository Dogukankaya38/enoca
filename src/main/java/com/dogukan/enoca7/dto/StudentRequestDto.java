package com.dogukan.enoca7.dto;

import lombok.Data;

@Data
public class StudentRequestDto {
    private Long id;
    private String name;
    private String lastName;
    private String department;
    private Long address;
}
