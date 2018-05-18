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
            Teacher teacher = teacherRepository.findByTelenumber(userPhone);
            if (teacher == null) {
                return false;
            }
            String password = teacher.getPassword();
            return password.equals(userPassword);
        }
        return false;
    }

    // 学生注册
    @CrossOrigin
    @PostMapping(value = "student/register", produces = "application/json;charset=utf-8")
    public boolean studentRegister(@RequestBody Student student) {
        Student stuSaved = studentRepository.findByTelenumber(student.getTelenumber());
        if (stuSaved != null) {
            // 用户已经存在
            return false;
        }
        studentRepository.save(student);
        return true;
    }

    // 教师注册
    @CrossOrigin
    @PostMapping(value = "teacher/register", produces = "application/json;charset=utf-8")
    public boolean teacherRegister(@RequestBody Teacher teacher) {
        Teacher tecSaved = teacherRepository.findByTelenumber(teacher.getTelenumber());
        if (tecSaved != null) {
            // 用户已经存在
            return false;
        }
        teacherRepository.save(teacher);
        return true;
    }

    // 教师完善个人信息
    @CrossOrigin
    @PostMapping(value = "teacher/saveInfo", produces = "application/json; charset=utf-8")
    public boolean modifyTecInfo(@RequestBody Teacher teacher) {
        Teacher teacherSave = teacherRepository.findByTelenumber(teacher.getTelenumber());
        if (teacherSave != null) {
            teacherRepository.save(teacher);
            return true;
        }
        return false;
    }

    // 学生登录后获取该学生所有信息
    @CrossOrigin
    @GetMapping(value = "student/info", produces = "application/json; charset=utf-8")
    public Student getStuInfo() {
        return null;
    }

    // 教师登录后获取该教师所有信息
    @CrossOrigin
    @GetMapping(value = "teacher/info", produces = "application/json; charset=utf-8")
    public Student getTecInfo() {
        return null;
    }
}
