package com.example.project3.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.project3.entity.Thongtinsd;

@Repository
public interface ThongTinSudungRepository extends JpaRepository<Thongtinsd, Integer>{
     @Query("SELECT t FROM Thongtinsd t WHERE t.tgDatCho <= :motGioTruoc")
    List<Thongtinsd> timCacDatChoQuaGio(@Param("motGioTruoc") LocalDateTime motGioTruoc);
}
