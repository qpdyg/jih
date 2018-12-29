package com.xiaolc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @RequestMapping("content/fandName")
    public String land() {

        return "land";
    }

    @RequestMapping("contact.html")
    public String contact() {
        return "contact";
    }

    @RequestMapping("full-width.html")
    public String fullwidth() {
        return "full-width";
    }

    @RequestMapping("news.html")
    public String news() {
        return "news";
    }

    @RequestMapping("search-result.html")
    public String searchresult() {
        return "search-result";
    }


}
