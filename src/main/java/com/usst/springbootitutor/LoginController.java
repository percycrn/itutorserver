package com.usst.springbootitutor;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public LoginController(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @CrossOrigin
    @PostMapping(value = "/login", produces = "application/json; charset=utf-8")
    public boolean login(@RequestBody Login login) {
        int userIdentify = login.getUserIdentify();
        String userPhone = login.getUserPhone();
        String userPassword = login.getUserPassword();
        System.out.println(userIdentify);
        System.out.println(userPhone);
        System.out.println(userPassword);
        // 学生登录
        if (userIdentify == 1) {
            Student student = studentRepository.findByTelenumber(userPhone);
            System.out.println(student);
            if (student == null) {
                return false;
            }
            String password = student.getPassword();
            return password.equals(userPassword);
        }
        // 老师登录
        if (userIdentify == 2) {
            Teacher teacher = teacherRepository.findByPhoneNumber(userPhone);
            if (teacher == null) {
                return false;
            }
            String password = teacher.getPassword();
            return password.equals(userPassword);
        }
        return false;
    }
}
