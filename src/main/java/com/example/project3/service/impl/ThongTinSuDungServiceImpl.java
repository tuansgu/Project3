package com.example.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
