package com.example.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.project3.repository.MemberRepository;
import com.example.project3.service.MemberService;

public class MemberServiceImpl implements MemberService  {
    @Autowired
    private MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
