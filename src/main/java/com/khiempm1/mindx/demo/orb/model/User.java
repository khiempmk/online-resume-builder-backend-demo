package com.khiempm1.mindx.demo.orb.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
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
