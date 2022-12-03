package com.dogukan.enoca7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDto {

    private String message;
    private boolean hasError = false;

}
