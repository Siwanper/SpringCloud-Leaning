package com.siwanper.resttemplate.rest;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/resource")
    public String upload(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws IOException {
        String param1 = request.getParameter("param1");
        if (null == files) {
            return "上传的文件不存在";
        }
        for (MultipartFile file : files) {
            if (!file.isEmpty() && file.getSize() > 0) {
                String filename = file.getOriginalFilename();
                file.transferTo(new File("/Users/chenjie/Desktop/uploadfile/" + filename));
                log.info("上传成功:{}, param:{}",filename,param1);
            }
        }
        return "上传成功";
    }

}
