package com.example.testfisrt.infrastucture;

import com.example.testfisrt.Infrastructure.Result.Result;
import com.example.testfisrt.domain.entities.Account;

public interface IUserManager {

    public Result<Account> GetUserById(Long id);

}
