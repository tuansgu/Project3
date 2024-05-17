package com.example.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.project3.entity.Member;
import com.example.project3.repository.MemberRepository;
import com.example.project3.service.impl.MemberServiceImpl;

@Controller
public class RegisterController {
  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private MemberServiceImpl memberService;
  private static final String PASSWORD_REGEX = "^.{1,10}$";
  private static final String PHONE_REGEX = "^0\\d{9}$";

  // trang đăng ký
  @GetMapping("/signup")
  public String showSignUpForm(Model model) {
    model.addAttribute("member", new Member());
    return "signup";
  }

  @GetMapping("/registerSuccess")
  public String showSignUpSuccessForm(Model model) {
    model.addAttribute("member", new Member());
    return "registerSuccess";
  }

  // trang đăng ký thành công
  @PostMapping("/process_register")
  public String saveMember(Member member, Model model) {
    if (memberRepository.existsById(member.getMaTV())) {
      model.addAttribute("errorID", "Mã thành viên đã được dăng ký");
      return "signup";
    }
    if (member.getHoTen().equals("")) {
      model.addAttribute("errorName", "Vui lòng nhập tên");
      return "signup";
    }
    if (member.getSDT().equals("")) {
      model.addAttribute("errorSDT", "Vui lòng nhập số điện thoại");
      return "signup";
    }
    if (memberRepository.existsByEmail(member.getEmail())) {
      model.addAttribute("errorEmail", "Email đã được đăng ký");
      return "signup";
    }
    if (!isValidePhone(member.getSDT())) {
      model.addAttribute("inValidSDT", "Nhập số điện thoại đúng định dạng");
      return "signup";
    }
    if (memberRepository.existsBySDT(member.getSDT())) {
      model.addAttribute("errorSDT2", "Số điện thoại đã được đăng ký");
      return "signup";
    }
    if (member.getPassword().equals("")) {
      model.addAttribute("errorPass", "Vui lòng nhập mật khẩu");
      return "signup";
    }
    if (!isValidPassword(member.getPassword())) {
      model.addAttribute("inValidPass", "Password có tối đa 10 kí tự");
      return "signup";
    }
    Member member2 = memberService.addMember(member);
    if (member2 == null) {
      model.addAttribute("error", "Đăng ký không thành công");
      return "signup";
    }
    model.addAttribute("message", "Đăng ký thành công");
    return "signup";
  }

  private boolean isValidPassword(String password) {
    return password != null && password.matches(PASSWORD_REGEX);
  }

  private boolean isValidePhone(String phone) {
    return phone.matches(PHONE_REGEX);
  }

}
