package com.dogukan.enoca7.service;

import com.dogukan.enoca7.dao.AddressDao;
import com.dogukan.enoca7.dao.StudentDao;
import com.dogukan.enoca7.dto.AddressDto;
import com.dogukan.enoca7.entity.Address;
import com.dogukan.enoca7.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    public void save(Address address) {
        addressDao.save(address);
    }

    public List<Address> findAllAddress() {
        return addressDao.findAll();
    }

    public Address findFindById(Long id) {
        return addressDao.findAllById(id).orElse(null);
    }

    public void delete(Long address) {
        addressDao.deleteById(address);
    }
}
