package com.example.iskandar.projectpalali.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iskandar.projectpalali.ItemClickListener;
import com.example.iskandar.projectpalali.R;

import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    //OUR VIEWS
    TextView tentang, uu, pasal, ayat;
    ImageView img;
    private ItemClickListener itemClickListener;

    //our contructor
    public MyHolder(View itemView) {
        super(itemView);

        uu = (TextView) itemView.findViewById(R.id.uu);
        tentang = (TextView) itemView.findViewById(R.id.tentang);
        pasal = (TextView) itemView.findViewById(R.id.pasal);
        ayat = (TextView) itemView.findViewById(R.id.ayat);
        img = (ImageView) itemView.findViewById(R.id.gambarUU);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;

    }
}
