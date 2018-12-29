package com.xiaolc.controller;

import com.xiaolc.util.FtpUtil;
import com.xiaolc.util.IDUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/19.
 */
@Controller
public class PicController {
    @Value("${ftpclient.host}")
    private String host;
    @Value("${ftpclient.port}")
    private String port;
    @Value("${ftpclient.username}")
    private String username;
    @Value("${ftpclient.password}")
    private String password;
    @Value("${ftpclient.basepath}")
    private String basePath;
    @Value("${ftpclient.filepath}")
    private String filePath;

    @PatchMapping("/pic/upload")
    @ResponseBody
    public Map<String, Object> upload(MultipartFile uploadFile) throws Exception {
        String filename = IDUtils.genImageName() + uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf("."));
        boolean b = FtpUtil.uploadFile(host, Integer.valueOf(port), username, password, basePath, filePath, filename, uploadFile.getInputStream());
        HashMap<String, Object> map = new HashMap<>();
        if (b) {
            map.put("error", 0);
            map.put("url", "http://" + host + "/" + filename);
        } else {
            map.put("error", 1);
            map.put("message", "文件上传失败");
        }
        return map;
    }

}
