package com.example.project3.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import com.example.project3.entity.Thietbi;
import com.example.project3.service.ThietBiService;
@Controller
public class ThietBiController {
    private final ThietBiService thietBiService;
    @Autowired
    public ThietBiController(ThietBiService thietBiService) {
        this.thietBiService = thietBiService;
    }
    @GetMapping("/thietbis")
    @ResponseBody
    public List<Thietbi> getAllThietBi() {
        return thietBiService.getAllThietBi();
    }
}
