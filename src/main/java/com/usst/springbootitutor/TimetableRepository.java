package com.usst.springbootitutor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<Timetable, String> {
}
