package com.example.iskandar.projectpalali.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.iskandar.projectpalali.DetailUUActivity;
import com.example.iskandar.projectpalali.ItemClickListener;
import com.example.iskandar.projectpalali.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ListViewAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    //FIELDS TO STORE PASSED IN VALUES
    String[] tentang;
    String[] uu;
    String[] pasal;
    String[] ayat;
    int[] images;

    ArrayList<ListUU> mItems, filterlist;
    Context context;

    public ListViewAdapter(Context context, ArrayList<ListUU> mItems) {
        this.context = context;
        this.mItems = mItems;
        this.filterlist = mItems;
    }

//    public ListViewAdapter(Context ctx, String[] uu, String[] tentang, String[] pasal, String[] ayat, int[] images) {
//        //ASSIGN THEM
//        this.context = ctx;
//        this.uu = uu;
//        this.tentang = tentang;
//        this.pasal = pasal;
//        this.ayat = ayat;
//        this.images = images;
//    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //INFLATE A VIEW FROM XML
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, null);

        //HOLDER
        MyHolder holder = new MyHolder(v);
        return holder;
    }


    //DATA IS BEING BOUND TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        //BIND DATA
        holder.tentang.setText(mItems.get(position).getTentang());
        holder.uu.setText(mItems.get(position).getUu());
        holder.pasal.setText(mItems.get(position).getPasal());
        holder.ayat.setText(mItems.get(position).getAyat());
        holder.img.setImageResource(mItems.get(position).getGambar());

        //WHEN ITEM IS CLICKED
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int gambar) {

                //INTENT OBJ
                Intent i = new Intent(context, DetailUUActivity.class);

                //ADD DATA TO OUR INTENT
                i.putExtra("UU", mItems.get(position).getUu());
                i.putExtra("Tentang", mItems.get(position).getTentang());
                i.putExtra("Pasal", mItems.get(position).getPasal());
                i.putExtra("Ayat", mItems.get(position).getAyat());
                i.putExtra("Images", mItems.get(position).getGambar());

                //START DETAIL ACTIVITY
                context.startActivity(i);
            }
        });
    }

    //TOTAL PLAYERS
    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public Filter getFilter() {
        CustomFilterList filter = new CustomFilterList(this, filterlist);
        return filter;
    }
}
