package com.mannydev.exmohelperpro.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mannydev.exmohelperpro.model.Token;
import com.mannydev.exmohelperpro.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import static com.mannydev.exmohelperpro.MainActivity.exmo;



public class MyTokensListViewAdapter extends BaseAdapter {
    private LayoutInflater lInflater;
    TextView txtTokenName, txtTokenBalance, txtUsd, txtProfit;
    ArrayList<Token>list;
    Map<String,String>coinsLogos;

    public MyTokensListViewAdapter(ArrayList<Token>list) {
        this.list = list;
        coinsLogos = new HashMap<String, String>();
        coinsLogos.put("BTC","https://s2.coinmarketcap.com/static/img/coins/32x32/1.png");
        coinsLogos.put("LTC","https://s2.coinmarketcap.com/static/img/coins/32x32/2.png");
        coinsLogos.put("ETH","https://s2.coinmarketcap.com/static/img/coins/32x32/1027.png");
        coinsLogos.put("XRP","https://s2.coinmarketcap.com/static/img/coins/32x32/52.png");
        coinsLogos.put("ETC","https://s2.coinmarketcap.com/static/img/coins/32x32/1321.png");
        coinsLogos.put("ZEC","https://s2.coinmarketcap.com/static/img/coins/32x32/1437.png");
        coinsLogos.put("DASH","https://s2.coinmarketcap.com/static/img/coins/32x32/131.png");
        coinsLogos.put("DOGE","https://s2.coinmarketcap.com/static/img/coins/32x32/74.png");
        coinsLogos.put("BCH","https://s2.coinmarketcap.com/static/img/coins/32x32/1831.png");
        coinsLogos.put("KICK","https://s2.coinmarketcap.com/static/img/coins/32x32/2017.png");
        coinsLogos.put("WAVES","https://s2.coinmarketcap.com/static/img/coins/32x32/1274.png");
        coinsLogos.put("USDT","https://s2.coinmarketcap.com/static/img/coins/32x32/825.png");
        coinsLogos.put("XMR","https://s2.coinmarketcap.com/static/img/coins/32x32/328.png");
        coinsLogos.put("HBZ","https://s2.coinmarketcap.com/static/img/coins/32x32/2680.png");
        coinsLogos.put("EOS","https://s2.coinmarketcap.com/static/img/coins/32x32/1765.png");
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = convertView;

        lInflater = (LayoutInflater) parent.getContext()
                .getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = lInflater.inflate(R.layout.coin_bag_view1, parent, false);
        }




        txtTokenName = view.findViewById(R.id.txtTokenName);
        txtTokenBalance = view.findViewById(R.id.txtTokenBalance);
        txtUsd = view.findViewById(R.id.txtTokenUsdBalance);
        txtProfit = view.findViewById(R.id.txtTokenProfit);

        txtTokenName.setTextColor(view.getContext().getResources().getColor(R.color.colorTextDark));
        txtTokenBalance.setTextColor(view.getContext().getResources().getColor(R.color.colorTextDark));
        txtUsd.setTextColor(view.getContext().getResources().getColor(R.color.colorTextDark));
        txtProfit.setTextColor(view.getContext().getResources().getColor(R.color.colorTextDark));

        Token token = (Token) getItem(i);

        Picasso.with(view.getContext())
                .load(coinsLogos.get(token.getName()))
                .resize(32,32)
                .transform(new CropCircleTransformation())
                .centerCrop()
                .into((ImageView) view.findViewById(R.id.ivTokenLogo));

        txtTokenName.setText(token.getName());
        if(String.valueOf(token.getBallance()).length()>7){
            txtTokenBalance.setText(roundResult1(token.getBallance()));
        }else txtTokenBalance.setText(String.valueOf(token.getBallance()));

        double usd = 0.0;

        if(token.getName().equals("BTC")){
            usd = Double.parseDouble(exmo.getBTCUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getBTCUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("LTC")){
            usd = Double.parseDouble(exmo.getLTCUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getLTCUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("ETH")){
            usd = Double.parseDouble(exmo.getETHUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getETHUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("XRP")){
            usd = Double.parseDouble(exmo.getXRPUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getXRPUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("ETC")){
            usd = Double.parseDouble(exmo.getETCUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getETCUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("XMR")){
            usd = Double.parseDouble(exmo.getXMRUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getXMRUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("DASH")){
            usd = Double.parseDouble(exmo.getDASHUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getDASHUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("DOGE")){
            double btc = Double.parseDouble(exmo.getDOGEBTC().getBuyPrice())*token.getBallance();
            usd = btc*Double.parseDouble(exmo.getBTCUSD().getAvg());
            double usdPrice = Double.parseDouble(exmo.getDOGEBTC().getAvg())*Double.parseDouble(exmo.getBTCUSD().getAvg());
            txtProfit.setText(calcProfit(usdPrice,token.getPrice()));
        }
        if(token.getName().equals("BCH")){
            usd = Double.parseDouble(exmo.getBCHUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getBCHUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("USDT")){
            usd = Double.parseDouble(exmo.getUSDTUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getUSDTUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("ZEC")){
            usd = Double.parseDouble(exmo.getZECUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getZECUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("KICK")){
            double btc = Double.parseDouble(exmo.getKICKBTC().getBuyPrice())*token.getBallance();
            usd = btc*Double.parseDouble(exmo.getBTCUSD().getAvg());
            double usdPrice = Double.parseDouble(exmo.getKICKBTC().getAvg())*Double.parseDouble(exmo.getBTCUSD().getAvg());
            txtProfit.setText(calcProfit(usdPrice,token.getPrice()));
        }
        if(token.getName().equals("WAVES")){
            double btc = Double.parseDouble(exmo.getWAVESBTC().getBuyPrice())*token.getBallance();
            usd = btc*Double.parseDouble(exmo.getBTCUSD().getAvg());
            double usdPrice = Double.parseDouble(exmo.getWAVESBTC().getAvg())*Double.parseDouble(exmo.getBTCUSD().getAvg());
            txtProfit.setText(calcProfit(usdPrice,token.getPrice()));
        }
        if(token.getName().equals("HBZ")){
            usd = Double.parseDouble(exmo.getHBZUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getHBZUSD().getBuyPrice()),token.getPrice()));
        }
        if(token.getName().equals("EOS")){
            usd = Double.parseDouble(exmo.getEOSUSD().getBuyPrice())*token.getBallance();
            txtProfit.setText(calcProfit(Double.parseDouble(exmo.getEOSUSD().getBuyPrice()),token.getPrice()));
        }

        txtUsd.setText(roundResult(usd));
        return view;
    }



    private String calcProfit(double buyNew, double myBuy) {
        double profit;
        if (buyNew>myBuy){
            profit = buyNew*100/myBuy-100;
            return "+"+roundResult(profit)+"%";
        }
        if (buyNew<myBuy){
            profit = buyNew*100/myBuy-100;
            return roundResult(profit)+"%";
        }
        return "0%";
    }

    String roundResult(double d) {
        return String.format("%.2f", d);
    }
    String roundResult1(double d) {
        return String.format("%.4f", d);
    }
}
