package com.universedeveloper.aplikasibpbd.Beranda;


import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.universedeveloper.aplikasibpbd.Api.JSONResponse;
import com.universedeveloper.aplikasibpbd.Api.RequestInterface;
import com.universedeveloper.aplikasibpbd.BuildConfig;
import com.universedeveloper.aplikasibpbd.Model.ModelBerita;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentBerandaPresenter {

    private FragmentBeranda view;
    public static final String BASE_URL = BuildConfig.BASE_URL;
    private ArrayList<ModelBerita> mArrayList;
    private RequestInterface requestInterface;
    String id_language, id_category, active;

    public FragmentBerandaPresenter(FragmentBeranda view) {
        this.view = view;
    }


    public void GetBerita(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        view.progressBar.setVisibility(android.view.View.VISIBLE);
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getBerita(id_language, id_category, active);
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                view.progressBar.setVisibility(android.view.View.INVISIBLE);
                view.swipeRefresh.setRefreshing(false);
                assert jsonResponse != null;
                mArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getBerita()));
                //mAdapter = new AdapterPencarianMenu(mArrayList);
                view.initJson(mArrayList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
                Toast.makeText(view.getActivity(), "Tidak ada informasi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
