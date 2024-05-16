package com.example.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.project3.repository.ThietBiRepository;
import com.example.project3.service.ThietBiService;

public class ThietBiServiceImpl implements ThietBiService{
     @Autowired
    private ThietBiRepository thietBiRepository;

    public ThietBiServiceImpl(ThietBiRepository thietbiRepository) {
        this.thietBiRepository = thietbiRepository;
    }

}
