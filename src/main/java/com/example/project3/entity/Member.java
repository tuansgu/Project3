package com.example.project3.entity;
import jakarta.persistence.*;
import java.util.List;
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

    // @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "thanhVien",fetch = FetchType.LAZY)
    // private List<Thongtinsd> usages;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thanhVien")
    private List<Thongtinsd> usages;
}
