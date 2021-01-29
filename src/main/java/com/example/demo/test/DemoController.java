package com.example.demo.test;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Api(description = "测试")
@RestController
public class DemoController {

    @Value("${test}")
    private boolean test;

    @Autowired
    private final static Logger log = LoggerFactory.getLogger(DemoMapper.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DemoMapper demoMapper;

    @Value("${flag}")
    private String flag;

    @Autowired
    ResourceLoader resourceLoader;




    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("/back")
    public String back(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("num"));
        session.setAttribute("num", "123");
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "back";
    }

//    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping("hello")
    public String hello() throws InterruptedException, IOException {
        ;
        byte[] b = new byte[1024 * 1024];
        int len = Thread.currentThread().getContextClassLoader().getResourceAsStream("application-dev.yml").read(b);
        return new String(b, 0, len);
    }

    @GetMapping("update")
    public void update(String name, String content){
        this.demoMapper.update(name, content);
    }


    @GetMapping("flag")
    public String flag(String name) throws IOException {
        FileInputStream fis = new FileInputStream(new File("/Users/chenxintong/Downloads/100093412detail_deploy.json"));
        byte[] bytes = new byte[2 * 1024 * 1024];
        int len = fis.read(bytes);
        String str = new String (bytes, 0, len);
        JSONObject res = JSONObject.parseObject(str);
        Object data = res.get("data");
        JSONArray dataArray = JSONObject.parseArray(data.toString());
        for (Object o : dataArray) {
            JSONObject jsonObject = JSONObject.parseObject(o.toString());
            if ("常见问题".equals(jsonObject.get("COMPONENT_NAME"))) {
                System.out.println(jsonObject.get("CONTENT").toString());
                return jsonObject.get("CONTENT").toString();
            }
        }
        return "ok";
    }

    @RequestMapping("/file")
    public String file (@RequestParam(name = "file")MultipartFile[]  file, String str) {

        return file.toString() + ": " + str;
    }




}
