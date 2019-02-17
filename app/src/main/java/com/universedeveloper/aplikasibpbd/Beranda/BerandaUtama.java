package com.universedeveloper.aplikasibpbd.Beranda;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
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

import com.universedeveloper.aplikasibpbd.R;


public class BerandaUtama extends Fragment {

    CardView btn_berita, btn_perkiraancuaca, btn_peringatandini, btn_infoaktual, btn_databencana, btn_bpbdtv, btn_laporbpbd, btn_chatwhatsapp;

    ConnectivityManager conMgr;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BerandaUtama() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BerandaUtama.
     */
    // TODO: Rename and change types and number of parameters
    public static BerandaUtama newInstance(String param1, String param2) {
        BerandaUtama fragment = new BerandaUtama();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_beranda_utama, container, false);

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


        btn_berita = view.findViewById(R.id.btn_berita);
        btn_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentBeranda(),null).addToBackStack(null);
                ft.commit();
            }

        });

        btn_perkiraancuaca = view.findViewById(R.id.btn_perkiraancuaca);
        btn_perkiraancuaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Fitur Perkiraan Cuaca segera hadir!", Toast.LENGTH_SHORT).show();
            }

        });
        btn_peringatandini = view.findViewById(R.id.btn_peringatandini);
        btn_peringatandini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Fitur Irly Warning Sistem  Dini segera hadir!", Toast.LENGTH_SHORT).show();
            }

        });
        btn_infoaktual = view.findViewById(R.id.btn_infoaktual);
        btn_infoaktual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Fitur Info Aktual segera hadir!", Toast.LENGTH_SHORT).show();
            }

        });
        btn_databencana = view.findViewById(R.id.btn_databencana);
        btn_databencana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Fitur Data Bencana segera hadir!", Toast.LENGTH_SHORT).show();
            }

        });
        btn_bpbdtv = view.findViewById(R.id.btn_bpbdtv);
        btn_bpbdtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Fitur BPBD TV segera hadir!", Toast.LENGTH_SHORT).show();
            }

        });

        btn_laporbpbd = view.findViewById(R.id.btn_laporbpbd);
        btn_laporbpbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Fitur Lapor BPBD segera hadir!", Toast.LENGTH_SHORT).show();
            }

        });
        btn_chatwhatsapp = view.findViewById(R.id.btn_chatwhatsapp);
        btn_chatwhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Fitur Chat Whatsapp segera hadir!", Toast.LENGTH_SHORT).show();
            }

        });
       //// onBackPressed();

        return view;

    }




    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                getActivity();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
