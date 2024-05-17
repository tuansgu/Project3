package com.example.project3.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;
import com.example.project3.entity.Thongtinsd;

@Repository
public interface ThongTinSudungRepository extends JpaRepository<Thongtinsd, Integer>{
    @Query("SELECT t FROM ThongTinSuDung t WHERE t.tgDatCho < :time AND t.maTB IS NULL")
    List<Thongtinsd> findByTGDatChoBeforeAndMaTBIsNull(LocalDateTime time);
}
