package com.khiempm1.mindx.demo.orb.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginInfo {
    @NotNull
    String userName;
    @NotNull
    String password;
}
