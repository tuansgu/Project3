package com.example.project3.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.project3.entity.Thietbi;

@Repository
public interface ThietBiRepository extends JpaRepository<Thietbi, Integer> {
        // get all thiet bi
        // @Query("SELECT t FROM Thietbi t WHERE t.maTB NOT IN "
        // + "(SELECT td.thietBi.maTB FROM Thongtinsd td "
        // + "WHERE td.thietBi.maTB != 0 AND td.thietBi.maTB IS NOT NULL "
        // + "AND (td.tgTra IS NULL OR td.tgDatCho IS NOT NULL))")
        // List<Thietbi> getAllThietBi();
        @Query("SELECT d FROM Thietbi d LEFT JOIN Thongtinsd u ON d.maTB = u.thietBi.maTB AND u.tgTra IS NOT NULL AND u.tgDatCho IS NOT NULL WHERE u.thietBi IS NULL")
        List<Thietbi> getAllThietBi();

        // tìm kiếm thiết bị theo tên
        @Query("SELECT t FROM Thietbi t WHERE t.maTB NOT IN "
                        + "(SELECT td.thietBi.maTB FROM Thongtinsd td "
                        + "WHERE td.thietBi.maTB != 0 AND td.thietBi.maTB IS NOT NULL "
                        + "AND (td.tgTra IS NULL OR td.tgDatCho IS NOT NULL)) AND LOWER(t.tenTB) LIKE %?1%")
        List<Thietbi> findByTen(String tenTB);
}
