package com.ustg.FTWA.service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ustg.FTWA.entity.Bank;
import com.ustg.FTWA.entity.User;
import com.ustg.FTWA.repository.BankRepository;
import com.ustg.FTWA.repository.UserRepository;

@Service
public class BankExcelImport {
    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private UserRepository userRepository;

    public void importBankData(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();

        rows.next(); // Skip header

        while (rows.hasNext()) {
            Row row = rows.next();

            Bank bank = new Bank();
            bank.setAmount(new BigDecimal(row.getCell(1).getNumericCellValue()));
            bank.setChoose(Bank.Choose.valueOf(row.getCell(2).getStringCellValue()));
            bank.setCategoryId(row.getCell(3).getStringCellValue());
            bank.setDate(row.getCell(4).getStringCellValue());
            bank.setDescription(row.getCell(5).getStringCellValue());

            String username = row.getCell(6).getStringCellValue();
            User user = userRepository.findById(username).orElse(null);
            bank.setUser(user); // optionally handle null users

            bankRepository.save(bank);
        }

        workbook.close();
    }
}
