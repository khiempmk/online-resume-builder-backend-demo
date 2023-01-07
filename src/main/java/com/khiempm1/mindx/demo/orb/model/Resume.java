package com.khiempm1.mindx.demo.orb.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.khiempm1.mindx.demo.orb.model.cvsection.*;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class Resume {
    Integer id;
    @NotNull
    Integer userId;
    UserInfo userInfo;
    Summary summary;
    List<JobExperience> jobExperience;
    List<Education> education;
    List<Skill> skill;

    public static void main(String[] args) throws JsonProcessingException {
        Resume resume = new Resume();
        resume.setUserId(0);

        UserInfo userInfo = new UserInfo();
        userInfo.setName("Phạm Minh Khiêm");
        userInfo.setEmail("khiempm1@gmail.com");
        userInfo.setMobile("03929932525");
        resume.setUserInfo(userInfo);

        JobExperience jobExperience = new JobExperience();
        jobExperience.setCompany("Viettel Cybserspace");
        jobExperience.setStartDate(new Date());
        jobExperience.setJobTitle("Backend");
        List<JobExperience> experiences = new ArrayList<>();
        experiences.add(jobExperience);
        resume.setJobExperience(experiences);


        Education education = new Education();
        education.setSchool("ĐH Bách Khoa");
        education.setGpa(3.33);
        List<Education> educations = new ArrayList<>();
        educations.add(education);
        resume.setEducation(educations);


        System.out.println(new ObjectMapper().writeValueAsString(resume));
    }
}
