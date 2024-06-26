package com.example.project3.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.project3.entity.Member;
import com.example.project3.repository.MemberRepository;
import com.example.project3.service.MemberService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private JavaMailSender mailSender;

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public Optional<Member> login(int maTV, String password) {
    Optional<Member> member = memberRepository.findOneByIdAndPassword(maTV, password);
    if (member.isPresent()) {
      return member;
    }
    return null;
  }

  @Override
  public Member addMember(Member member) {
    if (memberRepository.existsById(member.getMaTV())) {
      return null;
    }
    return memberRepository.save(member);
  }

  @Override
  public void updateResetPasswordToken(String token, String email) throws MemberNotFoundException {
    Member member = memberRepository.findByEmail(email);
    if (member != null) {
      member.setResetPasswordToken(token);
      memberRepository.save(member);
    } else {
      throw new MemberNotFoundException("Couldn't not find any member with email " + email);
    }
  }

  @Override
  public Member get(String resetPasswordToken) {
    return memberRepository.findByResetPasswordToken(resetPasswordToken);
  }

  @Override
  public void updatePassword(Member member, String newPassword) {
    member.setPassword(newPassword);
    member.setResetPasswordToken(null);
    memberRepository.save(member);
  }

  @Override
  public String getSiteURL(HttpServletRequest request) {
    String siteURL = request.getRequestURL().toString();
    return siteURL.replace(request.getServletPath(), "");
  }

  @Override
  public void sendEmail(String email, String resetPasswordLink)
      throws UnsupportedEncodingException, MessagingException {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    helper.setFrom("resetpassword", "Reset Password");
    helper.setTo(email);
    String subject = "Link to reset password";
    String content = "<p>Click the link to change your password: </p>"
        + "<p><b><a href=\"" + resetPasswordLink + "\"> Change my password</a><b></p>";
    helper.setSubject(subject);
    helper.setText(content, true);
    mailSender.send(message);
  }

  @Override
  public boolean checkMemberID(int MaTV) {
    return memberRepository.existsByMaTV(MaTV);
  }
  @Override
  public boolean changePassword(int maTV, String currentPassword, String newPassword) {
    Member member = memberRepository.findById(maTV).orElse(null);
    if (member != null && member.getPassword().equals(currentPassword)) {
      member.setPassword(newPassword);
      memberRepository.save(member);
      return true;
    }
    return false;
  }
}
