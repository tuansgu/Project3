package com.example.project3.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.project3.entity.Member;
import com.example.project3.repository.MemberRepository;
import com.example.project3.service.impl.MemberNotFoundException;
import com.example.project3.service.impl.MemberServiceImpl;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {
  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private MemberServiceImpl memberService;
  private static final String PASSWORD_REGEX = "^.{1,10}$";
  private static final String PHONE_REGEX = "^0\\d{9}$";

  // trang quên mật khẩu
  @GetMapping(value = { "/forgotPassword" })
  public String showForgotPasswordForm(Model model) {
    model.addAttribute("pageTitle", "Forgot Password");
    return "forgotPassword";
  }

  @PostMapping("/forgotPassword")
  public String processForgotPasswordForm(HttpServletRequest request, Model model) {
    String email = request.getParameter("Email");
    String token = RandomString.make(45);

    try {
      memberService.updateResetPasswordToken(token, email);

      String resetPasswordLink = memberService.getSiteURL(request) +
          "/resetPassword?token=" + token;
      memberService.sendEmail(email, resetPasswordLink);
      model.addAttribute("message", "we have sent a reset password link to your email.");
    } catch (MemberNotFoundException e) {
      e.printStackTrace();
      model.addAttribute("error", e.getMessage());
    } catch (UnsupportedEncodingException | MessagingException e) {
      e.printStackTrace();
      model.addAttribute("error", "Error while sending email.");
    }
    model.addAttribute("pageTitle", "Forgot Password");
    return "forgotPassword";
  }

  @GetMapping("/resetPassword")
  public String showResetPasswordForm(@Param("token") String token, Model model) {
    Member member = memberService.get(token);
    if (member == null) {
      model.addAttribute("error", "Invalid token");
      return "error";
    }
    model.addAttribute("token", token);
    model.addAttribute("pageTitle", "Reset your Password");
    return "resetPassword";
  }

  @PostMapping("/resetPassword")
  public String processResetPasswordForm(HttpServletRequest request, Model model) {
    String token = request.getParameter("token");
    String password = request.getParameter("newPassword");
    Member member = memberService.get(token);
    if (member == null) {
      model.addAttribute("error", "Invalid token");
      return "error";
    } else {
      memberService.updatePassword(member, password);
      model.addAttribute("message", "Change password successfully");
    }
    return "message";
  }

}
