package com.dogukan.enoca7.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {

    @Id
    @SequenceGenerator(name = "SEQ_ADDRESS_GEN", sequenceName = "SEQ_ADDRESS_GEN")
    @GeneratedValue(generator = "SEQ_ADDRESS_GEN")
    private Long id;

    @Column(name = "code", nullable = false)
    private Long code;
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "street")
    private String street;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private List<Student> studentList;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getCode() {
        return code;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
