package com.chitta.finance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.chitta.finance.entity.FinancialRecord;
import com.chitta.finance.service.FinancialRecordService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService financialRecordService;

    @PostMapping
    public FinancialRecord addRecord(@RequestBody FinancialRecord record) {
        return financialRecordService.saveRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getAllRecords() {
        return financialRecordService.getAllRecords();
    }

    @GetMapping("/{id}")
    public FinancialRecord getRecordById(@PathVariable Integer id) {
        return financialRecordService.getRecordById(id);
    }

    @GetMapping("/type/{type}")
    public List<FinancialRecord> getRecordsByType(@PathVariable String type) {
        return financialRecordService.getRecordsByType(type);
    }

    @GetMapping("/category/{category}")
    public List<FinancialRecord> getRecordsByCategory(@PathVariable String category) {
        return financialRecordService.getRecordsByCategory(category);
    }

    @GetMapping("/date")
    public List<FinancialRecord> getRecordsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return financialRecordService.getRecordsByDateRange(startDate, endDate);
    }

    @PutMapping("/{id}")
    public FinancialRecord updateRecord(@PathVariable Integer id, @RequestBody FinancialRecord updatedRecord) {

        FinancialRecord existingRecord = financialRecordService.getRecordById(id);

        if (existingRecord == null) {
            throw new RuntimeException("Record not found with id: " + id);
        }

        existingRecord.setAmount(updatedRecord.getAmount());
        existingRecord.setType(updatedRecord.getType());
        existingRecord.setCategory(updatedRecord.getCategory());
        existingRecord.setRecordDate(updatedRecord.getRecordDate());
        existingRecord.setNotes(updatedRecord.getNotes());
        existingRecord.setCreatedBy(updatedRecord.getCreatedBy());

        return financialRecordService.saveRecord(existingRecord);
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Integer id) {

        FinancialRecord existingRecord = financialRecordService.getRecordById(id);

        if (existingRecord == null) {
            throw new RuntimeException("Record not found with id: " + id);
        }

        financialRecordService.deleteRecord(id);
        return "Record deleted successfully";
    }
}