package com.te.java.springboot.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "std_id")
    private Integer stdId;
    @Column(name = "std_name")
    private String stdName;
    @Column(name = "std_email")
    private String stdEmail;
    @Column(name = "mobile_no")
    private long mobileNo;


}
