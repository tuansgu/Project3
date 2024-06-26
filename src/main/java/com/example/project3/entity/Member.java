package com.example.project3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "thanhvien")
public class Member {
  @Id
  @Column(name = "MaTV")
  private int MaTV;

  @Column(name = "Hoten")
  private String HoTen;

  @Column(name = "Khoa")
  private String Khoa;

  @Column(name = "Nganh")
  private String Nganh;

  @Column(name = "SDT")
  private String SDT;

  @Column(name = "Email")
  private String Email;

  @Column(name = "Password")
  private String Password;

  @Column(name = "reset_password_token")
  private String resetPasswordToken;

  public Member(int maTV, String hoTen, String khoa, String nganh, String sDT, String Email, String password) {
    this.MaTV = maTV;
    this.HoTen = hoTen;
    this.Khoa = khoa;
    this.Nganh = nganh;
    this.SDT = sDT;
    this.Email = Email;
    this.Password = password;
  }

  public Member() {
  }

  public int getMaTV() {
    return this.MaTV;
  }

  public void setMaTV(int maTV) {
    this.MaTV = maTV;
  }

  public String getHoTen() {
    return this.HoTen;
  }

  public void setHoTen(String hoTen) {
    this.HoTen = hoTen;
  }

  public String getKhoa() {
    return this.Khoa;
  }

  public void setKhoa(String khoa) {
    this.Khoa = khoa;
  }

  public String getNganh() {
    return this.Nganh;
  }

  public void setNganh(String nganh) {
    this.Nganh = nganh;
  }

  public String getSDT() {
    return this.SDT;
  }

  public void setSDT(String sDT) {
    this.SDT = sDT;
  }

  public String getEmail() {
    return this.Email;
  }

  public void setEmail(String Email) {
    this.Email = Email;
  }

  public String getPassword() {
    return this.Password;
  }

  public void setPassword(String password) {
    this.Password = password;
  }

  public String getResetPasswordToken() {
    return resetPasswordToken;
  }

  public void setResetPasswordToken(String resetPasswordToken) {
    this.resetPasswordToken = resetPasswordToken;
  }
}