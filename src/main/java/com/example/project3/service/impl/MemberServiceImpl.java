package com.example.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project3.repository.MemberRepository;
import com.example.project3.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService  {
    @Autowired
    private MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
