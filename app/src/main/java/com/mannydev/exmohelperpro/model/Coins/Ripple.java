package com.mannydev.exmohelperpro.model.Coins;

import com.mannydev.exmohelperpro.model.Coin;
import com.mannydev.exmohelperpro.model.Pair;

/**
 * Created by manny on 09.03.18.
 */

public class Ripple extends Coin {
    private static final double KOMSA = 0.002;
    private static final String RUB = "RUB";
    private static final String USD = "USD";
    private static final String BTC = "BTC";

    public Ripple(Pair xrpBtc, Pair xrpUsd, Pair xrpRub, Pair usdRub,  Pair btcUsd) {
        super("XRP",xrpBtc,xrpUsd,xrpRub,usdRub,null,null,null,null,null,null,null,btcUsd,null,null,null,null);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();
    }

    @Override
    public String getRightNowBuyUsdProfit() {
        //Buy for usd
        double buyForUsdStep1 = 1 / usdSell;
        double buyForUsd = buyForUsdStep1 - buyForUsdStep1 * KOMSA;

        //Buy for rub
        double buyForRubstep1 = 1 * Double.parseDouble(usdRub.getBuyPrice());
        double buyForRubStep2 = buyForRubstep1 - buyForRubstep1 * KOMSA;//комиссия
        double buyForRubStep3 = buyForRubStep2 / rubSell;
        double buyForRub = buyForRubStep3 - buyForRubStep3 * KOMSA;//комиссия

        //buy for btc
        double buyForBtcstep1 = 1 / Double.parseDouble(btcUsd.getSellPrice());
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 * btcSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия


        //Calc best Profit
        if (buyForUsd < buyForRub && buyForRub>buyForBtc) {
            double rubBuyProfit = buyForRub * 100 / buyForUsd - 100;
            return "Buy now: RUB (+" + roundResult(rubBuyProfit) + "%)";
        }

        if(buyForUsd>buyForRub && buyForUsd>buyForBtc){
            double usdBuyProfit = buyForUsd * 100 / buyForRub - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }

        if(buyForBtc>buyForUsd && buyForBtc>buyForRub){
            double btcBuyProfit = buyForBtc * 100 / buyForUsd - 100;
            return "Buy now: BTC (+" + roundResult(btcBuyProfit) + "%)";
        }

        return "Buy now: USD";
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

        //Sell for btc
        double sellForBtcStep1 = 1 * btcBuy;
        double sellForBtcStep2 = sellForBtcStep1 - sellForBtcStep1 * KOMSA;
        double sellForBtcStep3 = sellForBtcStep2 / Double.parseDouble(btcUsd.getBuyPrice());
        double sellForBtc = sellForBtcStep3 - sellForBtcStep3 * KOMSA;

        //Calc best Profit
        if (sellForUsd < sellForRub && sellForRub>sellForBtc) {
            double rubSellProfit = sellForRub * 100 / sellForUsd - 100;
            return "Sell now: RUB (+" + roundResult(rubSellProfit) + "%)";
        }
        if(sellForUsd>sellForBtc && sellForUsd>sellForRub){
            double usdSellProfit = sellForUsd * 100 / sellForRub - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }

        if (sellForBtc>sellForUsd && sellForBtc>sellForRub){
            double btcSellProfit = sellForBtc * 100 / sellForUsd - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        }

        return "Sell now: USD";
    }

    @Override
    public String getBestBuyProfit() {
        double buyInUsd = usdBuy;
        double buyInRub = (rubBuy-rubBuy*KOMSA)/Double.parseDouble(usdRub.getSellPrice())-((rubBuy-rubBuy*KOMSA)/Double.parseDouble(usdRub.getSellPrice())*KOMSA);
        double buyInBtc = (btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())-((btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())*KOMSA);

        if(buyInUsd<buyInRub && buyInUsd<buyInBtc){
            return USD;
        }
        if(buyInRub<buyInUsd && buyInRub<buyInBtc){
            return RUB;
        }
        if(buyInBtc<buyInUsd && buyInBtc<buyInRub){
            return BTC;
        }
        return USD;
    }

    @Override
    public String getBestSellProfit() {
        double sellInUsd = usdSell;
        double sellInRub = (rubSell-rubSell*KOMSA)/Double.parseDouble(usdRub.getSellPrice())-((rubSell-rubSell*KOMSA)/Double.parseDouble(usdRub.getSellPrice())*KOMSA);
        double sellInBtc = (btcSell-btcSell*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())-((btcSell-btcSell*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())*KOMSA);
        if(sellInUsd>sellInRub && sellInUsd>sellInBtc){
            return USD;
        }
        if(sellInRub>sellInUsd && sellInRub>sellInBtc){
            return RUB;
        }
        if(sellInBtc>sellInUsd && sellInBtc>sellInRub){
            return BTC;
        }
        return USD;
    }
}
