package com.example.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.project3.entity.Thietbi;
import com.example.project3.entity.Thongtinsd;

@Repository
public interface ThongTinSudungRepository extends JpaRepository<Thongtinsd, Integer> {
    @Query("SELECT t FROM Thongtinsd t WHERE t.tgDatCho <= :motGioTruoc")
    List<Thongtinsd> timCacDatChoQuaGio(@Param("motGioTruoc") LocalDateTime motGioTruoc);

    @Query("SELECT t FROM Thongtinsd t WHERE t.thietBi=?1 AND DATE(t.tgDatCho)=?2")
    List<Thongtinsd> findValidDeviceUsage(Thietbi maTB, Date tgDatCho);

    
    @Query(value = "SELECT * FROM thongtinsd u WHERE DATE_ADD(u.tgDatCho, INTERVAL 1 HOUR) <= :deadline ", nativeQuery = true)
    List<Thongtinsd> findValidDeviceUsage1Hour(Timestamp  deadline);
}
