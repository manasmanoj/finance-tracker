package com.ustg.FTWA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ustg.FTWA.service.BankExcelImport;

@RestController
@RequestMapping("/api/bank")
public class BankExcelController {

    @Autowired
    private BankExcelImport importService;

    @PostMapping("/upload")
    public String uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            importService.importBankData(file);
            return "Bank data uploaded successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to upload: " + e.getMessage();
        }
    }
}
