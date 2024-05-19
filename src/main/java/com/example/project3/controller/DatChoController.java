package com.example.project3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.Map;
import com.example.project3.entity.Thietbi;
import com.example.project3.entity.Thongtinsd;
import com.example.project3.service.ThongTinSuDungService;

@Controller
public class DatChoController {
    private ThongTinSuDungService thongTinSuDungService;

    @Autowired
    public DatChoController(ThongTinSuDungService thongTinSuDungService) {
        this.thongTinSuDungService = thongTinSuDungService;
    }

    @GetMapping("/datcho")
    public String Home() {
        return "datcho";
    }

    @ResponseBody
    @PostMapping(value = "/dat_cho", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String datCho(@RequestBody Thongtinsd[] requests) {
        List<Integer> conflictingDevices = new ArrayList<>();
        try {
            boolean success = false;
            for (Thongtinsd request : requests) {
                if (thongTinSuDungService.kiemTraDatCho(request)) {
                    success = true;
                } else {
                    conflictingDevices.add(request.getThietBi().getMaTB());
                }
            }
            if (conflictingDevices.isEmpty()) {
                for (Thongtinsd request : requests) {
                    thongTinSuDungService.addThongtinsd(request);
                }
                return "thực hiện đặt chỗ thành công";
            } else {
                return "đặt chỗ thất bại cho các thiết bị: " + conflictingDevices+"!. thiết bị đã được đặt chỗ trong ngày";
            }
        } catch (Exception e) {
            return "Đã xảy ra lỗi khi đặt chỗ: " + e.getMessage();
        }

    }

}
