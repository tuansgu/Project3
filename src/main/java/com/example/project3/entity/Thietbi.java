package com.example.project3.entity;
import java.util.List;
import jakarta.persistence.*;
@Entity
@Table(name = "thietbi")
public class Thietbi {
    @Id
    @Column(name = "MaTB")
    private int maTB;
    @Column(name = "TenTB")
    private String tenTB;
    @Column(name = "MoTaTB")
    private String mota;
    public Thietbi() {
        
    }
    public Thietbi(int maTB, String tenTB, String mota) {
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.mota = mota;
    }
    
    @OneToMany(mappedBy = "thietBi", cascade = CascadeType.ALL)
    private List<Thongtinsd> thongtinsd;

    public int getMaTB() {
        return maTB;
    }
    public void setMaTB(int maTB) {
        this.maTB = maTB;
    }
    public String getTenTB() {
        return tenTB;
    }
    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }
    public String getMota() {
        return mota;
    }
    public void setMota(String mota) {
        this.mota = mota;
    }
    public List<Thongtinsd> getThongtinsd() {
        return thongtinsd;
    }
    public void setThongtinsd(List<Thongtinsd> thongtinsd) {
        this.thongtinsd = thongtinsd;
    }
}
