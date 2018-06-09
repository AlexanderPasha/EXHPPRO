package com.mannydev.exmohelperpro.model.Coins;

import com.mannydev.exmohelperpro.model.Coin;
import com.mannydev.exmohelperpro.model.Pair;

/**
 * Created by manny on 08.03.18.
 */

public class Etherium extends Coin {
    private static final double KOMSA = 0.002;
    private static final String RUB = "RUB";
    private static final String USD = "USD";
    private static final String BTC = "BTC";
    private static final String LTC = "LTC";
    private static final String USDT = "USDT";

    public Etherium(Pair ethBtc, Pair ethUsd, Pair ethRub, Pair usdRub, Pair ethUah, Pair ethEur, Pair ethPln, Pair ethUsdt, Pair ethLtc, Pair btcUsd, Pair ltcUsd, Pair usdtUsd) {
        super("ETH",ethBtc,ethUsd,ethRub,usdRub,ethUah,ethEur,ethPln,ethUsdt,null,ethLtc,null,btcUsd, ltcUsd,usdtUsd,null,null);
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
        double buyForBtcStep3 = buyForBtcStep2 / btcSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия

        //buy for ltc
        double buyForLtcStep1 = 1/Double.parseDouble(ltcUsd.getSellPrice());
        double buyForLtcStep2 = buyForLtcStep1 - buyForLtcStep1 * KOMSA;
        double buyForLtcStep3 = buyForLtcStep2 / ltcSell;
        double buyForLtc = buyForLtcStep3 - buyForLtcStep3 * KOMSA;

        //buy for usdt
        double buyForUsdtStep1 = 1/Double.parseDouble(usdtUsd.getSellPrice());
        double buyForUsdtStep2 = buyForUsdtStep1 - buyForUsdtStep1 * KOMSA;
        double buyForUsdtStep3 = buyForUsdtStep2 / usdtSell;
        double buyForUsdt = buyForUsdtStep3 - buyForUsdtStep3 * KOMSA;

        //Calc best Profit
        if (buyForUsd < buyForRub && buyForRub>buyForBtc && buyForRub > buyForLtc && buyForRub > buyForUsdt) {
            double rubBuyProfit = buyForRub * 100 / buyForUsd - 100;
            return "Buy now: RUB (+" + roundResult(rubBuyProfit) + "%)";
        }

        if(buyForUsd>buyForRub && buyForUsd>buyForBtc && buyForUsd > buyForLtc && buyForUsd > buyForUsdt){
            double usdBuyProfit = buyForUsd * 100 / buyForRub - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }

        if(buyForBtc>buyForUsd && buyForBtc>buyForRub && buyForBtc>buyForLtc && buyForBtc > buyForUsdt){
            double btcBuyProfit = buyForBtc * 100 / buyForUsd - 100;
            return "Buy now: BTC (+" + roundResult(btcBuyProfit) + "%)";
        }

        if(buyForLtc > buyForUsd && buyForLtc > buyForRub && buyForLtc > buyForBtc && buyForLtc > buyForUsdt){
            double ltcBuyProfit = buyForLtc * 100 / buyForUsd - 100;
            return "Buy now: LTC (+" + roundResult(ltcBuyProfit) + "%)";
        }

        if(buyForUsdt > buyForUsd && buyForUsdt > buyForRub && buyForUsdt > buyForBtc && buyForUsdt > buyForLtc){
            double usdtBuyProfit = buyForUsdt * 100 / buyForUsd - 100;
            return "Buy now: USDT (+" + roundResult(usdtBuyProfit) + "%)";
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

        //Sell for ltc
        double sellForLtcStep1 = 1 * ltcBuy;
        double sellForLtcStep2 = sellForLtcStep1 - sellForLtcStep1 * KOMSA;
        double sellForLtcStep3 = sellForLtcStep2 / Double.parseDouble(ltcUsd.getBuyPrice());
        double sellForLtc = sellForLtcStep3 - sellForLtcStep3 * KOMSA;

        //Sell for usdt
        double sellForUsdtStep1 = 1 * usdtBuy;
        double sellForUsdtStep2 = sellForUsdtStep1 - sellForUsdtStep1 * KOMSA;
        double sellForUsdtStep3 = sellForUsdtStep2 / Double.parseDouble(usdtUsd.getBuyPrice());
        double sellForUsdt = sellForUsdtStep3 - sellForUsdtStep3 * KOMSA;

        //Calc best Profit
        if (sellForUsd < sellForRub && sellForRub>sellForBtc && sellForRub > sellForLtc && sellForRub > sellForUsdt) {
            double rubSellProfit = sellForRub * 100 / sellForUsd - 100;
            return "Sell now: RUB (+" + roundResult(rubSellProfit) + "%)";
        }
        if(sellForUsd>sellForBtc && sellForUsd>sellForRub && sellForUsd > sellForLtc && sellForUsd > sellForUsdt){
            double usdSellProfit = sellForUsd * 100 / sellForRub - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }

        if (sellForBtc>sellForUsd && sellForBtc>sellForRub && sellForBtc > sellForLtc && sellForBtc > sellForUsdt){
            double btcSellProfit = sellForBtc * 100 / sellForUsd - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        }

        if(sellForLtc > sellForUsd && sellForLtc > sellForRub && sellForLtc > sellForBtc && sellForLtc > sellForUsdt){
            double ltcSellProfit = sellForLtc * 100 / sellForUsd - 100;
            return "Sell now: LTC (+" + roundResult(ltcSellProfit) + "%)";
        }

        if(sellForUsdt > sellForUsd && sellForUsdt > sellForRub && sellForUsdt > sellForBtc && sellForUsdt > sellForLtc){
            double usdtSellProfit = sellForUsdt * 100 / sellForUsd - 100;
            return "Sell now: USDT (+" + roundResult(usdtSellProfit) + "%)";
        }

        return "Sell now: USD";
    }

    @Override
    public String getBestBuyProfit() {
        double buyInUsd = usdBuy;
        double buyInRub = (rubBuy-rubBuy*KOMSA)/Double.parseDouble(usdRub.getSellPrice())-((rubBuy-rubBuy*KOMSA)/Double.parseDouble(usdRub.getSellPrice())*KOMSA);
        double buyInBtc = (btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())-((btcBuy-btcBuy*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())*KOMSA);
        double buyInLtc = (ltcBuy-ltcBuy*KOMSA)/Double.parseDouble(ltcUsd.getBuyPrice())-((ltcBuy-ltcBuy*KOMSA)/Double.parseDouble(ltcUsd.getBuyPrice())*KOMSA);
        double buyInUsdt = (usdtBuy-usdtBuy*KOMSA)/Double.parseDouble(usdtUsd.getBuyPrice()) - ((usdtBuy-usdtBuy*KOMSA)/Double.parseDouble(usdtUsd.getBuyPrice())*KOMSA);

        if(buyInUsd<buyInRub && buyInUsd<buyInBtc && buyInUsd<buyInLtc && buyInUsd < buyInUsdt){
            return USD;
        }
        if(buyInRub<buyInUsd && buyInRub<buyInBtc && buyInRub < buyInLtc && buyInRub < buyInUsdt){
            return RUB;
        }
        if(buyInBtc<buyInUsd && buyInBtc<buyInRub && buyInBtc < buyInLtc && buyInBtc < buyInUsdt){
            return BTC;
        }
        if(buyInLtc < buyInUsd && buyInLtc < buyInRub && buyInLtc < buyInBtc && buyInLtc < buyInUsdt){
            return LTC;
        }
        if(buyInUsdt<buyInUsd && buyInUsdt < buyInRub && buyInUsdt < buyInBtc && buyInUsdt < buyInLtc){
            return USDT;
        }
        return USD;
    }

    @Override
    public String getBestSellProfit() {
        double sellInUsd = usdSell;
        double sellInRub = (rubSell-rubSell*KOMSA)/Double.parseDouble(usdRub.getSellPrice())-((rubSell-rubSell*KOMSA)/Double.parseDouble(usdRub.getSellPrice())*KOMSA);
        double sellInBtc = (btcSell-btcSell*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())-((btcSell-btcSell*KOMSA)/Double.parseDouble(btcUsd.getBuyPrice())*KOMSA);
        double sellInLtc = (ltcSell-ltcSell*KOMSA)/Double.parseDouble(ltcUsd.getBuyPrice())-(ltcSell-ltcSell*KOMSA)/Double.parseDouble(ltcUsd.getBuyPrice())*KOMSA;
        double sellInUsdt = (usdtSell-usdtSell*KOMSA)/Double.parseDouble(usdtUsd.getBuyPrice()) - (usdtSell-usdtSell*KOMSA)/Double.parseDouble(usdtUsd.getBuyPrice())*KOMSA;

        if(sellInUsd>sellInRub && sellInUsd>sellInBtc && sellInUsd > sellInLtc && sellInUsd > sellInUsdt){
            return USD;
        }
        if(sellInRub>sellInUsd && sellInRub>sellInBtc && sellInRub > sellInLtc && sellInRub > sellInUsdt){
            return RUB;
        }
        if(sellInBtc>sellInUsd && sellInBtc>sellInRub && sellInBtc > sellInLtc && sellInBtc > sellInUsdt){
            return BTC;
        }
        if(sellInLtc>sellInUsd && sellInLtc>sellInRub && sellInLtc>sellInBtc && sellInLtc>sellInUsdt){
            return LTC;
        }
        if (sellInUsdt>sellInUsd && sellInUsdt>sellInRub && sellInUsdt>sellInBtc && sellInUsdt>sellInLtc){
            return USDT;
        }
        return USD;
    }


}
