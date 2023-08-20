package com.example.ricesale.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;


@Entity
public class SalesRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int date;

    private int kg_XinSold;

    public SalesRecord() {
    }

    public SalesRecord(Long id, int date, int kg_XinSold) {
        this.id = id;
        this.date = date;
        this.kg_XinSold = kg_XinSold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getKg_XinSold() {
        return kg_XinSold;
    }

    public void setKg_XinSold(int kg_XinSold) {
        this.kg_XinSold = kg_XinSold;
    }


}
