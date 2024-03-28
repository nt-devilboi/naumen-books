package com.example.testfisrt;

import com.example.testfisrt.Infrastructure.Result.Result;
import com.example.testfisrt.domain.entities.Book;

public  class Results<T> {
    public  final Result<T> LIBRARY_IS_EMPTY = new Result<T>("Your library is empty", "you must add book in you library");

}
