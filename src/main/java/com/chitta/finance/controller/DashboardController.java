package com.chitta.finance.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitta.finance.entity.FinancialRecord;
import com.chitta.finance.service.FinancialRecordService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private FinancialRecordService financialRecordService;

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {

        List<FinancialRecord> records = financialRecordService.getAllRecords();

        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalExpense = BigDecimal.ZERO;

        for (FinancialRecord record : records) {
            if ("INCOME".equalsIgnoreCase(record.getType())) {
                totalIncome = totalIncome.add(record.getAmount());
            } else if ("EXPENSE".equalsIgnoreCase(record.getType())) {
                totalExpense = totalExpense.add(record.getAmount());
            }
        }

        BigDecimal netBalance = totalIncome.subtract(totalExpense);

        Map<String, Object> response = new HashMap<>();
        response.put("totalIncome", totalIncome);
        response.put("totalExpense", totalExpense);
        response.put("netBalance", netBalance);
        response.put("totalRecords", records.size());
        response.put("records", records);

        return response;
    }
}