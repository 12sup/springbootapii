package com.te.java.springboot.backend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {

    private String stdName;
    private String stdEmail;
    private long mobileNo;
}
