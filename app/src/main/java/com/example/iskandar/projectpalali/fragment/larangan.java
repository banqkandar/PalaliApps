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
import android.widget.SearchView;
import android.widget.Toast;

import com.example.iskandar.projectpalali.Adapter.GridAdapterLarangan;
import com.example.iskandar.projectpalali.Adapter.GridAdapterPeringatan;
import com.example.iskandar.projectpalali.Adapter.Item;
import com.example.iskandar.projectpalali.R;

import java.util.ArrayList;

public class larangan extends Fragment {
    RecyclerView mRecyclerView;
    androidx.appcompat.widget.SearchView searchView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.larangan_page, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        searchView = (androidx.appcompat.widget.SearchView) view.findViewById(R.id.cari_larangan);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        final GridAdapterLarangan mAdapter = new GridAdapterLarangan(getActivity(), preparedData());
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
        return view;
    }

    private ArrayList<Item> preparedData() {

        ArrayList<Item> arrayList = new ArrayList<Item>();
        Item nama = new Item();
        nama.setName("Dilarang Belok Kanan");
        nama.setThumbnail(R.drawable.l_dilarang_belok_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang Belok Kiri");
        nama.setThumbnail(R.drawable.l_dilarang_belok_kiri);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang Berhenti");
        nama.setThumbnail(R.drawable.l_dilarang_berhenti);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang Berjalan Terus");
        nama.setThumbnail(R.drawable.l_dilarang_berjalan_terus);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang masuk becak");
        nama.setThumbnail(R.drawable.l_dilarang_masuk_bagi_becak);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang masuk mobil dan motor");
        nama.setThumbnail(R.drawable.l_dilarang_masuk_bagi_motor_dan_mobil);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang masuk pejalan kaki");
        nama.setThumbnail(R.drawable.l_dilarang_masuk_bagi_pejalan_kaki);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang masuk sepeda");
        nama.setThumbnail(R.drawable.l_dilarang_masuk_bagi_sepeda);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang masuk kendaraan umum");
        nama.setThumbnail(R.drawable.l_dilarang_masuk_kendaraan_umum);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang masuk mobil penumpang");
        nama.setThumbnail(R.drawable.l_dilarang_masuk_mobil_penumpang);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang masuk motor tidak dari 2 arah");
        nama.setThumbnail(R.drawable.l_dilarang_masuk_motor_tidak_dari_kedua_arah);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang masuk sepeda dan becak");
        nama.setThumbnail(R.drawable.l_dilarang_masuk_sepeda_dan_becak);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang masuk sepeda motor");
        nama.setThumbnail(R.drawable.l_dilarang_masuk_sepeda_motor);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang membunyikan isyarat suara");
        nama.setThumbnail(R.drawable.l_dilarang_membunyikan_isyarat_suara);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang memutar balik");
        nama.setThumbnail(R.drawable.l_dilarang_memutar_balik);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang memutar balik dan belok kanan");
        nama.setThumbnail(R.drawable.l_dilarang_memutar_balik_dan_belok_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang mengemudi dengan kecepatan 50KM");
        nama.setThumbnail(R.drawable.l_dilarang_mengemudi_dengan_kecepatan_lima_puluh_km);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang menyalip kendaraan lain");
        nama.setThumbnail(R.drawable.l_dilarang_menyalip_kendaraan_lain);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang Parkir");
        nama.setThumbnail(R.drawable.l_dilarang_parkir);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang masuk");
        nama.setThumbnail(R.drawable.l_ilarang_masuk);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dilarang jalan terus");
        nama.setThumbnail(R.drawable.l_larangan_jalan_terus_di_bagian_jalan_tertentu);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib berhenti");
        nama.setThumbnail(R.drawable.l_wajib_berhenti);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Wajib membayar tarif Tol");
        nama.setThumbnail(R.drawable.l_wajib_membayar_tarif_tol);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("wajib memberi prioritas");
        nama.setThumbnail(R.drawable.l_wajib_memberi_prioritas);
        arrayList.add(nama);

        return arrayList;
    }
}
