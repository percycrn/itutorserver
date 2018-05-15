package com.usst.springbootitutor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByPhoneNumber(String phoneNumber);
}
