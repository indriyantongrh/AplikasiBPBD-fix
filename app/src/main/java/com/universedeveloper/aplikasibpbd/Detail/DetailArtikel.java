package com.universedeveloper.aplikasibpbd.Detail;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.universedeveloper.aplikasibpbd.Adapter.AdapterBerita;
import com.universedeveloper.aplikasibpbd.Api.JSONResponse;
import com.universedeveloper.aplikasibpbd.Api.RequestInterface;
import com.universedeveloper.aplikasibpbd.Beranda.FragmentBeranda;
import com.universedeveloper.aplikasibpbd.BuildConfig;
import com.universedeveloper.aplikasibpbd.Model.ModelBerita;
import com.universedeveloper.aplikasibpbd.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import org.sufficientlysecure.htmltextview.HtmlTextView;
public class DetailArtikel extends AppCompatActivity {

    public static final String BASE_URL = BuildConfig.BASE_URL;
    private ArrayList<ModelBerita> mArrayList;
    AdapterBerita adapterBerita;
    RecyclerView Rv_berita;

    private ArrayList<ModelBerita> mFilteredList;
    private Context context;
    Button btn_kembali;
    TextView txtjudulberita;
    TextView txtdate;
    TextView txthits;
    TextView txtdetailberita1;
    HtmlTextView txtdetailberita;
    ImageView picpost;
    TextView txt_picture_description;
    String id_post,date, time, active, editor, headline, picture, picture_description, id_language,title,content, id_category;

    String RemoveTag(String html){
        html = html.replaceAll("\\<.*?>","");
        html = html.replaceAll("&nbsp;","");
        html = html.replaceAll("&amp;","");

        return html;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel);


        ////////////////////////////////////// data lowongan
       id_post = getIntent().getStringExtra("id_post");
       active = getIntent().getStringExtra("active");
        id_category = getIntent().getStringExtra("id_category");
        id_language = getIntent().getStringExtra("id_language");


        txtjudulberita = findViewById(R.id.txtjudulberita);
        txtdate =  findViewById(R.id.txtdate);
        txtdetailberita1 = findViewById(R.id.txtdetailberita1);
        picpost = findViewById(R.id.picpost);
        txt_picture_description = findViewById(R.id.txt_picture_description);




        txtjudulberita.setText(getIntent().getStringExtra("title"));
        txtdate.setText(getIntent().getStringExtra("date"));
        txtdetailberita1.setText (Html.fromHtml(getIntent().getStringExtra("content")),TextView.BufferType.SPANNABLE);
        ///txtdetailberita.setHtml ((getIntent().getStringExtra("content")));Spannable.SPAN_EXCLUSIVE_EXCLUSIVE

       /// picpost.setImageResource(Integer.parseInt(getIntent().getStringExtra("picture")));
        picture = getIntent().getStringExtra("picture");
        Glide.with(DetailArtikel.this)
                .load(picture)
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .into(picpost);



        Button btnkembali = (Button) findViewById(R.id.btn_kembali);
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              onBackPressed();
              return ;
            }
        });

    }



}
