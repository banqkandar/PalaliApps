package com.example.iskandar.projectpalali.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iskandar.projectpalali.Adapter.GridAdapterPeringatan;
import com.example.iskandar.projectpalali.Adapter.GridAdapterPerintah;
import com.example.iskandar.projectpalali.Adapter.Item;
import com.example.iskandar.projectpalali.R;

import java.util.ArrayList;

public class perintah extends Fragment {
    RecyclerView mRecyclerView;
    androidx.appcompat.widget.SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.perintah_page, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewPerintah);
        searchView = (androidx.appcompat.widget.SearchView) view.findViewById(R.id.cari_perintah);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        final GridAdapterPerintah mAdapter = new GridAdapterPerintah(getActivity(), preparedData());
        mRecyclerView.setAdapter(mAdapter);

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return view ;
    }

    private ArrayList<Item> preparedData() {
        ArrayList<Item> arrayList = new ArrayList<Item>();
        Item nama = new Item();
        nama.setName("Wajib menurunkan kecepatan");
        nama.setThumbnail(R.drawable.pr_kecepatan_minimum_yang_diperintahkan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib Belok kanan");
        nama.setThumbnail(R.drawable.pr_perintah_belok_ke_arah_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib Belok kiri");
        nama.setThumbnail(R.drawable.pr_perintah_belok_ke_arah_kiri);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib jalan lurus");
        nama.setThumbnail(R.drawable.pr_perintah_berjalan_lurus);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Masuk pada jalur yang ditunjuk");
        nama.setThumbnail(R.drawable.pr_perintah_memasuki_jalur_atau_lajur_yang_di_tunjuk);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Memilih lurus atau belok kanan");
        nama.setThumbnail(R.drawable.pr_perintah_memilih_lurus_atau_belok_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Memilih lurus atau belok kiri");
        nama.setThumbnail(R.drawable.pr_perintah_memilih_lurus_atau_belok_kiri);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib menggunakan jalur bagi kendaraan umum");
        nama.setThumbnail(R.drawable.pr_perintah_menggunakan_jalur_atau_lajur_lalu_lintas_khusus_kendaraan_bermotor_umum);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib menggunakan jalur bagi kendaraan mobil barang");
        nama.setThumbnail(R.drawable.pr_perintah_menggunakan_jalur_atau_lajur_lalu_lintas_khusus_mobil_barang);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib menggunakan jalur bagi sepeda");
        nama.setThumbnail(R.drawable.pr_perintah_menggunakan_jalur_atau_lajur_lalu_lintas_khusus_sepeda);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib menggunakan jalur bagi sepeda motor");
        nama.setThumbnail(R.drawable.pr_perintah_menggunakan_jalur_atau_lajur_lalu_lintas_khusus_sepeda_motor);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib menggunakan jalur bagi pejalan kaki");
        nama.setThumbnail(R.drawable.pr_perintah_menggunakan_jalur_atau_lalu_lintas_khusus_pejalan_kaki);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib mengikuti arah kanan");
        nama.setThumbnail(R.drawable.pr_perintah_mengikuti_arah_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib mengikuti arah kiri");
        nama.setThumbnail(R.drawable.pr_perintah_mengikuti_arah_kiri);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Pilihan memasuki salah satu jalur");
        nama.setThumbnail(R.drawable.pr_perintah_pilihan_memasuki_salah_satu_jalur_atau_lajur_yang_ditunjuk);
        arrayList.add(nama);

        return arrayList;
    }

}

