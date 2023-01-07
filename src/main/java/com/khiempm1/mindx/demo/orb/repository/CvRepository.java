package com.khiempm1.mindx.demo.orb.repository;

import com.khiempm1.mindx.demo.orb.model.Resume;
import com.khiempm1.mindx.demo.orb.model.cvsection.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * For demo, i just use on-memory as repository ;
 */
@Slf4j
@Repository
public class CvRepository {
    /**
     * db to store cv, each element in map is List resume of userID key
     */
    Map<Integer, Set<Resume>> db;

    @PostConstruct
    public void init() {
        db = new HashMap<>();
        // Create some demo resume ;
    }

    /**
     * Method create cv and save to db
     *
     * @param userId
     * @param userInfo
     * @param summary
     * @param experience
     * @param education
     * @param skill
     * @return return true if save successfully, otherwise return false
     */
    public boolean createCv(int userId, UserInfo userInfo, Summary summary, List<JobExperience> experience, List<Education> education, List<Skill> skill) {
        //
        try {
            Resume resume = new Resume().setUserId(userId)
                    .setId(db.size())
                    .setUserInfo(userInfo)
                    .setSummary(summary)
                    .setJobExperience(experience)
                    .setEducation(education)
                    .setSkill(skill);

            if (db.containsKey(userId)) {
                db.get(userId).add(resume);
            } else {
                Set<Resume> list = new HashSet<>();
                list.add(resume);
                db.put(userId, list);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * Update Cv by user ID, resumeId
     *
     * @param userId
     * @param resumeId
     * @param userInfo
     * @param summary
     * @param experience
     * @param education
     * @param skill
     * @return return true if save successfully, otherwise return false
     */
    public boolean updateCv(int userId, int resumeId, UserInfo userInfo, Summary summary, List<JobExperience> experience, List<Education> education, List<Skill> skill) {
        try {
            if (db.containsKey(userId)) {
                Set<Resume> resumes = db.get(userId);
                AtomicBoolean isMatch = new AtomicBoolean(false);
                resumes.forEach(resume -> {
                    if (resume.getId().equals(resumeId)) {
                        isMatch.set(true);

                        resume.setUserInfo(userInfo)
                                .setSummary(summary)
                                .setJobExperience(experience)
                                .setEducation(education)
                                .setSkill(skill);
                    }
                });
                return isMatch.get();

            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    public boolean deleteCv(int userId, int resumeId) {
        try {
            if (db.containsKey(userId)) {
                Set<Resume> resumes = db.get(userId);
                AtomicReference<Resume> matchResume = null;
                resumes.forEach(resume -> {
                    if (resume.getId().equals(resumeId)) {
                        matchResume.set(resume);
                    }
                });
                if (matchResume.get() != null) {
                    resumes.remove(matchResume);
                    return true;
                }

            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    public List<Resume> getAllResumeByUserId(int userId) {
        if (db.containsKey(userId)) {
            return new ArrayList<>(db.get(userId));
        }
        return new ArrayList<>();
    }
}
