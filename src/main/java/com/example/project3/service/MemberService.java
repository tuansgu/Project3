package com.example.project3.service;

import com.example.project3.entity.Member;
import com.example.project3.service.impl.MemberNotFoundException;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

  public Optional<Member> login(int maTV, String password);

  public Member addMember(Member member);

  public void sendEmail(String email, String resetPasswordLink)
      throws UnsupportedEncodingException, MessagingException;

  public void updateResetPasswordToken(String token, String email) throws MemberNotFoundException;

  public Member get(String resetPasswordToken);

  public void updatePassword(Member member, String newPassword);

  public boolean checkMemberID(int MaTV);

  public String getSiteURL(HttpServletRequest request);

  public boolean changePassword(int maTV, String currentPassword, String newPassword);
}
