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

import com.example.iskandar.projectpalali.Adapter.GridAdapterLarangan;
import com.example.iskandar.projectpalali.Adapter.GridAdapterPeringatan;
import com.example.iskandar.projectpalali.Adapter.Item;
import com.example.iskandar.projectpalali.R;

import java.util.ArrayList;

public class peringatan extends Fragment {
    RecyclerView mRecyclerView;
    androidx.appcompat.widget.SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.peringatan_page, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewPeringatan);
        searchView = (androidx.appcompat.widget.SearchView) view.findViewById(R.id.cari_peringatan);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        final GridAdapterPeringatan mAdapter = new GridAdapterPeringatan(getActivity(), preparedData());
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
        nama.setName("Jalan Sempit");
        nama.setThumbnail(R.drawable.pg_penyempitan_bagan_jalan_tertentu);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tanda Peringatan");
        nama.setThumbnail(R.drawable.pg_peringatan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Isyarat Lalu Lintas");
        nama.setThumbnail(R.drawable.pg_peringatan_alat_pemberi_isyarat_lalulintas);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Sebelah kanan rawan longsor");
        nama.setThumbnail(R.drawable.pg_peringatan_bagian_tepi_jalan_sebelah_kanan_rawan_rapuh);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Sebelah kiri rawan longsor");
        nama.setThumbnail(R.drawable.pg_peringatan_bagian_tepi_jalan_sebelah_kiri_rawan_rapuh);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Banyak Pejalan kaki");
        nama.setThumbnail(R.drawable.pg_peringatan_banyak_lalu_lintas_pejalan_kaki);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Banyak Anak-anak");
        nama.setThumbnail(R.drawable.pg_peringatan_banyak_lalu_lintas_pejalan_kaki_anak_anak);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Banyak Penyandang Cacat");
        nama.setThumbnail(R.drawable.pg_peringatan_banyak_lalu_lintas_penyandang_cacat);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Fasilitas Penyebrangan bagi Pejalan kaki");
        nama.setThumbnail(R.drawable.pg_peringatan_banyak_lalulintas_pejalan_kaki_menggunakan_fasilitas_penyebrangan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan ke kanan");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_ke_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan ke kiri");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_ke_kiri);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Bundaran dengan prioritas");
        nama.setThumbnail(R.drawable.pg_peringatan_bundaran_dengan_prioritas);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Dua Arah");
        nama.setThumbnail(R.drawable.pg_peringatan_lalu_lintas_dua_arah);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Lampu isyarat penyebrangan jalan");
        nama.setThumbnail(R.drawable.pg_peringatan_lampu_isyarat_penyebrang_jalan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Ada Lontaran kerikil");
        nama.setThumbnail(R.drawable.pg_peringatan_lontaran_kerikil);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Penyempitan badan jalan");
        nama.setThumbnail(R.drawable.pg_peringatan_penyempitan_badan_jalan_di_bagian_kiri_dan_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Permukaan Jalan Licin");
        nama.setThumbnail(R.drawable.pg_peringatan_permukaan_jalan_licin);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Persimpangan 3 sisi kanan");
        nama.setThumbnail(R.drawable.pg_peringatan_persimpangan_tiga_sisi_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Persimpangan 3 sisi kiri");
        nama.setThumbnail(R.drawable.pg_peringatan_persimpangan_tiga_sisi_kiri);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Persimpangan 3 tipe 'Y'");
        nama.setThumbnail(R.drawable.pg_peringatan_persimpangan_tiga_tipe_y);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Persimpangan 4");
        nama.setThumbnail(R.drawable.pg_peringatan_simpang_empat);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tanjakan Curam");
        nama.setThumbnail(R.drawable.pg_peringatan_tanjakan_curam);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tanjakan Landai");
        nama.setThumbnail(R.drawable.pg_peringatan_tanjakan_landai);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan ganda pertama ke kanan");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_ganda_dengan_tikungan_pertama_ke_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan ganda pertama ke kiri");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_ganda_dengan_tikungan_pertama_ke_kiri);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan ke kanan");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_ke_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan Memutar ke kanan");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_memutar_ke_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan Memutar ke kiri");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_memutar_ke_kiri);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan ganda tajam pertama ke kanan");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_tajam_ganda_dengan_tikungan_pertama_ke_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan ganda tajam pertama ke kiri");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_tajam_ganda_dengan_tikungan_pertama_ke_kiri);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan ganda tajam ke kanan");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_tajam_ke_kanan);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Tikungan ganda tajam ke kiri");
        nama.setThumbnail(R.drawable.pg_peringatan_tikungan_tajam_ke_kiri);
        arrayList.add(nama);

        nama = new Item();
        nama.setName("Turunan Curam");
        nama.setThumbnail(R.drawable.pg_peringatan_turunan_curam);
        arrayList.add(nama);

        return arrayList;
    }

}
