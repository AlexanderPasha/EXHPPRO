package com.mannydev.exmohelperpro.model.Coins;

import com.mannydev.exmohelperpro.model.Coin;
import com.mannydev.exmohelperpro.model.Pair;


public class Helbiz extends Coin {
    private static final double KOMSA = 0.002;
    private static final String ETH = "ETH";
    private static final String USD = "USD";
    private static final String BTC = "BTC";

    public Helbiz(Pair hbzBtc, Pair hbzUsd, Pair hbzEth, Pair btcUsd, Pair ethUsd) {
        super("HBZ",hbzBtc,hbzUsd,null,null,null,null,null,null,hbzEth,null,null,btcUsd,null,null,ethUsd,null);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();
    }

    @Override
    public String getRightNowBuyUsdProfit() {
        //Buy for usd
        double buyForUsdStep1 = 1 / usdSell;
        double buyForUsd = buyForUsdStep1 - buyForUsdStep1 * KOMSA;

        //Buy for eth
        double buyForEthstep1 = 1 / Double.parseDouble(ethUsd.getSellPrice());
        double buyForEthStep2 = buyForEthstep1 - buyForEthstep1 * KOMSA;//комиссия
        double buyForEthStep3 = buyForEthStep2 / ethSell;
        double buyForEth = buyForEthStep3 - buyForEthStep3 * KOMSA;//комиссия

        //buy for btc
        double buyForBtcstep1 = 1 / Double.parseDouble(btcUsd.getSellPrice());
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 / btcSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия


        //Calc best Profit
        if (buyForUsd < buyForEth && buyForEth>buyForBtc) {
            double ethBuyProfit = buyForEth * 100 / buyForUsd - 100;
            return "Buy now: ETH (+" + roundResult(ethBuyProfit) + "%)";
        }

        if(buyForUsd>buyForEth && buyForUsd>buyForBtc){
            double usdBuyProfit = buyForUsd * 100 / buyForBtc - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }

        if(buyForBtc>buyForUsd && buyForBtc>buyForEth){
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

        //Sell for eth
        double sellForEthStep1 = 1 * ethBuy;
        double sellForEthStep2 = sellForEthStep1 - sellForEthStep1 * KOMSA;
        double sellForEthStep3 = sellForEthStep2 * Double.parseDouble(ethUsd.getBuyPrice());
        double sellForEth = sellForEthStep3 - sellForEthStep3 * KOMSA;

        //Sell for btc
        double sellForBtcStep1 = 1 * btcBuy;
        double sellForBtcStep2 = sellForBtcStep1 - sellForBtcStep1 * KOMSA;
        double sellForBtcStep3 = sellForBtcStep2 * Double.parseDouble(btcUsd.getBuyPrice());
        double sellForBtc = sellForBtcStep3 - sellForBtcStep3 * KOMSA;

        //Calc best Profit
        if (sellForUsd < sellForEth && sellForEth>sellForBtc) {
            double rubSellProfit = sellForEth * 100 / sellForUsd - 100;
            return "Sell now: ETH (+" + roundResult(rubSellProfit) + "%)";
        }
        if(sellForUsd>sellForBtc && sellForUsd>sellForEth){
            double usdSellProfit = sellForUsd * 100 / sellForBtc - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }

        if (sellForBtc>sellForUsd && sellForBtc>sellForEth){
            double btcSellProfit = sellForBtc * 100 / sellForUsd - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        }

        return "Sell now: USD";
    }

    @Override
    public String getBestBuyProfit() {
        double buyInUsd = usdBuy;
        double buyInEth = (ethBuy-ethBuy*KOMSA)/Double.parseDouble(ethUsd.getBuyPrice())-((ethBuy-ethBuy*KOMSA)/Double.parseDouble(ethUsd.getBuyPrice())*KOMSA);
        double buyInBtc = (btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())-((btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())*KOMSA);

        if(buyInUsd>buyInEth && buyInUsd>buyInBtc){
            return USD;
        }
        if(buyInEth>buyInUsd && buyInEth>buyInBtc){
            return ETH;
        }
        if(buyInBtc>buyInUsd && buyInBtc>buyInEth){
            return BTC;
        }
        return USD;
    }

    @Override
    public String getBestSellProfit() {
        double sellInUsd = usdSell;
        double sellInEth = (ethSell-ethSell*KOMSA)/Double.parseDouble(ethUsd.getBuyPrice())-((ethSell-ethSell*KOMSA)/Double.parseDouble(ethUsd.getBuyPrice())*KOMSA);
        double sellInBtc = (btcSell-btcSell*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())-((btcSell-btcSell*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())*KOMSA);
        if(sellInUsd<sellInEth && sellInUsd<sellInBtc){
            return USD;
        }
        if(sellInEth<sellInUsd && sellInEth<sellInBtc){
            return ETH;
        }
        if(sellInBtc<sellInUsd && sellInBtc<sellInEth){
            return BTC;
        }
        return USD;
    }
}
