package com.example.testfisrt.Application;


import com.example.testfisrt.Infrastructure.Repositories.LibraryRepository;
import com.example.testfisrt.Infrastructure.Repositories.UserRepository;
import com.example.testfisrt.Infrastructure.Result.Result;
import com.example.testfisrt.Infrastructure.Result.Succeed;
import com.example.testfisrt.Results;
import com.example.testfisrt.domain.entities.Account;
import com.example.testfisrt.domain.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;


@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraries;

    public Result<Collection<Book>> GetAccountBooks(Account account) {
        var result = libraries.getByAccount(account);
        if (result.isEmpty()) {
            return new Results<Collection<Book>>().LIBRARY_IS_EMPTY;
        }

        var books = Collections.unmodifiableCollection(result.get().books);

        return new Result<Collection<Book>>(books);
    }

    public Result<Succeed> AddBookInAccount(Account account, Book book) {
        var result = libraries.getByAccount(account);
        if (result.isEmpty()) {
            return new Results<Succeed>().LIBRARY_IS_EMPTY;
        }

        var lib = result.get();

        lib.getBooks().add(book);
        libraries.save(lib);

        return new Result<>(new Succeed("book added"));
    }
}
