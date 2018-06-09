package com.mannydev.exmohelperpro.view;

import android.view.View;
import android.widget.TextView;

import com.mannydev.exmohelperpro.R;
import com.mannydev.exmohelperpro.model.Coin;

/**
 * Created by manny on 08.03.18.
 */

public class LitecoinViewHolder extends MyViewHolder {
    TextView txtCoinName,txtUsdBuy,txtUsdSell,txtRubBuy,
            txtRubSell,txtUsdSpread,txtRubSpread,txtBrn,txtSrn,
            txtBtcBuy, txtBtcSell, txtBtcSprd,txtEurBuy,txtEurSell,txtEurSprd;


    public LitecoinViewHolder(View itemView) {
        super(itemView);
        txtCoinName = itemView.findViewById(R.id.txtCoinName);
        txtUsdBuy = itemView.findViewById(R.id.txtUsdBuy);
        txtUsdSell = itemView.findViewById(R.id.txtUsdSell);
        txtRubBuy = itemView.findViewById(R.id.txtRubBuy);
        txtRubSell = itemView.findViewById(R.id.txtRubSell);
        txtUsdSpread = itemView.findViewById(R.id.txtUsdSpread);
        txtRubSpread = itemView.findViewById(R.id.txtRubSpread);

        txtBtcBuy = itemView.findViewById(R.id.txtBtcBuy);
        txtBtcSell = itemView.findViewById(R.id.txtBtcSell);
        txtBtcSprd = itemView.findViewById(R.id.txtBtcSprd);

        txtEurBuy = itemView.findViewById(R.id.txtEurBuy);
        txtEurSell = itemView.findViewById(R.id.txtEurSell);
        txtEurSprd = itemView.findViewById(R.id.txtEurSprd);


        txtBrn = itemView.findViewById(R.id.txtBrn);
        txtSrn = itemView.findViewById(R.id.txtSrn);
    }

    @Override
    public void onBindCoinHolder(Coin coin) {
        txtCoinName.setText(coin.getName());
        txtUsdBuy.setText(String.valueOf(coin.getUsdBuy()));
        txtUsdSell.setText(String.valueOf(coin.getUsdSell()));
        txtRubBuy.setText(String.valueOf(coin.getRubBuy()));
        txtRubSell.setText(String.valueOf(coin.getRubSell()));
        txtUsdSpread.setText(coin.getUsdSpread());
        txtRubSpread.setText(coin.getRubSpread());
        txtBrn.setText(coin.getRightNowBuyProfit());
        txtSrn.setText(coin.getRightNowSellProfit());

        txtBtcBuy.setText(String.valueOf(coin.getBtcBuy()));
        txtBtcSell.setText(String.valueOf(coin.getBtcSell()));
        txtBtcSprd.setText(String.valueOf(coin.getBtcSpread()));

        txtEurBuy.setText(String.valueOf(coin.getEurBuy()));
        txtEurSell.setText(String.valueOf(coin.getEurSell()));
        txtEurSprd.setText(String.valueOf(coin.getEurSpread()));

        if(coin.getBestBuyProfit().equals("USD")){
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if(coin.getBestBuyProfit().equals("RUB")){
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("BTC")){
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }

        if(coin.getBestSellProfit().equals("USD")){
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("RUB")){
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("BTC")){
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }

    }
}
