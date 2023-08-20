package com.example.ricesale.controller;



import com.example.ricesale.service.SalesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SalesRecordController {

    @Autowired
    public SalesRecordService saleRecordService;

    @GetMapping("/profit/{week}")
    public double getTotalProfitByWeek(@PathVariable int week){
        return saleRecordService.calProfitFromBadRiceByWeek(week);
    }

    @GetMapping("/list_total_profit_by_week")
    public Map<Integer, Double> getListTotalProfitByWeek(){
        return saleRecordService.ListProfitFromBadRiceByAllWeek();
    }

    @GetMapping("/list_profit_by_day")
    public Map<Integer, Double> getListTotalProfitByDay(){
        return saleRecordService.ListProfitFromBadRiceByAllDay();
    }

}
