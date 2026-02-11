package com.rakin.db;

import java.math.BigDecimal;
import java.util.List;

public class DashboardMetrics {
    private List<Sale> todaySales;
    private BigDecimal totalTodaySales;
    private BigDecimal totalMonthlySales;

    public List<Sale> getTodaySales() {
        return todaySales;
    }

    public void setTodaySales(List<Sale> todaySales) {
        this.todaySales = todaySales;
    }

    public BigDecimal getTotalTodaySales() {
        return totalTodaySales;
    }

    public void setTotalTodaySales(BigDecimal totalTodaySales) {
        this.totalTodaySales = totalTodaySales;
    }

    public BigDecimal getTotalMonthlySales() {
        return totalMonthlySales;
    }

    public void setTotalMonthlySales(BigDecimal totalMonthlySales) {
        this.totalMonthlySales = totalMonthlySales;
    }
}