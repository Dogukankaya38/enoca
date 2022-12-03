package com.dogukan.enoca7.controller;

import com.dogukan.enoca7.converter.StudentConverter;
import com.dogukan.enoca7.dto.ApiResponseDto;
import com.dogukan.enoca7.dto.StudentRequestDto;
import com.dogukan.enoca7.dto.StudentResponseDto;
import com.dogukan.enoca7.entity.Student;
import com.dogukan.enoca7.service.AddressService;
import com.dogukan.enoca7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@ResponseBody
@RequestMapping("/rest/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentConverter studentConverter;


    @PostMapping("/insert")
    public ApiResponseDto insert(@RequestBody StudentRequestDto student) {
        studentService.save(studentConverter.converterStudent(student));
        return new ApiResponseDto("Ögrenci Kaydedildi!", false);
    }

    @PostMapping("/update")
    public ApiResponseDto update(@RequestBody StudentRequestDto dto, HttpServletResponse response) {
        if (dto.getId() == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return new ApiResponseDto("Ögrenci bilgisi boş olamaz.", true);
        }
        Student studentById = studentService.findById(dto.getId());
        if (studentById == null) {
            return new ApiResponseDto("Ögrenci bilgisi bulunamadı!", true);
        }
        Student student = studentConverter.converterStudent(dto);// kullanıcdan gelen
        studentService.save(student);
        return new ApiResponseDto("Güncelleme yapıldı.", false);
    }

    @PostMapping("/delete/{studentId}")
    public ApiResponseDto delete(@PathVariable Long studentId) {
        Student studentById = studentService.findById(studentId);
        if (studentById == null) {
            return new ApiResponseDto("Ögrenci bilgisi bulunamadı!", true);
        }
        studentService.delete(studentId);
        return new ApiResponseDto("silme işlemi yapıldı.", false);
    }

    @GetMapping("/get")
    public List<StudentResponseDto> findAllStudent() {
        return studentService.findAllStudent().stream()
                .map(student -> studentConverter.converterStudentDto(student))
                .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public StudentResponseDto findFindById(@PathVariable Long id) {
        Student byId = studentService.findById(id);
        StudentResponseDto studentResponseDto = studentConverter.converterStudentDto(byId);
        return studentResponseDto;
    }

}
