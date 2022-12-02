package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getInfo() {
        return "main_page";
    }

    @GetMapping("/hr_info")
    public String getHRInfo() {
        return "hr_info";
    }

    @GetMapping("/manager_info")
    public String getManagerInfo() {
        return "manager_info";
    }
}
