package com.khiempm1.mindx.demo.orb.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    Integer userId;
    String userName;
    String userPassword;
    String firstName;
    String lastName;
    Date birthDay;
    String email;
    String otherInformation;
    UserRole userRole;
}
