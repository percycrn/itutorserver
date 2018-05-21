package com.usst.springbootitutor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, String> {
    List<Class> findByTecTelenumber(String tecTelenumber);

    List<Class> findByStuTelenumber(String stuTelenumber);

    Class findByClassId(int classId);
}
