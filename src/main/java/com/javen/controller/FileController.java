package com.javen.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/")
public class FileController {

    @RequestMapping(value = "fileUpload", method = RequestMethod.GET)
    public String toFileUpload() {
        return "/file/fileUpload";
    }

    /**
     * 单个文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String fileUpload (@RequestParam("file") MultipartFile file)throws IOException {

        if (!file.isEmpty()) {

            {
                //存入F:\temp目录下
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/Users/HelloWord/Downloads/temp",
                        System.currentTimeMillis() + file.getOriginalFilename()));

                System.out.println(file.getOriginalFilename());
                return toFileUpload();
            }

        }
        else
        {

            return "login";
        }
        //上传成功，跳转至success页面

    }
}



