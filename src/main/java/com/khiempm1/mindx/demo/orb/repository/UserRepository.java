package com.khiempm1.mindx.demo.orb.repository;

import com.khiempm1.mindx.demo.orb.model.User;
import com.khiempm1.mindx.demo.orb.model.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class UserRepository {

    Map<Integer, User> db = new HashMap<>();

    @PostConstruct
    public void init() {
        db = new HashMap<>();
        // Create some demo user ;
        User user = new User()
                .setUserId(0)
                .setUserName("khiempm1")
                .setUserPassword("123456")
                .setUserRole(UserRole.USER);
        createUser(user);
    }
    /**
     * Save new user to database
     *
     * @param user
     * @return success or not
     */
    public boolean createUser(User user) {
        try {
            db.put(db.size(), user);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * Get user by userName
     *
     * @param userName
     * @return User if found, otherwise return null
     */
    public User getUserByUserName(String userName) {
        try {
            List<User> users = db.values().stream().filter(user -> user.getUserName().equals(userName))
                    .collect(Collectors.toList());
            if (users.size() > 0)
                return users.get(0);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
