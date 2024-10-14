package com.sunkenquest.ExpenseTracker.sevices.stats;

import com.sunkenquest.ExpenseTracker.dto.GraphDTO;
import com.sunkenquest.ExpenseTracker.dto.StatsDTO;

public interface StatsService {
    GraphDTO getChartData();

    StatsDTO getStats();
}
