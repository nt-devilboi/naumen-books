package com.example.testfisrt.Contollers.RestContoller;


import com.example.testfisrt.Application.BookService;
import com.example.testfisrt.Application.LibraryService;
import com.example.testfisrt.Infrastructure.Result.Succeed;
import com.example.testfisrt.infrastucture.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/{userId}/library")
public class LibraryController {

    @Autowired
    IUserManager userManager;

    @Autowired
    public LibraryService libraryService;
    @Autowired
    public BookService bookService;

    @PostMapping("add/book/{bookId}")
    public ResponseEntity add(@PathVariable Long userId, @PathVariable Long bookId){

        var accountResult = userManager.GetUserById(userId);
        if (accountResult.HasError()){
            return ResponseEntity.badRequest().body(accountResult.Value);
        }
        var bookResult = bookService.GetBookById(bookId);
        if (bookResult.HasError()){
            return ResponseEntity.badRequest().body(bookResult.Value);
        }


        var result = libraryService.AddBookInAccount(accountResult.Value, bookResult.Value);
        if (result.HasError()){
            return ResponseEntity.badRequest().body(result.Value);
        }

        return ResponseEntity.ok().body(result.Value);
    }



}
