package com.te.java.springboot.backend.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GeneralResponce {
    private HttpStatus httpStatus;
    private String message;
    private String error;
    private Object data;
}
