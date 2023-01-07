package com.khiempm1.mindx.demo.orb.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RegisterInfo {
    @NotNull
    String userName;
    @NotNull
    String userPassword;
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    @NotNull
    Date birthDay;
    @NotNull
    String email;
}
