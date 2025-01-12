package com.example.practice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

@Controller
public class BasicController {
    @GetMapping("/")
    @ResponseBody
    String hello() {
        return "Hello World";
    }
    @GetMapping("/about")
    @ResponseBody
    String about() {
        return "피싱사이트에요";
    }
    @GetMapping("/html")
    String html() {
        return "index.html";
    }
    @GetMapping("/html1")
    String html1() {
        return "main.html";
    }
    @GetMapping("/date")
    @ResponseBody
    Date data() {
        Date date = new Date();
        return date;
    }
}
