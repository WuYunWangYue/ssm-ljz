package com.ljz.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ljz.common.BaseResponse;
import com.ljz.controller.vo.UserRequestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ljz.model.User;
import com.ljz.service.IUserService;

@Api(value = "UserController", description = "用户接口详情")
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;


    @ApiOperation(value="创建新用户")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestBody UserRequestVO reqVO){
        User user = new User();
        BeanUtils.copyProperties(reqVO, user);
        userService.create(user);
        return "success";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        User user = new User();
        user.setPassword("123");
        user.setUserName("ljz");
        user.setAge(11);
        userService.create(user);
        return "success";
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
    public User getUserInfo(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        System.out.println("userId:" + userId);
        User user = this.userService.getUserById(userId);
        log.info(user.toString());
        return user;
    }

    @RequestMapping(value = "/jsonType/{id}", method = RequestMethod.GET)
//    public ResponseEntity<User> getUserInJson2(@PathVariable String id, Map<String, Object> model) {
    public ResponseEntity<User> getUserInJson2(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        System.out.println("userId:" + userId);
        User user = this.userService.getUserById(userId);
        log.info(user.toString());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //文件上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String showUploadPage() {
        return "user_admin/file";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            log.info("Process file:{}", file.getOriginalFilename());
        }
        FileUtils.copyInputStreamToFile(file.getInputStream(),
                new File("E:\\", System.currentTimeMillis() + file.getOriginalFilename()));
        return "success";
    }
}  