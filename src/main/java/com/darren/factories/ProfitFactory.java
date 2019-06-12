package com.darren.factories;


import com.darren.domain.Profit;

public class ProfitFactory {

    public static Profit buildProfit(String profitId, String profitProjected, String profitActual)
    {
        Profit profit = new Profit.Builder()
                .profitId(profitId)
                .profitProjected(profitProjected)
                .profitActual(profitActual)
                .build();
        return profit;
    }
}
