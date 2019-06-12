package com.darren.factories;

import com.darren.domain.Revenue;

public class RevenueFactory {

    public static Revenue buildRevenue(String revenueId, String revenueMonth, String revenuePeriod, String revenueAmount, String revenueBranch)
    {
        Revenue revenue = new Revenue.Builder()
                .revenueId(revenueId)
                .revenueMonth(revenueMonth)
                .revenuePeriod(revenuePeriod)
                .revenueAmount(revenueAmount)
                .revenueBranch(revenueBranch)
                .build();
        return revenue;
    }
}
