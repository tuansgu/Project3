package com.example.project3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.sql.Timestamp;
import jakarta.persistence.*;
@Entity
@Table(name = "thongtinsd")
public class Thongtinsd {
    @Id
    @Column(name = "MaTT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTT;

    @ManyToOne
    @JoinColumn(name = "MaTV")
    public Member thanhVien;

    @ManyToOne
    @JoinColumn(name = "MaTB")
    public Thietbi thietBi;

    @Column(name = "TGVao")
    private Timestamp tgVao;
    @Column(name = "TGMuon")
    private Timestamp tgMuon;
    @Column(name = "TGTra")
    private Timestamp tgTra;
    @Column(name = "tgDatCho")
    private Timestamp tgDatCho;
    
    public Thongtinsd() {
    }
    public Thongtinsd(int maTT, Member thanhVien, Thietbi thietBi, Timestamp tgVao, Timestamp tgMuon, Timestamp tgTra,
            Timestamp tgDatCho) {
        this.maTT = maTT;
        this.thanhVien = thanhVien;
        this.thietBi = thietBi;
        this.tgVao = tgVao;
        this.tgMuon = tgMuon;
        this.tgTra = tgTra;
        this.tgDatCho = tgDatCho;
    }
    public int getMaTT() {
        return maTT;
    }
    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }
    public Member getThanhVien() {
        return thanhVien;
    }
    public void setThanhVien(Member thanhVien) {
        this.thanhVien = thanhVien;
    }
    public Thietbi getThietBi() {
        return thietBi;
    }
    public void setThietBi(Thietbi thietBi) {
        this.thietBi = thietBi;
    }
    public Timestamp getTgVao() {
        return tgVao;
    }
    public void setTgVao(Timestamp tgVao) {
        this.tgVao = tgVao;
    }
    public Timestamp getTgMuon() {
        return tgMuon;
    }
    public void setTgMuon(Timestamp tgMuon) {
        this.tgMuon = tgMuon;
    }
    public Timestamp getTgTra() {
        return tgTra;
    }
    public void setTgTra(Timestamp tgTra) {
        this.tgTra = tgTra;
    }
    public Timestamp getTgDatCho() {
        return tgDatCho;
    }
    public void setTgDatCho(Timestamp tgDatCho) {
        this.tgDatCho = tgDatCho;
    }
    
}
