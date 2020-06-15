package com.trido.springboot.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private String message;
    private Date date;
    private int status;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String message, Date date, int status) {
        this.message = message;
        this.date = date;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public int getStatus() {
        return status;
    }
}
