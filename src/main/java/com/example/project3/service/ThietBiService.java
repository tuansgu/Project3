package com.example.project3.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project3.entity.Thietbi;

@Service
public interface ThietBiService {
    @Autowired
    public List<Thietbi> getAllThietBi();
    public List<Thietbi> searchByNameThietBi(String name);
}
