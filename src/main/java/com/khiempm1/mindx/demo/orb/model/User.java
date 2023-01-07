package com.khiempm1.mindx.demo.orb.model;

import lombok.Data;

@Data
public class User {
    Integer userId ;
    String userName ;
    String userPassword;
    UserRole userRole;
}
