package com.usst.springbootitutor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByTelenumber(String telenumber);
}
