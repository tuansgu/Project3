package com.example.project3.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DatChoController {
    @GetMapping("/datcho")
    public String Home() {
        return "datcho";
    }
}
