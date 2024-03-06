package com.example.hello.worker;


import com.example.hello.dao.UserDAO;

import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@Singleton
public class AsyncService {

        private String result;

        @Inject
        private UserDAO userDAO;

        @Asynchronous
        @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
        public void performAsync() {
                List<Integer> olderThan = userDAO.findIdOlderThan(LocalDateTime.of(2021, 2, 11, 4, 20));
                this.setResult("Counted records " + olderThan.size());
        }

        public String getResult() {
                return result;
        }

        public void setResult(String result) {
                this.result = result;
        }
}
