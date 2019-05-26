package com.example.iskandar.projectpalali.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iskandar.projectpalali.Adapter.Item;
import com.example.iskandar.projectpalali.Adapter.ListUU;
import com.example.iskandar.projectpalali.Adapter.ListViewAdapter;
import com.example.iskandar.projectpalali.R;

import java.util.ArrayList;

public class uuRambu extends Fragment {

    androidx.appcompat.widget.SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.uurambu_page, container, false);
        //REFERENCE RECYCLER
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recyclerViewUU);
        searchView = (androidx.appcompat.widget.SearchView) rootView.findViewById(R.id.cari_list_uu);

        //SET PROPERTIES
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        final ListViewAdapter adapter = new ListViewAdapter(getActivity(), preparedData());
        rv.setAdapter(adapter);

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return rootView;
    }

    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<ListUU> preparedData() {
        ArrayList<ListUU> arrayList = new ArrayList<>();
        ListUU p = new ListUU();
        p.setUu("Undang-undang No.22 Tahun 2009");
        p.setTentang("Tentang Surat Izin Mengemudi");
        p.setPasal("Pasal 281");
        p.setAyat("Setiap orang yang mengemudikan Kendaraan Bermotor di Jalan yang tidak memiliki Surat Izin Mengemudi sebagaimana dimaksud dalam Pasal 77 ayat (1) dipidana dengan pidana kurungan paling lama 4 (empat) bulan atau denda paling banyak Rp1.000.000,00 (satu juta rupiah). Undang-undang No.22 Tahun 2009, Pasal 281");
        p.setGambar(R.drawable.sim);
        arrayList.add(p);

        p = new ListUU();
        p.setUu("Undang-undang No.22 Tahun 2009");
        p.setTentang("Tentang Surat Tanda Nomor Kendaraan Bermotor");
        p.setPasal("Pasal 288");
        p.setAyat("Setiap orang yang mengemudikan Kendaraan Bermotor di Jalan yang tidak dilengkapi dengan Surat Tanda Nomor Kendaraan Bermotor atau Surat Tanda Coba Kendaraan Bermotor yang ditetapkan oleh Kepolisian Negara Republik Indonesia sebagaimana dimaksud dalam Pasal 106 ayat (5) huruf a dipidana dengan pidana kurungan paling lama 2 (dua) bulan atau denda paling banyak Rp500.000,00 (lima ratus ribu rupiah). Undang-undang No.22 Tahun 2009, Pasal 288.");
        p.setGambar(R.drawable.stnk);
        arrayList.add(p);

        p = new ListUU();
        p.setUu("Undang-undang No.22 Tahun 2009");
        p.setTentang("Tentang Tidak Pasang Plat Nomor");
        p.setPasal("Pasal 280");
        p.setAyat("Setiap orang yang mengemudikan Kendaraan Bermotor di Jalan yang tidak dipasangi Tanda Nomor Kendaraan Bermotor yang ditetapkan oleh Kepolisian Negara Republik Indonesia sebagaimana dimaksud dalam Pasal 68 ayat (1) dipidana dengan pidana kurungan paling lama 2 (dua) bulan atau denda paling banyak Rp500.000,00 (lima ratus ribu rupiah). Undang-undang No.22 Tahun 2009, Pasal 280.");
        p.setGambar(R.drawable.plat);
        arrayList.add(p);

        p = new ListUU();
        p.setUu("Undang-undang No.22 Tahun 2009");
        p.setTentang("Tentang Tidak memenuhi persyaratan teknis");
        p.setPasal("Pasal 285");
        p.setAyat("(1) Setiap orang yang mengemudikan Sepeda Motor di Jalan yang tidak memenuhi persyaratan teknis dan laik jalan yang meliputi kaca spion, klakson, lampu utama, lampu rem, lampu penunjuk arah, alat pemantul cahaya, alat pengukur kecepatan, knalpot, dan kedalaman alur ban sebagaimana dimaksud dalam Pasal 106 ayat (3) juncto Pasal 48 ayat (2) dan ayat (3) dipidana dengan pidana kurungan paling lama 1 (satu) bulan atau denda paling banyak Rp250.000,00 (dua ratus lima puluh ribu rupiah).\n (2) Setiap orang yang mengemudikan Kendaraan Bermotor beroda empat atau lebih di Jalan yang tidak memenuhi persyaratan teknis yang meliputi kaca spion, klakson, lampu utama, lampu mundur, lampu tanda batas dimensi badan kendaraan, lampu gandengan, lampu rem, lampu penunjuk arah, alat pemantul cahaya, alat pengukur kecepatan, kedalaman alur ban, kaca depan, spakbor, bumper, penggandengan, penempelan, atau penghapus kaca sebagaimana dimaksud dalam Pasal 106 ayat (3) juncto Pasal 48 ayat (2) dipidana dengan pidana kurungan paling lama 2 (dua) bulan atau denda paling banyak Rp500.000,00 (lima ratus ribu rupiah). Undang-undang No.22 Tahun 2009, Pasal 285.");
        p.setGambar(R.drawable.spion);
        arrayList.add(p);

        p = new ListUU();
        p.setUu("Undang-undang No.22 Tahun 2009");
        p.setTentang("Tentang Kendaraan Bermotor beroda empat");
        p.setPasal("Pasal 278");
        p.setAyat("Setiap orang yang mengemudikan Kendaraan Bermotor beroda empat atau lebih di Jalan yang tidak dilengkapi dengan perlengkapan berupa ban cadangan, segitiga pengaman, dongkrak, pembuka roda, dan peralatan pertolongan pertama pada kecelakaan sebagaimana dimaksud dalam Pasal 57 ayat (3) dipidana dengan pidana kurungan paling lama 1 (satu) bulan atau denda paling paling banyak Rp250.000,00 (dua ratus lima puluh ribu rupiah). Undang-undang No.22 Tahun 2009, Pasal 278.");
        p.setGambar(R.drawable.mobil);
        arrayList.add(p);

        p = new ListUU();
        p.setUu("Undang-undang No.22 Tahun 2009");
        p.setTentang("Tentang Melanggar aturan batas kecepatan");
        p.setPasal("Pasal 287");
        p.setAyat("Setiap orang yang mengemudikan Kendaraan Bermotor di Jalan yang melanggar aturan batas kecepatan paling tinggi atau paling rendah sebagaimana dimaksud dalam Pasal 106 ayat (4) huruf g atau Pasal 115 huruf a dipidana dengan pidana kurungan paling lama 2 (dua) bulan atau denda paling banyak Rp500.000,00 (lima ratus ribu rupiah). Undang-undang No.22 Tahun 2009, Pasal 287.");
        p.setGambar(R.drawable.kecepatan);
        arrayList.add(p);

        p = new ListUU();
        p.setUu("Undang-undang No.22 Tahun 2009");
        p.setTentang("Tentang Tidak mengenakan sabuk");
        p.setPasal("Pasal 289");
        p.setAyat("Setiap orang yang mengemudikan Kendaraan Bermotor atau Penumpang yang duduk di samping Pengemudi yang tidak mengenakan sabuk keselamatan sebagaimana dimaksud dalam Pasal 106 ayat (6) dipidana dengan pidana kurungan paling lama 1 (satu) bulan atau denda paling banyak Rp250.000,00 (dua ratus lima puluh ribu rupiah). Undang-undang No.22 Tahun 2009, Pasal 289.");
        p.setGambar(R.drawable.sabuk);
        arrayList.add(p);

        p = new ListUU();
        p.setUu("Undang-undang No.22 Tahun 2009");
        p.setTentang("Tentang Tidak menyalakan lampu utama pada malam hari");
        p.setPasal("Pasal 293");
        p.setAyat("(1) Setiap orang yang mengemudikan Kendaraan Bermotor di Jalan tanpa menyalakan lampu utama pada malam hari dan kondisi tertentu sebagaimana dimaksud dalam Pasal 107 ayat (1) dipidana dengan pidana kurungan paling lama 1 (satu) bulan atau denda paling banyak Rp250.000,00 (dua ratus lima puluh ribu rupiah).\n  (2) Setiap orang yang mengemudikan Sepeda Motor di Jalan tanpa menyalakan lampu utama pada siang hari sebagaimana dimaksud dalam Pasal 107 ayat (2) dipidana dengan pidana kurungan paling lama 15 (lima belas) hari atau denda paling banyak Rp100.000,00 (seratus ribu rupiah). Undang-undang No.22 Tahun 2009, Pasal 293.");
        p.setGambar(R.drawable.lampu);
        arrayList.add(p);

        p = new ListUU();
        p.setUu("Undang-undang No.22 Tahun 2009");
        p.setTentang("Tentang Sepeda Motor Tidak memakai Helm");
        p.setPasal("Pasal 291");
        p.setAyat("(1). Setiap orang yang mengemudikan Sepeda Motor tidak mengenakan helm standar nasional Indonesia sebagaimana dimaksud dalam Pasal 106 ayat (8) dipidana dengan pidana kurungan paling lama 1 (satu) bulan atau denda paling banyak Rp250.000,00 (dua ratus lima puluh ribu rupiah). \n" +
                "(2). Setiap orang yang mengemudikan Sepeda Motor yang membiarkan penumpangnya tidak mengenakan helm sebagaimana dimaksud dalam Pasal 106 ayat (8) dipidana dengan pidana kurungan paling lama 1. Undang-undang No.22 Tahun 2009, Pasal 291.");
        p.setGambar(R.drawable.helm);
        arrayList.add(p);

        p = new ListUU();
        p.setUu("Undang-undang No.22 Tahun 2009");
        p.setTentang("Tentang Kendaraan Bermotor berbalapan di jalan");
        p.setPasal("Pasal 297");
        p.setAyat("Setiap orang yang mengemudikan Kendaraan Bermotor berbalapan di Jalan sebagaimana dimaksud dalam Pasal 115 huruf b dipidana dengan pidana kurungan paling lama 1 (satu) tahun atau denda paling banyak Rp 3.000.000,00 (tiga juta rupiah). Undang-undang No.22 Tahun 2009, Pasal 297.");
        p.setGambar(R.drawable.balapan);
        arrayList.add(p);

        return arrayList;
    }
}

