package com.example.project3.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.project3.entity.Thongtinsd;
import com.example.project3.repository.ThongTinSudungRepository;
import com.example.project3.service.MemberService;
import com.example.project3.service.ThietBiService;
import com.example.project3.service.ThongTinSuDungService;

@Service
public class ThongTinSuDungServiceImpl implements ThongTinSuDungService {
    private final ThongTinSudungRepository thongTinSudungRepository;

    @Autowired
    public ThongTinSuDungServiceImpl(ThongTinSudungRepository ThongTinSudungrepository) {
        this.thongTinSudungRepository = ThongTinSudungrepository;

    }

    @Override
    public Thongtinsd addThongtinsd(Thongtinsd thongtinsd) {
        return thongTinSudungRepository.save(thongtinsd);
    }
    @Scheduled(fixedRate = 3600000)
    public void huyDatChoKhongSuDung() {
        // Lấy thời gian hiện tại
        LocalDateTime baygio = LocalDateTime.now();
        LocalDateTime motGioTruoc = baygio.minusHours(1); // 1 giờ trước
    
        // Truy vấn các đặt chỗ đã đặt trước hơn 1 giờ nhưng chưa được mượn
        List<Thongtinsd> cacDatChoQuaGio = thongTinSudungRepository.timCacDatChoQuaGio(motGioTruoc);
    
        // Hủy các đặt chỗ quá hạn
        for (Thongtinsd datCho : cacDatChoQuaGio) {
            thongTinSudungRepository.delete(datCho);
        }
    }
    
    
}
