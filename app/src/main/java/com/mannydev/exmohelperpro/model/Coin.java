package com.mannydev.exmohelperpro.model;

public class Coin {
    private static final double KOMSA = 0.002;

    protected double btcBuy;
    protected double btcSell;
    protected String btcSpread;

    protected String rightNowBuyProfit;
    protected String rightNowSellProfit;

    private String name;

    protected Pair usdRub;
    protected Pair btcRub;
    protected Pair btcUsd;
    protected Pair ltcUsd;
    protected Pair usdtUsd;
    protected Pair ethUsd;
    protected Pair ethBtc;

    protected double usdBuy;
    protected double usdSell;
    protected String usdSpread;

    protected double rubBuy;
    protected double rubSell;
    protected String rubSpread;

    protected double uahBuy;
    protected double uahSell;
    protected String uahSpread;

    protected double eurBuy;
    protected double eurSell;
    protected String eurSpread;

    protected double plnBuy;
    protected double plnSell;
    protected String plnSpread;

    protected double usdtBuy;
    protected double usdtSell;
    protected String usdtSpread;

    protected double ethBuy;
    protected double ethSell;
    protected String ethSpread;

    protected double ltcBuy;
    protected double ltcSell;
    protected String ltcSpread;

    public Coin(String name, Pair altBtc, Pair altUsd, Pair altRub, Pair usdRub,Pair altUah, Pair altEur, Pair altPln, Pair altUsdt, Pair altEth, Pair altLtc, Pair btcRub, Pair btcUsd, Pair ltcUsd, Pair usdtUsd, Pair ethUsd,Pair ethBtc) {
        this.name = name;

        if(altBtc!=null){
            this.btcBuy = Double.parseDouble(altBtc.getBuyPrice());
            this.btcSell = Double.parseDouble(altBtc.getSellPrice());
            this.btcSpread = getSpread(btcBuy,btcSell);
        }
        if(altUsd!=null){
            this.usdBuy = Double.parseDouble(altUsd.getBuyPrice());
            this.usdSell = Double.parseDouble(altUsd.getSellPrice());
            this.usdSpread = getSpread(usdBuy,usdSell);
        }
        if(altRub!=null){
            this.rubBuy = Double.parseDouble(altRub.getBuyPrice());
            this.rubSell = Double.parseDouble(altRub.getSellPrice());
            this.rubSpread = getSpread(rubBuy,rubSell);
        }
        if(usdRub!=null){
            this.usdRub = usdRub;
        }
        if(btcRub!=null){
            this.btcRub = btcRub;
        }
        if(btcUsd!=null){
            this.btcUsd = btcUsd;
        }
        if(ltcUsd!=null){
            this.ltcUsd = ltcUsd;
        }
        if(usdtUsd!=null){
            this.usdtUsd = usdtUsd;
        }
        if(ethUsd!=null){
            this.ethUsd = ethUsd;
        }
        if(ethBtc!=null){
            this.ethBtc = ethBtc;
        }
        if(altUah!=null){
            this.uahBuy = Double.parseDouble(altUah.getBuyPrice());
            this.uahSell = Double.parseDouble(altUah.getSellPrice());
            this.uahSpread = getSpread(uahBuy,uahSell);
        }
        if(altEur!=null){
            this.eurBuy = Double.parseDouble(altEur.getBuyPrice());
            this.eurSell = Double.parseDouble(altEur.getSellPrice());
            this.eurSpread = getSpread(eurBuy,eurSell);
        }
        if(altPln!=null){
            this.plnBuy = Double.parseDouble(altPln.getBuyPrice());
            this.plnSell = Double.parseDouble(altPln.getSellPrice());
            this.plnSpread = getSpread(plnBuy,plnSell);
        }
        if(altUsdt!=null){
            this.usdtBuy = Double.parseDouble(altUsdt.getBuyPrice());
            this.usdtSell = Double.parseDouble(altUsdt.getSellPrice());
            this.usdtSpread = getSpread(usdtBuy,usdtSell);
        }
        if(altEth!=null){
            this.ethBuy = Double.parseDouble(altEth.getBuyPrice());
            this.ethSell = Double.parseDouble(altEth.getSellPrice());
            this.ethSpread = getSpread(ethBuy,ethSell);
        }
        if(altLtc!=null){
            this.ltcBuy = Double.parseDouble(altLtc.getBuyPrice());
            this.ltcSell = Double.parseDouble(altLtc.getSellPrice());
            this.ltcSpread = getSpread(ltcBuy,ltcSell);
        }

    }

    public String getRightNowBuyUsdProfit(){return null;}

    public String getRightNowSellUsdProfit(){return null;}

    public String getBestBuyProfit(){return null;}

    public String getBestSellProfit(){return null;}

    public static String getSpread(double buy, double sell) {
        double start = 100.0;
        double step1 = start / buy - (start / buy * KOMSA);
        double end = step1 * sell - (step1 * sell * KOMSA);
        double rez = (end - start) * 100 / start;
        return roundResult(rez) + " %";
    }

    public static String roundResult(double d) {
        return String.format("%.2f", d);
    }

    public String getName() {
        return name;
    }

    public double getUsdBuy() {
        return usdBuy;
    }

    public double getUsdSell() {
        return usdSell;
    }

    public double getRubBuy() {
        return rubBuy;
    }

    public double getRubSell() {
        return rubSell;
    }

    public String getRightNowBuyProfit() {
        return rightNowBuyProfit;
    }

    public String getRightNowSellProfit() {
        return rightNowSellProfit;
    }

    public String getUsdSpread() {
        return usdSpread;
    }

    public String getRubSpread() {
        return rubSpread;
    }

    public double getBtcBuy() {
        return btcBuy;
    }

    public double getBtcSell() {
        return btcSell;
    }

    public String getBtcSpread() {
        return btcSpread;
    }

    public double getUahBuy() {
        return uahBuy;
    }

    public double getUahSell() {
        return uahSell;
    }

    public String getUahSpread() {
        return uahSpread;
    }

    public double getEurBuy() {
        return eurBuy;
    }

    public double getEurSell() {
        return eurSell;
    }

    public String getEurSpread() {
        return eurSpread;
    }

    public double getPlnBuy() {
        return plnBuy;
    }

    public double getPlnSell() {
        return plnSell;
    }

    public String getPlnSpread() {
        return plnSpread;
    }

    public double getUsdtBuy() {
        return usdtBuy;
    }

    public double getUsdtSell() {
        return usdtSell;
    }

    public String getUsdtSpread() {
        return usdtSpread;
    }

    public double getEthBuy() {
        return ethBuy;
    }

    public double getEthSell() {
        return ethSell;
    }

    public String getEthSpread() {
        return ethSpread;
    }

    public double getLtcBuy() {
        return ltcBuy;
    }

    public double getLtcSell() {
        return ltcSell;
    }

    public String getLtcSpread() {
        return ltcSpread;
    }

}
