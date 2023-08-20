package com.example.ricesale.service.impl;


import com.example.ricesale.entity.SalesRecord;
import com.example.ricesale.repository.SalesRecordRepository;
import com.example.ricesale.service.SalesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ISaleRecordService implements SalesRecordService {
    @Autowired
    public SalesRecordRepository srRepository;

    public static int price_BadRice = 2000;
    public static int price_GoodRice = 20000;

    public double calProfitFromBadRiceByWeek(int weekNum){
        List<SalesRecord> allSales = srRepository.findAll();
        double totalProfit =0 ;
        for(SalesRecord sr : allSales){
            double profit = calProfit(sr.getKg_XinSold());
            if(weekNumber(sr.getDate())== weekNum){
                totalProfit += profit;
            }
        }

        return totalProfit;
    }

    @Override
    public Map<Integer, Double> ListProfitFromBadRiceByAllWeek() {
        Map<Integer,Double> week_profit = new HashMap<>();
        List<SalesRecord> allSales = srRepository.findAll();

        for (SalesRecord sr : allSales) {
            int weekNum = weekNumber(sr.getDate());
            double profit = calProfit(sr.getKg_XinSold());
            week_profit.put(weekNum, week_profit.getOrDefault(weekNum, 0.0) + profit);
        }

        return week_profit;
    }

    @Override
    public Map<Integer, Double> ListProfitFromBadRiceByAllDay() {
        Map<Integer,Double> day_profit = new HashMap<>();
        List<SalesRecord> allSales = srRepository.findAll();

        for (SalesRecord sr : allSales) {

            double profit = calProfit(sr.getKg_XinSold());
            day_profit.put(sr.getDate(), day_profit.getOrDefault(sr.getDate(), 0.0) + profit);
        }

        return day_profit;
    }

    public int weekNumber(int dayNumber){
        return (dayNumber -1 ) / 7 +1;
    }

    public double calProfit(int kg_goodSold){
        int kg_GoodRiceSold = kg_goodSold;
        double kg_BadRiceSold = (kg_GoodRiceSold / 5) * 0.3;
        double profit = kg_BadRiceSold * price_GoodRice - kg_BadRiceSold * price_BadRice;
        return profit;
    }

}
