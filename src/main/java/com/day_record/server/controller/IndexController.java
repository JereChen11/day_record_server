package com.day_record.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JereChen
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String indexPage() {
        return "index";
    }

}
