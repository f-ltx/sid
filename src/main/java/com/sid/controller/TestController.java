package com.sid.controller;

import com.sid.service.TestService;
import com.sid.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        testService.testJtaAtomikos();
        return "";
    }
}
