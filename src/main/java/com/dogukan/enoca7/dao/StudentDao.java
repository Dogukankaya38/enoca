package com.dogukan.enoca7.dao;

import com.dogukan.enoca7.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentDao extends JpaRepository<Student, Long> {

}
