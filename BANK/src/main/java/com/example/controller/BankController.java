package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.BankEntity;
import com.example.service.Bankservice;

@RestController
public class BankController {

    @Autowired
    private Bankservice bankservice;

    @PostMapping
    public BankEntity create(@RequestBody BankEntity be) {
        return bankservice.save(be);
    }

    @GetMapping("/{id}")
    public BankEntity getById(@PathVariable Long id) {
        return bankservice.getById(id);
    }

    @GetMapping
    public List<BankEntity> getAll() {
        return bankservice.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bankservice.deleteById(id);
    }

    @PutMapping("/{id}")
    public BankEntity Update(@PathVariable Long id, @RequestBody BankEntity be) {
        return bankservice.update(id, be);
    }
}
