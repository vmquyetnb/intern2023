package com.example.ricesale.service;



import java.util.List;
import java.util.Map;

public interface SalesRecordService {
    double calProfitFromBadRiceByWeek(int weekNum);
    Map<Integer , Double> ListProfitFromBadRiceByAllWeek();
    Map<Integer , Double> ListProfitFromBadRiceByAllDay();
}
