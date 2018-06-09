package com.mannydev.exmohelperpro.view;

import android.view.View;
import android.widget.TextView;

import com.mannydev.exmohelperpro.R;
import com.mannydev.exmohelperpro.model.Coin;


public class HelbizViewHolder extends MyViewHolder {
    TextView txtCoinName,txtUsdBuy,txtUsdSell,txtEthBuy,
            txtEthSell,txtUsdSpread,txtEthSpread,txtBrn,txtSrn,
            txtBtcBuy, txtBtcSell, txtBtcSprd;

    public HelbizViewHolder(View itemView) {
        super(itemView);
        txtCoinName = itemView.findViewById(R.id.txtCoinName);
        txtUsdBuy = itemView.findViewById(R.id.txtUsdBuy);
        txtUsdSell = itemView.findViewById(R.id.txtUsdSell);
        txtEthBuy = itemView.findViewById(R.id.txtEthBuy);
        txtEthSell = itemView.findViewById(R.id.txtEthSell);
        txtUsdSpread = itemView.findViewById(R.id.txtUsdSpread);
        txtEthSpread = itemView.findViewById(R.id.txtEthSpread);

        txtBtcBuy = itemView.findViewById(R.id.txtBtcBuy);
        txtBtcSell = itemView.findViewById(R.id.txtBtcSell);
        txtBtcSprd = itemView.findViewById(R.id.txtBtcSprd);

        txtBrn = itemView.findViewById(R.id.txtBrn);
        txtSrn = itemView.findViewById(R.id.txtSrn);
    }

    @Override
    public void onBindCoinHolder(Coin coin) {
        txtCoinName.setText(coin.getName());
        txtUsdBuy.setText(String.valueOf(coin.getUsdBuy()));
        txtUsdSell.setText(String.valueOf(coin.getUsdSell()));
        txtEthBuy.setText(String.valueOf(coin.getEthBuy()));
        txtEthSell.setText(String.valueOf(coin.getEthSell()));
        txtUsdSpread.setText(coin.getUsdSpread());
        txtEthSpread.setText(coin.getEthSpread());
        txtBrn.setText(coin.getRightNowBuyProfit());
        txtSrn.setText(coin.getRightNowSellProfit());

        txtBtcBuy.setText(String.valueOf(coin.getBtcBuy()));
        txtBtcSell.setText(String.valueOf(coin.getBtcSell()));
        txtBtcSprd.setText(String.valueOf(coin.getBtcSpread()));

        if(coin.getBestBuyProfit().equals("USD")){
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtEthBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if(coin.getBestBuyProfit().equals("ETH")){
            txtEthBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("BTC")){
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtEthBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }

        if(coin.getBestSellProfit().equals("USD")){
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtEthSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("ETH")){
            txtEthSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("BTC")){
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtEthSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }
    }
}
