package com.example.iskandar.projectpalali.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iskandar.projectpalali.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class GridAdapterHome3 extends RecyclerView.Adapter<GridAdapterHome3.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private Context mContext;

    List<Item> mItems;

    public GridAdapterHome3() {
        super();
        mItems = new ArrayList<Item>();
        Item nama = new Item();
        nama.setName("Wajib Belok Kanan");
        nama.setThumbnail(R.drawable.pr_perintah_belok_ke_arah_kanan);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Wajib Belok Kiri");
        nama.setThumbnail(R.drawable.pr_perintah_belok_ke_arah_kiri);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Wajib Jalan Lurus");
        nama.setThumbnail(R.drawable.pr_perintah_berjalan_lurus);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Khusus Jalur Sepeda");
        nama.setThumbnail(R.drawable.pr_perintah_menggunakan_jalur_atau_lajur_lalu_lintas_khusus_sepeda);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Khusus Jalur Motor");
        nama.setThumbnail(R.drawable.pr_perintah_menggunakan_jalur_atau_lajur_lalu_lintas_khusus_sepeda_motor);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Khusus Pejalan Kaki");
        nama.setThumbnail(R.drawable.pr_perintah_menggunakan_jalur_atau_lalu_lintas_khusus_pejalan_kaki);
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

