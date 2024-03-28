package com.example.testfisrt.Infrastructure.Result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result<T> {

    public T Value;
    public String Error;
    public String ErrorExplain;


    private boolean _hasError;

    public Result(T value) {
        Value = value;
    }


    public Result(String error, String errorExplain) {
        Error = error;
        ErrorExplain = errorExplain;
        _hasError = true;
    }


    public boolean HasError() {
        return _hasError;
    }
}
