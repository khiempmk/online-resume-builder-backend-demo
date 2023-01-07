package com.khiempm1.mindx.demo.orb.service;

import com.khiempm1.mindx.demo.orb.model.Resume;
import com.khiempm1.mindx.demo.orb.repository.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvCrudService {

    @Autowired
    CvRepository cvRepository;

    public boolean cvCreate(Resume resume) {
        return cvRepository.createCv(resume.getUserId(), resume.getUserInfo(), resume.getSummary(), resume.getJobExperience(), resume.getEducation(), resume.getSkill());
    }

    public boolean cvUpdate(Resume resume) {
        return cvRepository.updateCv(resume.getUserId(), resume.getId(), resume.getUserInfo(), resume.getSummary(), resume.getJobExperience(), resume.getEducation(), resume.getSkill());
    }

    public List<Resume> cvGetAll(Integer userId) {
        return cvRepository.getAllResumeByUserId(userId);
    }

    public boolean cvDelete(Integer userId, Integer resumeId) {
        return cvRepository.deleteCv(userId, resumeId);
    }

}
