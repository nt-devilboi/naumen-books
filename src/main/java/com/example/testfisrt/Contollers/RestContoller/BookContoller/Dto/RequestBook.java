package com.example.testfisrt.Contollers.RestContoller.BookContoller.Dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestBook {
    public String Name;
    public String Author;
    public LocalDate DateRelease;
    public String Desc;
}
