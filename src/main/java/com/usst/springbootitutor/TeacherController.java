package com.usst.springbootitutor;

import org.springframework.web.bind.annotation.*;
import pojo.Login;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    private final TeacherRepository teacherRepository;
    private final ClassRepository courseRepository;
    private final NoticeRepository noticeRepository;
    private final ClassRepository classRepository;

    public TeacherController(TeacherRepository teacherRepository, ClassRepository courseRepository,
                             NoticeRepository noticeRepository, ClassRepository classRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.noticeRepository = noticeRepository;
        this.classRepository = classRepository;
    }

    // 教师注册
    @CrossOrigin
    @PostMapping(value = "register")
    public int teacherRegister(@RequestBody Teacher teacher) {
        Teacher tecSaved = teacherRepository.findByTelenumber(teacher.getTelenumber());
        if (tecSaved != null) {
            // 用户已经存在
            return 2;
        }
        teacher.setSex(0);
        teacher.setAge(0);
        teacherRepository.save(teacher);
        return 1;
    }

    // 教师完善个人信息
    @CrossOrigin
    @PostMapping(value = "saveInfo")
    public int modifyTecInfo(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherRepository.findByTelenumber(teacher.getTelenumber());
        if (savedTeacher == null) {
            return 2;
        }
        savedTeacher.setSex(teacher.getSex());
        savedTeacher.setAge(teacher.getAge());
        teacherRepository.save(savedTeacher);
        return 1;
    }

    // 教师登录后获取该教师所有信息
    @CrossOrigin
    @PostMapping(value = "info")
    public Teacher getTecInfo(@RequestBody Login login) {
        // TODO 筛选发送给前端的信息
        return teacherRepository.findByTelenumber(login.getTelenumber());
    }

    // 教师添加课表内容
    @CrossOrigin
    @PostMapping(value = "setClass")
    public int setClass(@RequestBody Class aClass) {
        if (aClass.getClassTime().length() != 28) {
            System.out.println("the length of class time is wrong");
            return 2;
        }
        if (aClass.getTecTelenumber() == null) {
            System.out.println("tecTelenumber is null");
            return 2;
        }
        if (teacherRepository.findByTelenumber(aClass.getTecTelenumber()) == null) {
            System.out.println("tecTelenumber is wrong");
            return 2;
        }
        // 从老师表里获得subject, Name
        Teacher teacher = teacherRepository.findByTelenumber(aClass.getTecTelenumber());
        aClass.setSubject(teacher.getSubject());
        aClass.setTecName(teacher.getName());
        courseRepository.save(aClass);
        return 1;
    }

    // 教师查询已开课程列表
    @CrossOrigin
    @PostMapping(value = "getClassList")
    public List<Class> getClassList(@RequestBody Login login) {
        return courseRepository.findByTecTelenumber(login.getTelenumber());
    }

    // 教师在自己的课程发布公告
    @CrossOrigin
    @PostMapping(value = "sendNotice")
    public int sendNotice(@RequestBody Notice notice) {
        if (notice != null) {
            noticeRepository.save(notice);
            return 1;
        }
        return 2;
    }

    // 教师获取被学生购买的本人已开课程列表
    @CrossOrigin
    @PostMapping(value = "getPayClassList")
    public List<Class> getPayClassList(@RequestBody Login login) {
        List<Class> savedClasses = classRepository.findByTecTelenumber(login.getTelenumber());
        List<Class> classes = new ArrayList<>();
        for (Class aClass : savedClasses) {
            if (aClass.getStuTelenumber() != null) {
                classes.add(aClass);
            }
        }
        return classes;
    }
}
