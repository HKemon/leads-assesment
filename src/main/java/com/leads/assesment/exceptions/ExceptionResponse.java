package com.leads.assesment.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/*
 * Customize the Exception Response
 */
@Data
@AllArgsConstructor
class ExceptionResponse {
    private Date timeStamp;
    private String message;
    private String details;
}
