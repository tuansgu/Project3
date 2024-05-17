package com.example.project3.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.project3.entity.Member;
import com.example.project3.repository.MemberRepository;
import com.example.project3.service.impl.MemberServiceImpl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
  @Autowired
  private MemberRepository memberRepository;

  @GetMapping("/login")
  public String showLoginForm(Model model) {
    model.addAttribute("member", new Member());
    return "login";
  }

  @PostMapping("/login")
  public String loginMember(@RequestParam int MaTV, @RequestParam String Password, HttpServletResponse response,
      HttpSession session, RedirectAttributes redirectAttributes)
      throws UnsupportedEncodingException {
    Optional<Member> optionalMember = memberRepository.findOneByIdAndPassword(MaTV, Password);
    if (optionalMember.isPresent()) {
      Member member = optionalMember.get();
      String hoten = member.getHoTen();
      String maTV = member.getMaTV() + "";
      session.setAttribute("loggedInMaTV", MaTV);
      // Lưu thông tin tên thành viên vào cookie
      String encodedValue = URLEncoder.encode(hoten, "UTF-8");
      String encodedMaTV = URLEncoder.encode(maTV, "UTF-8");
      Cookie cookie = new Cookie("hoten", encodedValue);
      Cookie cookieMaTV = new Cookie("MaTV", encodedMaTV);
      cookie.setMaxAge(3600); // Thời gian sống của cookie (1 giờ)
      response.addCookie(cookie);
      response.addCookie(cookieMaTV);
      redirectAttributes.addFlashAttribute("member", member);

      return "redirect:/index";
    } else {
      return "redirect:/login?error";
    }
  }

  @GetMapping("/index")
  public String indexAfterLogin(@ModelAttribute("member") Member member, Model model) {
    model.addAttribute("member", member);
    return "index";
  }
}
