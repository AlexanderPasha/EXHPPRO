package com.mannydev.exmohelperpro.view;

import android.view.View;
import android.widget.TextView;

import com.mannydev.exmohelperpro.R;
import com.mannydev.exmohelperpro.model.Coin;

/**
 * Created by manny on 08.03.18.
 */

public class EtheriumViewHolder extends MyViewHolder {
    TextView txtCoinName,txtUsdBuy,txtUsdSell,txtRubBuy,
            txtRubSell,txtUsdSpread,txtRubSpread,txtBrn,txtSrn,
            txtUahBuy, txtUahSell, txtUahSprd,txtEurBuy,txtEurSell,txtEurSprd,
            txtPlnBuy,txtPlnSell,txtPlnSprd,txtLtcBuy, txtLtcSell,txtLtcSprd,
            txtBtcBuy,txtBtcSell,txtBtcSprd,txtUsdtBuy,txtUsdtSell,txtUsdtSprd;

    public EtheriumViewHolder(View itemView) {
        super(itemView);
        txtCoinName = itemView.findViewById(R.id.txtCoinName);
        txtUsdBuy = itemView.findViewById(R.id.txtUsdBuy);
        txtUsdSell = itemView.findViewById(R.id.txtUsdSell);
        txtRubBuy = itemView.findViewById(R.id.txtRubBuy);
        txtRubSell = itemView.findViewById(R.id.txtRubSell);
        txtUsdSpread = itemView.findViewById(R.id.txtUsdSpread);
        txtRubSpread = itemView.findViewById(R.id.txtRubSpread);

        txtUahBuy = itemView.findViewById(R.id.txtUahBuy);
        txtUahSell = itemView.findViewById(R.id.txtUahSell);
        txtUahSprd = itemView.findViewById(R.id.txtUahSprd);

        txtEurBuy = itemView.findViewById(R.id.txtEurBuy);
        txtEurSell = itemView.findViewById(R.id.txtEurSell);
        txtEurSprd = itemView.findViewById(R.id.txtEurSprd);

        txtPlnBuy = itemView.findViewById(R.id.txtPlnBuy);
        txtPlnSell = itemView.findViewById(R.id.txtPlnSell);
        txtPlnSprd = itemView.findViewById(R.id.txtPlnSprd);

        txtBtcBuy = itemView.findViewById(R.id.txtBtcBuy);
        txtBtcSell = itemView.findViewById(R.id.txtBtcSell);
        txtBtcSprd = itemView.findViewById(R.id.txtBtcSprd);

        txtLtcBuy = itemView.findViewById(R.id.txtLtcBuy);
        txtLtcSell = itemView.findViewById(R.id.txtLtcSell);
        txtLtcSprd = itemView.findViewById(R.id.txtLtcSprd);

        txtUsdtBuy = itemView.findViewById(R.id.txtUsdtBuy);
        txtUsdtSell = itemView.findViewById(R.id.txtUsdtSell);
        txtUsdtSprd = itemView.findViewById(R.id.txtUsdtSprd);

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

        txtUahBuy.setText(String.valueOf(coin.getUahBuy()));
        txtUahSell.setText(String.valueOf(coin.getUahSell()));
        txtUahSprd.setText(String.valueOf(coin.getUahSpread()));

        txtEurBuy.setText(String.valueOf(coin.getEurBuy()));
        txtEurSell.setText(String.valueOf(coin.getEurSell()));
        txtEurSprd.setText(String.valueOf(coin.getEurSpread()));

        txtPlnBuy.setText(String.valueOf(coin.getPlnBuy()));
        txtPlnSell.setText(String.valueOf(coin.getPlnSell()));
        txtPlnSprd.setText(String.valueOf(coin.getPlnSpread()));

        txtBtcBuy.setText(String.valueOf(coin.getBtcBuy()));
        txtBtcSell.setText(String.valueOf(coin.getBtcSell()));
        txtBtcSprd.setText(String.valueOf(coin.getBtcSpread()));

        txtLtcBuy.setText(String.valueOf(coin.getLtcBuy()));
        txtLtcSell.setText(String.valueOf(coin.getLtcSell()));
        txtLtcSprd.setText(String.valueOf(coin.getLtcSpread()));

        txtUsdtBuy.setText(String.valueOf(coin.getUsdtBuy()));
        txtUsdtSell.setText(String.valueOf(coin.getUsdtSell()));
        txtUsdtSprd.setText(String.valueOf(coin.getUsdtSpread()));

        if(coin.getBestBuyProfit().equals("USD")){
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdtBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if(coin.getBestBuyProfit().equals("RUB")){
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdtBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("BTC")){
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdtBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if(coin.getBestBuyProfit().equals("LTC")){
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdtBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("USDT")){
            txtUsdtBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }

        if(coin.getBestSellProfit().equals("USD")){
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdtSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("RUB")){
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdtSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("BTC")){
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdtSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("LTC")){
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdtSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("USDT")){
            txtUsdtSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }
    }
}
