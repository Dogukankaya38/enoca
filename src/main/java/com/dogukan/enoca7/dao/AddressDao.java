package com.dogukan.enoca7.dao;

import com.dogukan.enoca7.entity.Address;
import com.dogukan.enoca7.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AddressDao extends JpaRepository<Address, Long> {

    Optional<Address> findAllById(Long code);

    void deleteById(Long aLong);
}
