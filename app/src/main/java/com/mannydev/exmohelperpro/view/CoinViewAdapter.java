package com.mannydev.exmohelperpro.view;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mannydev.exmohelperpro.R;
import com.mannydev.exmohelperpro.model.Coin;

import java.util.ArrayList;

/**
 * Created by manny on 16.01.18.
 */

public class CoinViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private static final int BITCOIN = 0;
    private static final int LITECOIN = 1;
    private static final int ETHERIUM = 3;
    private static final int DASH = 4;
    private static final int BCH = 5;
    private static final int XMR = 6;
    private static final int ALTCOIN = 7;
    private static final int WAVES = 8;
    private static final int KICK = 9;
    private static final int DOGE = 10;
    private static final int HBZ = 11;
    private static final int EOS = 12;
    ArrayList<Coin>list;


    public CoinViewAdapter() {

    }

    public void setData(ArrayList<Coin> list){
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType){
            case ALTCOIN:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.coin_view, parent, false);
                return new CoinViewHolder(v);

            case BITCOIN:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.bitcoin_view, parent, false);
                return new BitcoinViewHolder(v);
            case LITECOIN:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.litecoin_view, parent, false);
                return new LitecoinViewHolder(v);
            case ETHERIUM:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.etherium_view, parent, false);
                return new EtheriumViewHolder(v);
            case DASH:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.dashcoin_view, parent, false);
                return new DashViewHolder(v);
            case BCH:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.bitcoin_cash_view, parent, false);
                return new BitcoinCashViewHolder(v);
            case XMR:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.monero_view, parent, false);
                return new MoneroViewHolder(v);
            case WAVES:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.waves_view, parent, false);
                return new WavesViewHolder(v);
            case KICK:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.kick_view, parent, false);
                return new KickViewHolder(v);
            case DOGE:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.dogecoin_view, parent, false);
                return new DogecoinViewHolder(v);
            case HBZ:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.helbiz_view, parent, false);
                return new HelbizViewHolder(v);
            case EOS:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.eos_view, parent, false);
                return new EosViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Coin coin = list.get(position);
        holder.onBindCoinHolder(coin);
    }

    @Override
    public int getItemViewType(int position) {
        Coin coin = list.get(position);
        if(coin.getName().equals("BTC")){
            return BITCOIN;
        }else if (coin.getName().equals("LTC")||coin.getName().equals("ZEC")){
            return LITECOIN;
        }else if (coin.getName().equals("ETH")){
            return ETHERIUM;
        }
        else if (coin.getName().equals("DASH")||coin.getName().equals("XRP")||coin.getName().equals("ETC")){
            return DASH;
        }
        else if (coin.getName().equals("BCH")){
            return BCH;
        }
        else if (coin.getName().equals("XMR")){
            return XMR;
        }
        else if (coin.getName().equals("USDT")){
            return ALTCOIN;
        }
        else if (coin.getName().equals("WAVES")){
            return WAVES;
        }
        else if (coin.getName().equals("KICK")){
            return KICK;
        }
        else if (coin.getName().equals("DOGE")){
            return DOGE;
        }
        else if (coin.getName().equals("HBZ")){
            return HBZ;
        }
        else if (coin.getName().equals("EOS")){
            return EOS;
        }
        return ALTCOIN;
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }
}