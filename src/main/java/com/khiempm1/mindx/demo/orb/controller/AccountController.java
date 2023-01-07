package com.khiempm1.mindx.demo.orb.controller;

import com.khiempm1.mindx.demo.orb.model.request.LoginInfo;
import com.khiempm1.mindx.demo.orb.model.request.RegisterInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AccountController {


    @PostMapping(path = "/user/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginInfo loginInfo){
        return null ;
    }

    @PostMapping(path = "/user/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterInfo registerInfo){
        return  null;
    }
}
