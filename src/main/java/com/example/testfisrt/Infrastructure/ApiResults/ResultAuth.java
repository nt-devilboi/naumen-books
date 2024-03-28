package com.example.testfisrt.Infrastructure.ApiResults;

import com.example.testfisrt.Infrastructure.Result.Result;
import com.example.testfisrt.Infrastructure.Result.Succeed;

public class ResultAuth {


    public static final Result<Succeed> UserCreated = new Result<Succeed>(new Succeed("UserCreated"));
    public static final Result<Succeed> UserExistedYet = new Result<Succeed>("this user name existed", "try use other username");
}
