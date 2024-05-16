package com.example.project3.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project3.entity.Thongtinsd;

@Repository
public interface ThongTinSudungRepository extends JpaRepository<Thongtinsd, Integer>{
    
}
