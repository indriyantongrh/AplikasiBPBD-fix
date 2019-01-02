package com.universedeveloper.aplikasibpbd.Beranda;


import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.universedeveloper.aplikasibpbd.Adapter.AdapterBerita;
import com.universedeveloper.aplikasibpbd.Model.ModelBerita;
import com.universedeveloper.aplikasibpbd.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBeranda extends Fragment {

    RecyclerView Rv_berita;
    SwipeRefreshLayout swipeRefresh;
    ProgressBar progressBar;
    AdapterBerita adapterBerita;
    private FragmentBerandaPresenter presenter;

    Spinner spinner_kategori;
    String[] filter_kategori;
    ArrayAdapter adapter_filter_kategori;

    ConnectivityManager conMgr;

    public FragmentBeranda() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_beranda, container, false);

        conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
            } else {
                Toast.makeText(getContext(), "Tidak ada akses Internet",
                        Toast.LENGTH_LONG).show();
            }
        }


        presenter = new FragmentBerandaPresenter(this);

        Rv_berita = view.findViewById(R.id.Rv_berita);
        swipeRefresh = view.findViewById(R.id.swipeRefresh);
        progressBar = view.findViewById(R.id.progressBar);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.GetBerita();
            }
        });
        swipeRefresh.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);



        spinner_kategori = view.findViewById(R.id.spinner_kategori);
        filter_kategori = getResources().getStringArray(R.array.Kategori);
        adapter_filter_kategori = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, filter_kategori);
        adapter_filter_kategori.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_kategori.setAdapter(adapter_filter_kategori);

        spinner_kategori.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //((TextView) parentView.getChildAt(0)).setTextColor(Color.WHITE);
                if (spinner_kategori.getSelectedItem().equals("Berita")) {
                    presenter.id_category = "5";
                    presenter.id_language = "1";
                    presenter.active = "y";
                    initView();
                    presenter.GetBerita();
                } else if (spinner_kategori.getSelectedItem().equals("Indonesiaku")) {
                    presenter.id_category = "1";
                    presenter.id_language = "1";
                    presenter.active = "y";
                    initView();
                    presenter.GetBerita();
                } else if (spinner_kategori.getSelectedItem().equals("Motivasi")) {
                    presenter.id_category = "2";
                    presenter.id_language = "1";
                    presenter.active = "y";
                    initView();
                    presenter.GetBerita();
                } else if (spinner_kategori.getSelectedItem().equals("Kegiatan")) {
                    presenter.id_category = "4";
                    presenter.id_language = "1";
                    presenter.active = "y";
                    initView();
                    presenter.GetBerita();
                } else if (spinner_kategori.getSelectedItem().equals("Infografis")) {
                    presenter.id_category = "3";
                    presenter.id_language = "1";
                    presenter.active = "y";
                    initView();
                    presenter.GetBerita();
                } else {
                    presenter.id_category = "6";
                    presenter.id_language = "1";
                    presenter.active = "y";
                    initView();
                    presenter.GetBerita();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });



        return view;


    }



    private void initView() {
        Rv_berita.setHasFixedSize(true);
        //int numberOfColumns = 2;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        Rv_berita.setLayoutManager(layoutManager);
    }

    public void initJson(ArrayList<ModelBerita> mArrayList) {

        adapterBerita = new AdapterBerita(getActivity(), mArrayList);
        Rv_berita.setAdapter(adapterBerita);
        adapterBerita.notifyDataSetChanged();

    }







}
