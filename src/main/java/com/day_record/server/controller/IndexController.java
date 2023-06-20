package com.day_record.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JereChen
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/index/info")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

}
