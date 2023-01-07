package com.khiempm1.mindx.demo.orb.controller;

import com.khiempm1.mindx.demo.orb.model.Resume;
import com.khiempm1.mindx.demo.orb.model.response.ResponseBody;
import com.khiempm1.mindx.demo.orb.service.CvCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CvCrudController {

    @Autowired
    CvCrudService cvCrudService;

    @PostMapping(path = "/cv/create")
    public ResponseEntity<Object> createCV(@RequestBody @Valid Resume resume){
        boolean isSuccess = cvCrudService.cvCreate(resume);
        if (isSuccess)
            return new ResponseEntity<>(new ResponseBody<>(0, "Create Cv success !!", null), HttpStatus.OK);
        else
            return new ResponseEntity<>(new ResponseBody<>(1, "Error", "Create CV failed, please try again"), HttpStatus.OK);
    }

    @PostMapping(path = "/cv/update")
    public ResponseEntity<Object> updateCV(@RequestBody @Valid Resume resume){
        boolean success = cvCrudService.cvUpdate(resume);
        if (success) {
            return new ResponseEntity<>(new ResponseBody<>(0, "Ok", "Update Cv success !!"), HttpStatus.OK);
        } else
            return new  ResponseEntity<>(new ResponseBody<>(1, "Ok", "Cv update not found in system, please try again"), HttpStatus.OK);
    }

    @GetMapping(path = "/cv/get/all")
    public ResponseEntity<Object> createCV(@RequestParam int userId){
        List<Resume> resumes = cvCrudService.cvGetAll(userId);
        return new ResponseEntity<>(new ResponseBody<>(0, "ok", resumes), HttpStatus.OK);
    }

    @PostMapping(path = "/cv/delete")
    public ResponseEntity<Object> deleteCv(@RequestBody @Valid Resume resume){
        boolean success = cvCrudService.cvDelete(resume.getUserId(), resume.getId());
        if (success) {
            return new ResponseEntity<>(new ResponseBody<>(0, "Ok", "Delete Cv success !!"), HttpStatus.OK);
        } else
            return new  ResponseEntity<>(new ResponseBody<>(1, "Ok", "Cv update not found in system, can't delete, please try again"), HttpStatus.OK);
    }

}
