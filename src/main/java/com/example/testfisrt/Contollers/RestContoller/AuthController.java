package com.example.testfisrt.Contollers.RestContoller;

import com.example.testfisrt.Contollers.RestContoller.Dto.UserSingUp;
import com.example.testfisrt.Infrastructure.Result.Result;
import com.example.testfisrt.Infrastructure.Result.Succeed;
import com.example.testfisrt.Application.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("sing-up")
    public ResponseEntity<Result<Succeed>> SingUp(@RequestBody UserSingUp userSingUp) {

        var result = authService.SingUp(userSingUp);
        if (result.HasError()) {
             return ResponseEntity.badRequest().body(result);
        }

        return ResponseEntity.ok().body(result);
    }


}
