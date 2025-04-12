package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.BankEntity;
import com.example.repository.BankRepo;

public class Bankservice {

    @Autowired
    private BankRepo br;

    public BankEntity save(BankEntity be) {
        return br.save(be);
    }

    public BankEntity getById(Long id) {
        BankEntity b = br.getById(id);
        return b;
    }

    public List<BankEntity> getAll() {
        return br.findAll();
    }

    public void deleteById(Long id) {
        br.deleteById(id);
    }

    public BankEntity update(Long id, BankEntity be) {
        BankEntity b = br.getById(id);
        b = be;
        return br.save(b);

    }

}
