package com.example.iskandar.projectpalali.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iskandar.projectpalali.Adapter.GridAdapterHome;
import com.example.iskandar.projectpalali.Adapter.GridAdapterHome2;
import com.example.iskandar.projectpalali.Adapter.GridAdapterHome3;
import com.example.iskandar.projectpalali.Adapter.GridAdapterPeringatan;
import com.example.iskandar.projectpalali.Adapter.GridAdapterPerintah;
import com.example.iskandar.projectpalali.R;

public class home extends Fragment {
    RecyclerView mRecyclerView, mRecyclerView2, mRecyclerView3;
    RecyclerView.Adapter mAdapter, mAdapter2, mAdapter3;
    RecyclerView.LayoutManager mLayoutManager,mLayoutManager2, mLayoutManager3;

    TextView tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewHome);
        mRecyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerViewHome2);
        mRecyclerView3 = (RecyclerView) view.findViewById(R.id.recyclerViewHome3);
//        mRecyclerView.setHasFixedSize(true);

        mLayoutManager  = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mLayoutManager2  = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mLayoutManager3  = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView2.setLayoutManager(mLayoutManager2);
        mRecyclerView3.setLayoutManager(mLayoutManager3);

        mAdapter = new GridAdapterHome();
        mAdapter2 = new GridAdapterHome2();
        mAdapter3 = new GridAdapterHome3();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView2.setAdapter(mAdapter2);
        mRecyclerView3.setAdapter(mAdapter3);

        TextView textView = (TextView) view.findViewById(R.id.Selengkapnya1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new larangan()).commit();
            }
        });

        TextView textView2 = (TextView) view.findViewById(R.id.Selengkapnya2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new peringatan()).commit();
            }
        });

        TextView textView3 = (TextView) view.findViewById(R.id.Selengkapnya3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new perintah()).commit();
            }
        });

        return view ;
    }
}
