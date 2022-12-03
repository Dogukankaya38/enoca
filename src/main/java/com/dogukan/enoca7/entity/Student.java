package com.dogukan.enoca7.entity;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @SequenceGenerator(name = "SEQ_STUDENT_GEN", sequenceName = "SEQ_STUDENT_GEN")
    @GeneratedValue(generator = "SEQ_STUDENT_GEN")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "department", nullable = false)
    private String department;

    @ManyToOne
    private Address address;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
