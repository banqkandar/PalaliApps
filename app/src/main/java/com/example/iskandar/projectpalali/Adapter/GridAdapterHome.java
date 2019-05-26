package com.example.iskandar.projectpalali.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.iskandar.projectpalali.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class GridAdapterHome extends RecyclerView.Adapter<GridAdapterHome.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private Context mContext;

    List<Item> mItems;

    public GridAdapterHome() {
        super();
        mItems = new ArrayList<Item>();
        Item nama = new Item();
        nama.setName("Dilarang Parkir");
        nama.setThumbnail(R.drawable.l_dilarang_parkir);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Dilarang Belok Kanan");
        nama.setThumbnail(R.drawable.l_dilarang_belok_kanan);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Dilarang Belok Kiri");
        nama.setThumbnail(R.drawable.l_dilarang_belok_kiri);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Dilarang Berhenti");
        nama.setThumbnail(R.drawable.l_dilarang_berhenti);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Dilarang Putar Balik");
        nama.setThumbnail(R.drawable.l_dilarang_memutar_balik);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Wajib Berhenti");
        nama.setThumbnail(R.drawable.l_wajib_berhenti);
        mItems.add(nama);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_horizontal, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        Item nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;
        public TextView tvspecies;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.image_view);
            tvspecies = (TextView)itemView.findViewById(R.id.name);

        }
    }
}

