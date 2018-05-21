package com.usst.springbootitutor;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.Url;

import java.io.*;
import java.util.Calendar;

@RestController
@ResponseBody
public class UploadController {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public UploadController(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    private String upLoad(String path, String telenumber) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "VE9QAGgLuKVVqeJgDT1-khy15H4dNrbIdMi_wYfx";
        String secretKey = "kXcmosld877f2RDfpshJS_K5VW6PO1HCdDikbkhW";
        String bucket = "itutor";
        String baseUrl = "http://p8pjrhsrh.bkt.clouddn.com/";
        Calendar now = Calendar.getInstance();
        String key = telenumber + "-" + now.get(Calendar.YEAR) + "-"
                + now.get(Calendar.MONTH) + "-"
                + now.get(Calendar.DAY_OF_MONTH) + "-"
                + now.get(Calendar.HOUR_OF_DAY) + "-"
                + now.get(Calendar.MINUTE);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(path, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(baseUrl + putRet.key);
            baseUrl = baseUrl + putRet.key;
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return baseUrl;
    }

    @CrossOrigin
    @RequestMapping(value = "common/upload", produces = "application/json; charset=utf-8", method = {RequestMethod.POST})
    public Url handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("telenumber") String telenumber,
                                @RequestParam("identify") int identify) {
        String url;
        Url url1 = new Url();
        if (!file.isEmpty()) {
            try {
                File path = new File(ResourceUtils.getURL("path:").getPath());
                if (!path.exists()) path = new File("");
                System.out.println("path:" + path.getAbsolutePath());
                File upload = new File(path.getAbsolutePath(), "src/img/");
                if (!upload.exists()) upload.mkdirs();
                System.out.println("upload url:" + upload.getAbsolutePath());

                File uploadFile = new File(upload.getAbsolutePath() + file.getOriginalFilename());
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(uploadFile));
                System.out.println(file.getOriginalFilename());
                String args[] = file.getOriginalFilename().split("\\.");
                System.out.println(args[1]);
                out.write(file.getBytes());
                out.flush();
                out.close();
                url = upLoad(uploadFile.getAbsolutePath(), telenumber);
                url1.setUrl(url);
            } catch (IOException e) {
                e.printStackTrace();
                url1.setUrl("上传失败" + e);
                return url1;
            }
            // 将url存入相应的表
            if (identify == 1) {
                Student student = studentRepository.findByTelenumber(telenumber);
                if (student != null) {
                    student.setStuUrl(url);
                    studentRepository.save(student);
                }
            }
            if (identify == 2) {
                Teacher teacher = teacherRepository.findByTelenumber(telenumber);
                if (teacher != null) {
                    teacher.setTecUrl(url);
                    teacherRepository.save(teacher);
                }
            }
            return url1;
        } else {
            url1.setUrl("上传失败");
            return url1;
        }
    }
}