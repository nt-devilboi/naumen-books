package com.example.testfisrt.Application;


import com.example.testfisrt.Infrastructure.Repositories.BookRepository;
import com.example.testfisrt.Infrastructure.Result.Result;
import com.example.testfisrt.Infrastructure.Result.Succeed;
import com.example.testfisrt.domain.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BookService {
    @Autowired
    private BookRepository books;

    public Result<Succeed> AddBook(Book book) { // стоит хоть какие-то проверки добавить
        var result = books.save(book);

        return new Result<Succeed>(new Succeed("book added"));
    }

    public Result<Book> GetBookById(Long id) { // стоит хоть какие-то проверки добавить
        var result = books.getBookById(id);
        if (result.isEmpty()) {
            return new Result<Book>("book not found", "this book not found");
        }

        return new Result<Book>(result.get());
    }

}
