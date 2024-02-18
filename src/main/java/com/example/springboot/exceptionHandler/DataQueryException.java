package com.example.springboot.exceptionHandler;

import org.springframework.dao.DataAccessException;
import org.springframework.lang.Nullable;

public class DataQueryException extends DataAccessException {

    public DataQueryException(@Nullable String msg, @Nullable Throwable cause) {
        super(msg, cause);
    }
}
