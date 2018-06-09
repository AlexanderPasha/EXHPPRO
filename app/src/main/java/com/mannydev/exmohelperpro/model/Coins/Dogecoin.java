package com.mannydev.exmohelperpro.model.Coins;

import com.mannydev.exmohelperpro.model.Coin;
import com.mannydev.exmohelperpro.model.Pair;

import static com.mannydev.exmohelperpro.MainActivity.exmo;

/**
 * Created by manny on 08.03.18.
 */

public class Dogecoin extends Coin {
    public Dogecoin(Pair dogeBtc) {
        super("DOGE",exmo.getDOGEBTC(),null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
    }

    @Override
    public String getRightNowBuyUsdProfit() {
        return null;
    }

    @Override
    public String getRightNowSellUsdProfit() {
        return null;
    }

    @Override
    public String getBestBuyProfit() {
        return null;
    }

    @Override
    public String getBestSellProfit() {
        return null;
    }


}
