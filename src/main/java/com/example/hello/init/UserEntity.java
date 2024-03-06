package com.example.hello.init;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String firstName;

        private String lastName;

        private int age;


        private LocalDateTime created;

        public UserEntity(String firstName, String lastName, int age, LocalDateTime created) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.age = age;
                this.created = created;
        }

        public UserEntity() {
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public LocalDateTime getCreated() {
                return created;
        }

        public void setCreated(LocalDateTime created) {
                this.created = created;
        }
}
