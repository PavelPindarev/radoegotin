package com.example.hello.init;

import com.example.hello.dao.UserDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class UserInitDB {

        @Inject
        private UserDAO userDAO;

        @PostConstruct
        public void init(@Observes @Initialized(RequestScoped.class) Object init) {
                List<UserEntity> users = new ArrayList<>();
                UserEntity admin = new UserEntity("Admin", "Adminov", 29, LocalDateTime.of(2022, 8, 23, 13, 50));
                users.add(admin);
                for (int i = 0; i < 100; i++) {
                        UserEntity user = new UserEntity("User", "Userov", 19, LocalDateTime.of(2015, 7, 22, 4, 40));
                        users.add(user);
                }
                users.forEach(u -> this.userDAO.saveUser(u));
        }

}
