package com.ljz.controller;

import com.ljz.service.impl.CacheDemoUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("cacheTest")
public class CacheDemoUserController {
    @Autowired
    private CacheDemoUserServiceImpl cacheDemoUserServiceImpl;

    @RequestMapping(value = "/get/{userNo}", method = RequestMethod.GET)
    public String get(@PathVariable String userNo, Model model) {
        String username = cacheDemoUserServiceImpl.get(userNo);
        model.addAttribute("username", username);
        return "getUser";
    }

    @RequestMapping(value = "/update/{userNo}", method = RequestMethod.GET)
    public String update(@PathVariable String userNo, Model model) {
        cacheDemoUserServiceImpl.update(userNo);
        model.addAttribute("userNo", userNo);
        return "updateUser";
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.GET)
    public String removeAll() {
        cacheDemoUserServiceImpl.removeAll();
        return "removeAllUser";
    }
}