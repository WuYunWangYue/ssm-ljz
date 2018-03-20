package com.ljz.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ljz.model.User;
import com.ljz.service.IUserService;


@Controller
@RequestMapping("/user")
// /user/**
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    // /user/test?id=1
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String create() {
        User user = new User();
        user.setAge(11);
        user.setPassword("123");
        user.setUserName("ljz");
        userService.create(user);
        return "index";
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public String toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("userId:" + userId);
        User user = this.userService.getUserById(userId);
        log.debug(user.toString());
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping(value = "/showUser2", method = RequestMethod.GET)
    public String toIndex2(@RequestParam("id") String id, Model model) {
        int userId = Integer.parseInt(id);
        System.out.println("userId:" + userId);
        User user = this.userService.getUserById(userId);
        log.debug(user.toString());
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping(value = "/showUser3/{id}", method = RequestMethod.GET)
    public String toIndex3(@PathVariable("id") String id, Map<String, Object> model) {
        int userId = Integer.parseInt(id);
        System.out.println("userId:" + userId);
        User user = this.userService.getUserById(userId);
        log.debug(user.toString());
        model.put("user", user);
        return "showUser";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserInfo(@PathVariable String id, Map<String, Object> model) {
        int userId = Integer.parseInt(id);
        System.out.println("userId:" + userId);
        User user = this.userService.getUserById(userId);
        log.info(user.toString());
        return user;
    }

    @RequestMapping(value = "/jsonType/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserInJson2(@PathVariable String id, Map<String, Object> model) {
        int userId = Integer.parseInt(id);
        System.out.println("userId:" + userId);
        User user = this.userService.getUserById(userId);
        log.info(user.toString());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //文件上传
    @RequestMapping(value = "/upload")
    public String showUploadPage() {
        return "user_admin/file";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            log.info("Process file:{}", file.getOriginalFilename());
        }
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:\\", System.currentTimeMillis() + file.getOriginalFilename()));
        return "succes";
    }
}  