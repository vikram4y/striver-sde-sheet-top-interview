package com.vikram.striver.sde.sheet.arrays;

public class StockBuySell {
    public static void main(String[] args) {
        StockBuySell stockBuySell = new StockBuySell();
        int[] arr = {7,1,5,3,6,4};
        System.out.println("Max profit = "+stockBuySell.maxProfit(arr));
    }

    //Optimal
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i=0;i<prices.length;i++) {
            profit = Math.max(profit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }
}
