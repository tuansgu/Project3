package com.example.project3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

        try {
            for (Thongtinsd request : requests) {
                thongTinSuDungService.addThongtinsd(request);
            }
            return "Thực hiện đặt chỗ thành công";
        } catch (Exception e) {
            return "Đã xảy ra lỗi khi đặt chỗ: " + e.getMessage();
        }

    }
}
