package com.khiempm1.mindx.demo.orb.model.cvsection;

import lombok.Data;

import java.util.Date;

@Data
public class JobExperience {
    String jobTitle;
    String company;
    Date startDate ;
    Date endDate ;
    String jobDescription ;
}
