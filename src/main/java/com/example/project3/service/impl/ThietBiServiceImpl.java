package com.example.project3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.project3.entity.Thietbi;
import com.example.project3.repository.ThietBiRepository;
import com.example.project3.service.ThietBiService;
@Service
public class ThietBiServiceImpl implements ThietBiService{
    @Autowired
    private ThietBiRepository thietBiRepository;

    public ThietBiServiceImpl(ThietBiRepository thietbiRepository) {
        this.thietBiRepository = thietbiRepository;
    }
    @Override
    public List<Thietbi> getAllThietBi() {
        return thietBiRepository.getAllThietBi();
    }
    @Override
    public List<Thietbi> searchByNameThietBi(String name) {
        return thietBiRepository.findByTen(name);
    }

}
