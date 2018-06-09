package com.mannydev.exmohelperpro.model.Coins;

import com.mannydev.exmohelperpro.model.Coin;
import com.mannydev.exmohelperpro.model.Pair;

import static com.mannydev.exmohelperpro.MainActivity.USD;

/**
 * Created by manny on 09.03.18.
 */

public class KickCoin extends Coin {
    private static final double KOMSA = 0.002;
    private static final String BTC = "BTC";
    private static final String ETH = "ETH";
    public KickCoin(Pair kickBtc,Pair kickEth,  Pair btcUsd, Pair ethUsd,Pair ethBtc) {
        super("KICK", kickBtc, null, null, null, null, null, null, null, kickEth, null, null, btcUsd, null, null, ethUsd,ethBtc);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();
    }

    @Override
    public String getRightNowBuyUsdProfit() {

        //buy for btc
        double buyForBtcstep1 = 1 / Double.parseDouble(btcUsd.getSellPrice());
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 / btcSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия

        //buy for eth
        double buyForEthstep1 = 1 / Double.parseDouble(ethUsd.getSellPrice());
        double buyForEthStep2 = buyForEthstep1 - buyForEthstep1 * KOMSA;//комиссия
        double buyForEthStep3 = buyForEthStep2 / ethSell;
        double buyForEth = buyForEthStep3 - buyForEthStep3 * KOMSA;//комиссия

        //Calc best Profit
        if(buyForBtc > buyForEth){
            double btcBuyProfit = buyForBtc * 100 / buyForEth - 100;
            return "Buy now: BTC (+" + roundResult(btcBuyProfit) + "%)";
        }

        if (buyForEth>buyForBtc){
            double ethBuyProfit = buyForEth * 100 / buyForBtc - 100;
            return "Buy now: ETH (+" + roundResult(ethBuyProfit) + "%)";
        }

        return "Buy now: BTC";
    }

    @Override
    public String getRightNowSellUsdProfit() {
        //Sell for btc
        double sellForBtcStep1 = 1 * btcSell;
        double sellForBtcStep2 = sellForBtcStep1 - sellForBtcStep1 * KOMSA;
        double sellForBtcStep3 = sellForBtcStep2 / Double.parseDouble(btcUsd.getBuyPrice());
        double sellForBtc = btcSell - btcSell * KOMSA;

        //sell for eth
        double sellForEthStep1 = 1 * ethSell;
        double sellForEthStep2 = sellForEthStep1 - sellForEthStep1 * KOMSA;
        double sellForEthStep3 = sellForEthStep2 * Double.parseDouble(ethBtc.getBuyPrice());
        double sellForEth = sellForEthStep3 - sellForEthStep3 * KOMSA;

        //Calc best Profit

        if (sellForBtc>sellForEth){
            double btcSellProfit = sellForBtc * 100 / sellForEth - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        }

        if (sellForEth>sellForBtc){
            double ethSellProfit = sellForEth * 100 / sellForBtc - 100;
            return "Sell now: ETH (+" + roundResult(ethSellProfit) + "%)";
        }

        return "Sell now: BTC";
    }

    @Override
    public String getBestBuyProfit() {
        double buyInBtc = (btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())-((btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())*KOMSA);
        double buyInEth = (ethBuy-ethBuy*KOMSA)/Double.parseDouble(ethUsd.getBuyPrice()) - (ethBuy-ethBuy*KOMSA)/Double.parseDouble(ethUsd.getBuyPrice())*KOMSA;

        if(buyInBtc<buyInEth){
            return BTC;
        }
        if(buyInEth<buyInBtc){
            return ETH;
        }
        return USD;
    }

    @Override
    public String getBestSellProfit() {
        double sellInBtc = (btcSell-btcSell*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())-((btcSell-btcSell*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())*KOMSA);
        double sellInEth = (ethSell-ethSell*KOMSA)/Double.parseDouble(ethUsd.getBuyPrice())-(ethSell-ethSell*KOMSA)/Double.parseDouble(ethUsd.getBuyPrice())*KOMSA;

        if(sellInBtc>sellInEth){
            return BTC;
        }
        if(sellInEth>sellInBtc){
            return ETH;
        }
        return USD;
    }
}
