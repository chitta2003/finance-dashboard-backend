package com.chitta.finance.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitta.finance.entity.FinancialRecord;
import com.chitta.finance.repository.FinancialRecordRepository;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository financialRecordRepository;

    public FinancialRecord saveRecord(FinancialRecord record) {
        return financialRecordRepository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return financialRecordRepository.findAll();
    }

    public FinancialRecord getRecordById(Integer id) {
        return financialRecordRepository.findById(id).orElse(null);
    }

    public List<FinancialRecord> getRecordsByType(String type) {
        return financialRecordRepository.findByType(type);
    }

    public List<FinancialRecord> getRecordsByCategory(String category) {
        return financialRecordRepository.findByCategory(category);
    }

    public List<FinancialRecord> getRecordsByDateRange(LocalDate startDate, LocalDate endDate) {
        return financialRecordRepository.findByRecordDateBetween(startDate, endDate);
    }

    public void deleteRecord(Integer id) {
        financialRecordRepository.deleteById(id);
    }
}