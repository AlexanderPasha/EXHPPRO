package com.mannydev.exmohelperpro.view;

import android.view.View;
import android.widget.TextView;

import com.mannydev.exmohelperpro.R;
import com.mannydev.exmohelperpro.model.Coin;

public class KickViewHolder extends MyViewHolder {
    TextView txtCoinName,txtBrn,txtSrn,
            txtBtcBuy, txtBtcSell, txtBtcSprd,txtEthBuy,txtEthSell,txtEthSprd;

    public KickViewHolder(View itemView) {
        super(itemView);
        txtCoinName = itemView.findViewById(R.id.txtCoinName);

        txtBtcBuy = itemView.findViewById(R.id.txtBtcBuy);
        txtBtcSell = itemView.findViewById(R.id.txtBtcSell);
        txtBtcSprd = itemView.findViewById(R.id.txtBtcSprd);

        txtEthBuy = itemView.findViewById(R.id.txtEthBuy);
        txtEthSell = itemView.findViewById(R.id.txtEthSell);
        txtEthSprd = itemView.findViewById(R.id.txtEthSprd);


        txtBrn = itemView.findViewById(R.id.txtBrn);
        txtSrn = itemView.findViewById(R.id.txtSrn);
    }

    @Override
    public void onBindCoinHolder(Coin coin) {
        txtCoinName.setText(coin.getName());
        txtBrn.setText(coin.getRightNowBuyProfit());
        txtSrn.setText(coin.getRightNowSellProfit());

        txtBtcBuy.setText(String.valueOf(coin.getBtcBuy()));
        txtBtcSell.setText(String.valueOf(coin.getBtcSell()));
        txtBtcSprd.setText(String.valueOf(coin.getBtcSpread()));

        txtEthBuy.setText(String.valueOf(coin.getEthBuy()));
        txtEthSell.setText(String.valueOf(coin.getEthSell()));
        txtEthSprd.setText(String.valueOf(coin.getEthSpread()));

         if (coin.getBestBuyProfit().equals("BTC")){
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtEthBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("ETH")){
            txtEthBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }

        if (coin.getBestSellProfit().equals("BTC")){
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtEthSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }
        else if (coin.getBestSellProfit().equals("ETH")){
            txtEthSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }
    }
}
