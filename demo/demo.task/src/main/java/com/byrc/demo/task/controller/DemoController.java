package com.byrc.demo.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {

    @RequestMapping(value = "/test1", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody //返回结果不会被解析为跳转路径，而是直接写入HTTP 响应正文中（ResponseBody）中
    public Map test1(){
        Map respMap = new HashMap();
        respMap.put("code","007");
        respMap.put("message","测试demo1");

        return  respMap;
    }
}
