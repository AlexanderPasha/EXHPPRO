package com.mannydev.exmohelperpro.model.Coins;

import com.mannydev.exmohelperpro.model.Coin;
import com.mannydev.exmohelperpro.model.Pair;



public class Waves extends Coin {
    private static final double KOMSA = 0.002;
    private static final String BTC = "BTC";
    private static final String RUB = "RUB";

    public Waves(Pair wavesBtc, Pair wavesRub, Pair usdRub, Pair btcRub) {
        super("WAVES",wavesBtc,null,wavesRub,usdRub,null,null,null,null,null,null,btcRub,null,null,null,null,null);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();
    }

    @Override
    public String getRightNowBuyUsdProfit() {
        //Buy for rub
        double buyForRub = 1/rubSell-(1/rubBuy*KOMSA);

        //buy for btc
        double buyForBtcstep1 = 1 / Double.parseDouble(btcRub.getSellPrice());
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 / btcSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия


        //Calc best Profit
        if (buyForRub>buyForBtc) {
            double rubBuyProfit = buyForRub * 100 / buyForBtc - 100;
            return "Buy now: RUB (+" + roundResult(rubBuyProfit) + "%)";
        }

        if(buyForBtc>buyForRub){
            double btcBuyProfit = buyForBtc * 100 / buyForRub - 100;
            return "Buy now: BTC (+" + roundResult(btcBuyProfit) + "%)";
        }

        return "Buy now: BTC";
    }

    @Override
    public String getRightNowSellUsdProfit() {
        //Sell for rub
        double sellForRubStep1 = 1 * rubBuy;
        double sellForRubStep2 = sellForRubStep1 - sellForRubStep1 * KOMSA;
        double sellForRubStep3 = sellForRubStep2 / Double.parseDouble(usdRub.getSellPrice());
        double sellForRub = rubBuy;

        //Sell for btc
        double sellForBtcStep1 = 1 * btcBuy;
        double sellForBtcStep2 = sellForBtcStep1 - sellForBtcStep1 * KOMSA;
        double sellForBtcStep3 = sellForBtcStep2 * Double.parseDouble(btcRub.getSellPrice());
        double sellForBtc = sellForBtcStep3 - sellForBtcStep3 * KOMSA;

        //Calc best Profit
        if (sellForRub>sellForBtc) {
            double rubSellProfit = sellForRub * 100 / sellForBtc - 100;
            return "Sell now: RUB (+" + roundResult(rubSellProfit) + "%)";
        }

        if (sellForBtc>sellForRub){
            double btcSellProfit = sellForBtc * 100 / sellForRub - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        }

        return "Sell now: BTC";
    }

    @Override
    public String getBestBuyProfit() {
        double buyInRub = (rubBuy-rubBuy*KOMSA)/Double.parseDouble(usdRub.getSellPrice())-((rubBuy-rubBuy*KOMSA)/Double.parseDouble(usdRub.getSellPrice())*KOMSA);
        double buyInBtc = (btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcRub.getBuyPrice())-((btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcRub.getBuyPrice())*KOMSA);


        if(buyInRub<buyInBtc){
            return RUB;
        }
        if(buyInBtc<buyInRub){
            return BTC;
        }
        return BTC;
    }

    @Override
    public String getBestSellProfit() {
        double sellInRub = (rubSell-rubSell*KOMSA)/Double.parseDouble(usdRub.getSellPrice())-((rubSell-rubSell*KOMSA)/Double.parseDouble(usdRub.getSellPrice())*KOMSA);
        double sellInBtc = (btcSell-btcSell*KOMSA)/Double.parseDouble(btcRub.getBuyPrice())-((btcSell-btcSell*KOMSA)/Double.parseDouble(btcRub.getBuyPrice())*KOMSA);

        if(sellInRub>sellInBtc){
            return RUB;
        }
        if(sellInBtc>sellInRub){
            return BTC;
        }
        return BTC;
    }


}
