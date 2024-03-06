package com.example.hello.dao;

import com.example.hello.init.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

@Named
@RequestScoped
public class UserDAO {

        @Inject
        private SessionFactory sessionFactory;

        public void deleteUser(int id) {
                try (Session session = sessionFactory.openSession()) {
                        Transaction tx = session.beginTransaction();
                        UserEntity user = session.get(UserEntity.class, id);
                        if (user != null) {
                                session.remove(user);
                        }
                        tx.commit();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public void saveUser(UserEntity user) {
                try (Session session = sessionFactory.openSession()) {
                        Transaction tx = session.beginTransaction();
                        session.persist(user);
                        tx.commit();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public List<UserEntity> getAllUsers() {
                try (Session session = sessionFactory.openSession()) {
                        Transaction tx = session.beginTransaction();
                        List<UserEntity> users = session.createQuery("FROM UserEntity", UserEntity.class).getResultList();
                        tx.commit();
                        return users;
                } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                }
        }

        public List<Integer> findIdOlderThan(LocalDateTime localDateTime) {
                try (Session session = sessionFactory.openSession()) {
                        Transaction tx = session.beginTransaction();
                        List<Integer> usersId = session.createQuery("SELECT u.id FROM UserEntity u WHERE created < :localDateTime", Integer.class)
                                .setParameter("localDateTime", localDateTime)
                                .getResultList();
                        tx.commit();
                        return usersId;
                } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                }
        }


}