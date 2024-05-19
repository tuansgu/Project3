package com.example.project3.component;

import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.project3.entity.Thongtinsd;
import com.example.project3.service.ThongTinSuDungService;

@Component
public class ScheduledTasks {
    private ThongTinSuDungService thongTinSuDungService;

    public ScheduledTasks(ThongTinSuDungService thongTinSuDungService) {
        this.thongTinSuDungService = thongTinSuDungService;
    }

    @Scheduled(fixedRate = 3600000)
    public void xoa_datcho_tu_dong() {
        List<Thongtinsd> tasks=thong_tin_su_dung();
        if(!tasks.isEmpty()) {
            Iterable<Thongtinsd> tt=tasks;
            thongTinSuDungService.deleteAll(tt);
        }
    }
    public List<Thongtinsd> thong_tin_su_dung() {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        return thongTinSuDungService.findValidDeviceUsage1Hour(currentTime);
    }
}
