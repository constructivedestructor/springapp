package com.example.springapp.repositories;

import com.example.springapp.models.SalesJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesJPARepository extends JpaRepository<SalesJPA, Integer> {
    long count();
    List<SalesJPA> findById(int id);
    List<SalesJPA> findAll();

}
