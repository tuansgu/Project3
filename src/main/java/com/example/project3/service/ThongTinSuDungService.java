package com.example.project3.service;

import org.springframework.stereotype.Service;

import com.example.project3.entity.Thongtinsd;

@Service
public interface ThongTinSuDungService {

    public Thongtinsd addThongtinsd(Thongtinsd thongtinsd);
    // kiểm tra mượn thiết bị
    Boolean kiemTraDatCho(Thongtinsd thongtinsd);
}
