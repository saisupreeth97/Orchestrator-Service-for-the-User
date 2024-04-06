package com.supreeth.userapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3152415518753820290L;
    private String errorCode;
    private String errorMessage;
}
