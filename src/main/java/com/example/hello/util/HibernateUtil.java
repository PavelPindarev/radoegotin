package com.example.hello.util;

import com.example.hello.init.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import java.util.Properties;

@ApplicationScoped
public class HibernateUtil {
        private static final String url = "jdbc:mysql://localhost:3306/demo_db?createDatabaseIfNotExist=true";
        private static final String username = "root";
        private static final String password = "pavel_2004";

        private SessionFactory sessionFactory;


        @Produces
        @Singleton
        public SessionFactory produceSessionFactory() {
                if (sessionFactory == null) {
                        Configuration configuration = getConfiguration();

                        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties())
                                .build();

                        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                }
                return sessionFactory;
        }

        private static Configuration getConfiguration() {
                Configuration configuration = new Configuration();

                Properties settings = getProperties();

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(UserEntity.class);
                return configuration;
        }

        private static Properties getProperties() {
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, url);
                settings.put(Environment.USER, username);
                settings.put(Environment.PASS, password);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                return settings;
        }
}