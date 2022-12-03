package com.dogukan.enoca7.service;

import com.dogukan.enoca7.dao.StudentDao;
import com.dogukan.enoca7.entity.Address;
import com.dogukan.enoca7.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public void save(Student student) {
        studentDao.save(student);
    }

    public List<Student> findAllStudent() {
        return studentDao.findAll();
    }

    public Student findById(Long id) {
        return studentDao.findById(id).orElse(null);
    }

    public void delete(Long student) {
        studentDao.deleteById(student);
    }
}
