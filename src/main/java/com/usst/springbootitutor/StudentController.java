package com.usst.springbootitutor;

import org.springframework.web.bind.annotation.*;
import pojo.Login;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final NoticeRepository noticeRepository;

    public StudentController(StudentRepository studentRepository, ClassRepository classRepository,
                             NoticeRepository noticeRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
        this.noticeRepository = noticeRepository;
    }

    // 学生注册
    @CrossOrigin
    @PostMapping(value = "register")
    public int studentRegister(@RequestBody Student student) {
        Student stuSaved = studentRepository.findByTelenumber(student.getTelenumber());
        if (stuSaved != null) {
            // 用户已经存在
            return 2;
        }
        student.setBalances(500);
        student.setAge(0);
        student.setSex(0);
        studentRepository.save(student);
        return 1;
    }

    // 学生登录后获取该学生所有信息
    @CrossOrigin
    @PostMapping(value = "info")
    public Student getStuInfo(@RequestBody Login login) {
        // TODO 筛选发送给前端的信息
        return studentRepository.findByTelenumber(login.getTelenumber());
    }

    // 学生完善个人信息
    @CrossOrigin
    @PostMapping(value = "saveInfo")
    public int stuSaveInfo(@RequestBody Student student) {
        Student savedStu = studentRepository.findByTelenumber(student.getTelenumber());
        if (savedStu == null) {
            return 2;
        }
        savedStu.setSex(student.getSex());
        savedStu.setAge(student.getAge());
        studentRepository.save(savedStu);
        return 1;
    }

    // 返回所有未被选的课程
    @CrossOrigin
    @GetMapping(value = "getClassList")
    public List<Class> getClassList() {
        List<Class> savedClasses = classRepository.findAll();
        List<Class> classes = new ArrayList<>();
        for (Class aClass : savedClasses) {
            if (aClass.getStuTelenumber() == null) {
                classes.add(aClass);
            }
        }
        return classes;
    }

    // 学生支付课程
    @CrossOrigin
    @PostMapping(value = "pay")
    public int pay(@RequestBody Class sentClass) {
        // 获得该课程对象
        Class savedClass = classRepository.findByClassId(sentClass.getClassId());
        // 获得该学生对象
        Student savedStudent = studentRepository.findByTelenumber(sentClass.getStuTelenumber());
        // 将学生手机号和姓名存入
        if (savedClass == null || savedStudent == null) {
            return 2;
        }
        savedClass.setStuTelenumber(sentClass.getStuTelenumber());
        savedClass.setStuName(savedStudent.getName());
        classRepository.save(savedClass);
        return 1;
    }

    // 学生获取自己购买的课程列表
    @CrossOrigin
    @PostMapping(value = "getMyClassList")
    public List<Class> getMyClassList(@RequestBody Class aClass) {
        return classRepository.findByStuTelenumber(aClass.getStuTelenumber());
    }

    // 学生在自己购买的课程查看公告
    @CrossOrigin
    @PostMapping(value = "getNotice")
    public List<Notice> getNotice(@RequestBody Notice notice) {
        return noticeRepository.findByClassId(notice.getClassId());
    }
}
