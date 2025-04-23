package com.hrms2.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({
        "/HrmsDashboard",
        "/HrmsDashboard/",
        "/HrmsDashboard/{path:[^\\.]*}",
        "/HrmsDashboard/**/{path:[^\\.]*}"
    })
    public String redirect() {
        return "forward:/index.html";
    }
}
