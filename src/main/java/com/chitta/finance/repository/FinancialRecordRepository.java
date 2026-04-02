package com.chitta.finance.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chitta.finance.entity.FinancialRecord;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Integer> {
    List<FinancialRecord> findByType(String type);
    List<FinancialRecord> findByCategory(String category);
    List<FinancialRecord> findByRecordDateBetween(LocalDate startDate, LocalDate endDate);
}