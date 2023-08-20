package com.example.ricesale.repository;


import com.example.ricesale.entity.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRecordRepository extends JpaRepository<SalesRecord, Long> {
}
