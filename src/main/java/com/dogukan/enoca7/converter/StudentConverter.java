package com.dogukan.enoca7.converter;

import com.dogukan.enoca7.dto.StudentRequestDto;
import com.dogukan.enoca7.dto.StudentResponseDto;
import com.dogukan.enoca7.entity.Student;
import com.dogukan.enoca7.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {
    @Autowired
    private AddressConverter addressConverter;

    @Autowired
    private AddressService addressService;

    public StudentResponseDto converterStudentDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setLastName(student.getLast_name());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setAddress(addressConverter.converterAddressDto(student.getAddress()));
        return studentResponseDto;
    }

    public Student converterStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setId(studentRequestDto.getId());
        student.setName(studentRequestDto.getName());
        student.setLast_name(studentRequestDto.getLastName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setAddress(addressService.findFindById(studentRequestDto.getAddress()));
        return student;
    }
}
