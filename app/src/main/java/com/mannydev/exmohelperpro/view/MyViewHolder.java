package com.mannydev.exmohelperpro.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mannydev.exmohelperpro.model.Coin;


/**
 * Created by manny on 10.02.18.
 */

public abstract class MyViewHolder extends RecyclerView.ViewHolder {
    public MyViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBindCoinHolder(Coin coin);
}
