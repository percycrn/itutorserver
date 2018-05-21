package com.usst.springbootitutor;

import org.springframework.web.bind.annotation.*;
import pojo.Login;

@RestController
public class LoginController {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public LoginController(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    // 教师和学生登录
    @CrossOrigin
    @PostMapping(value = "common/login")
    public int login(@RequestBody Login login) {
        int userIdentify = login.getIdentify();
        String userPhone = login.getTelenumber();
        String userPassword = login.getPassword();
        // 学生登录
        if (userIdentify == 1) {
            Student student = studentRepository.findByTelenumber(userPhone);
            if (student == null) {
                return 2;
            }
            String password = student.getPassword();
            if (password.equals(userPassword)) {
                return 1;
            } else {
                return 2;
            }
        }
        // 老师登录
        if (userIdentify == 2) {
            Teacher teacher = teacherRepository.findByTelenumber(userPhone);
            if (teacher == null) {
                return 2;
            }
            String password = teacher.getPassword();
            if (password.equals(userPassword)) {
                return 1;
            } else {
                return 2;
            }
        }
        return 2;
    }
}
