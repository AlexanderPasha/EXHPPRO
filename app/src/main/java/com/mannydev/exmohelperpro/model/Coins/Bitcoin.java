package com.mannydev.exmohelperpro.model.Coins;


import com.mannydev.exmohelperpro.model.Coin;
import com.mannydev.exmohelperpro.model.Pair;

public class Bitcoin extends Coin {

    private static final double KOMSA = 0.002;
    private static final String RUB = "RUB";
    private static final String USD = "USD";

    public Bitcoin(Pair btcUsd, Pair btcRub, Pair usdRub, Pair btcUah, Pair btcEur, Pair btcPln, Pair btcUsdt) {
        super("BTC",null,btcUsd,btcRub,usdRub,btcUah,btcEur,btcPln,btcUsdt,null,null,null,null,null,null,null,null);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();

    }

    @Override
    public String getRightNowBuyUsdProfit() {
        //Buy for usd
        double buyForUsdStep1 = 1/usdSell;
        double buyForUsd = buyForUsdStep1 - buyForUsdStep1 * KOMSA;

        //Buy for rub
        double buyForRubstep1 = 1 * Double.parseDouble(usdRub.getBuyPrice());
        double buyForRubStep2 = buyForRubstep1 - buyForRubstep1 * KOMSA;//комиссия
        double buyForRubStep3 = buyForRubStep2 / rubSell;
        double buyForRub = buyForRubStep3 - buyForRubStep3 * KOMSA;//комиссия

        //Calc best Profit
        if (buyForUsd < buyForRub) {
            double rubBuyProfit = buyForRub * 100 / buyForUsd - 100;
            return "Buy now: RUB (+" + roundResult(rubBuyProfit) + "%)";
        } else {
            double usdBuyProfit = buyForUsd * 100 / buyForRub - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }

    }

    @Override
    public String getRightNowSellUsdProfit() {
        //Sell for usd
        double sellForUsdStep1 = 1 * usdBuy;
        double sellForUsd = sellForUsdStep1 - (sellForUsdStep1 * KOMSA);

        //Sell for rub
        double sellForRubStep1 = 1 * rubBuy;
        double sellForRubStep2 = sellForRubStep1 - sellForRubStep1 * KOMSA;
        double sellForRubStep3 = sellForRubStep2 / Double.parseDouble(usdRub.getSellPrice());
        double sellForRub = sellForRubStep3 - sellForRubStep3 * KOMSA;

        //Calc best Profit
        if (sellForUsd < sellForRub) {
            double rubSellProfit = sellForRub * 100 / sellForUsd - 100;
            return "Sell now: RUB (+" + roundResult(rubSellProfit) + "%)";
        } else {
            double usdSellProfit = sellForUsd * 100 / sellForRub - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }
    }

    @Override
    public String getBestBuyProfit() {
        double buyInUsd = usdBuy;
        double buyInRub = (rubBuy-rubBuy*KOMSA)/Double.parseDouble(usdRub.getSellPrice())-((rubBuy-rubBuy*KOMSA)/Double.parseDouble(usdRub.getSellPrice())*KOMSA);
        if (buyInRub>buyInUsd){
            return USD;
        }else return RUB;
    }

    @Override
    public String getBestSellProfit() {
        double sellInUsd = usdSell;
        double sellInRub = (rubSell-rubSell*KOMSA)/Double.parseDouble(usdRub.getSellPrice())-((rubSell-rubSell*KOMSA)/Double.parseDouble(usdRub.getSellPrice())*KOMSA);
        if (sellInRub<sellInUsd){
            return USD;
        }else return RUB;
    }
}
