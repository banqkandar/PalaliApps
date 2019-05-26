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

public class GridAdapterHome2 extends RecyclerView.Adapter<GridAdapterHome2.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private Context mContext;

    List<Item> mItems;

    public GridAdapterHome2() {
        super();
        mItems = new ArrayList<Item>();
        Item nama = new Item();
        nama.setName("Tanda Peringatan");
        nama.setThumbnail(R.drawable.pg_peringatan);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Jalan Sempit");
        nama.setThumbnail(R.drawable.pg_penyempitan_bagan_jalan_tertentu);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Isyarat Lalu Lintas");
        nama.setThumbnail(R.drawable.pg_peringatan_alat_pemberi_isyarat_lalulintas);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Banyak Penyandang Cacat");
        nama.setThumbnail(R.drawable.pg_peringatan_banyak_lalu_lintas_penyandang_cacat);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Banyak Pejalan Kaki");
        nama.setThumbnail(R.drawable.pg_peringatan_banyak_lalulintas_pejalan_kaki_menggunakan_fasilitas_penyebrangan);
        mItems.add(nama);

        nama = new Item();
        nama.setName("Jalan Licin");
        nama.setThumbnail(R.drawable.pg_peringatan_permukaan_jalan_licin);
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

