package com.example.testfisrt.Contollers.RestContoller.BookContoller;


import com.example.testfisrt.Application.BookService;
import com.example.testfisrt.Contollers.RestContoller.BookContoller.Dto.RequestBook;
import com.example.testfisrt.Contollers.RestContoller.BookContoller.Dto.ResponseBook;
import com.example.testfisrt.Infrastructure.Result.Result;
import com.example.testfisrt.Infrastructure.Result.Succeed;
import com.example.testfisrt.domain.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("{id}")
    public Result<ResponseBook> GetBook(@PathVariable("id") Long bookId) throws Exception {
        throw new Exception(); // сделать нормально.
    }

    @PostMapping("add")
    public ResponseEntity<Result<Succeed>> AddBook(RequestBook requestBook) {
        var book = Book.From(requestBook);
        var result = bookService.AddBook(book);

        return ResponseEntity.ok().body(result);
    }


}
