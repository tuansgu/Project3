package com.example.project3.service;
import java.util.List;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import com.example.project3.entity.Thongtinsd;

@Service
public interface ThongTinSuDungService {

    public Thongtinsd addThongtinsd(Thongtinsd thongtinsd);
    // kiểm tra mượn thiết bị
    Boolean kiemTraDatCho(Thongtinsd thongtinsd);
    List<Thongtinsd> findValidDeviceUsage1Hour(Timestamp deadline);
    void deleteAll(Iterable<Thongtinsd> thongtinsd);
}
