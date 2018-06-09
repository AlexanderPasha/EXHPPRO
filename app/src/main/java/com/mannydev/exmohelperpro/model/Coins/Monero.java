package com.mannydev.exmohelperpro.model.Coins;

import com.mannydev.exmohelperpro.model.Coin;
import com.mannydev.exmohelperpro.model.Pair;



public class Monero extends Coin {
    private static final double KOMSA = 0.002;
    private static final String USD = "USD";
    private static final String BTC = "BTC";

    public Monero(Pair xmrBtc, Pair xmrUsd,  Pair xmrEur,  Pair btcUsd) {
        super("XMR",xmrBtc,xmrUsd,null,null,null,xmrEur,null,null,null,null,null,btcUsd,null,null,null,null);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();
    }

    @Override
    public String getRightNowBuyUsdProfit() {
        //Buy for usd
        double buyForUsdStep1 = 1 / usdSell;
        double buyForUsd = buyForUsdStep1 - buyForUsdStep1 * KOMSA;

        //Buy for btc
        double buyForBtcstep1 = 1 / Double.parseDouble(btcUsd.getSellPrice());
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 / btcSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия

        //Calc best Profit
        if (buyForUsd < buyForBtc) {
            double btcBuyProfit = buyForBtc * 100 / buyForUsd - 100;
            return "Buy now: BTC (+" + roundResult(btcBuyProfit) + "%)";
        } else {
            double usdBuyProfit = buyForUsd * 100 / buyForBtc - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }
    }

    @Override
    public String getRightNowSellUsdProfit() {
        //Sell for usd
        double sellForUsdStep1 = 1 * usdBuy;
        double sellForUsd = sellForUsdStep1 - (sellForUsdStep1 * KOMSA);

        //Sell for btc
        double sellForBtcStep1 = 1 * btcBuy;
        double sellForBtcStep2 = sellForBtcStep1 - sellForBtcStep1 * KOMSA;
        double sellForBtcStep3 = sellForBtcStep2 * Double.parseDouble(btcUsd.getBuyPrice());
        double sellForBtc = sellForBtcStep3 - sellForBtcStep3 * KOMSA;

        //Calc best Profit
        if (sellForUsd < sellForBtc) {
            double btcSellProfit = sellForBtc * 100 / sellForUsd - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        } else {
            double usdSellProfit = sellForUsd * 100 / sellForBtc - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }
    }

    @Override
    public String getBestBuyProfit() {
        double buyInUsd = usdBuy;
        double buyInBtc = (btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())-((btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())*KOMSA);
        if (buyInBtc>buyInUsd){
            return USD;
        }else return BTC;
    }

    @Override
    public String getBestSellProfit() {
        double sellInUsd = usdSell;
        double sellInBtc = (btcSell-btcSell*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())-((btcSell-btcSell*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())*KOMSA);
        if (sellInBtc<sellInUsd){
            return USD;
        }else return BTC;
    }
}
