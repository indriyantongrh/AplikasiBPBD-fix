package com.universedeveloper.aplikasibpbd.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.universedeveloper.aplikasibpbd.Detail.DetailArtikel;
import com.universedeveloper.aplikasibpbd.Model.ModelBerita;
import com.universedeveloper.aplikasibpbd.R;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.ViewHolder> implements Filterable {
    private ArrayList<ModelBerita> mArrayList;
    private ArrayList<ModelBerita> mFilteredList;
    private Context context;

    public AdapterBerita(Context context, ArrayList<ModelBerita> arrayList) {
        this.context = context;
        this.mArrayList = arrayList;
        this.mFilteredList = arrayList;

    }

    @Override
    public AdapterBerita.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_adapter_berita, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterBerita.ViewHolder viewHolder, int i) {

        viewHolder.txtjudulberita.setText(mFilteredList.get(i).getTitle());
        Glide.with(context)
                .load("http://bpbd.semarangkota.go.id/po-content/uploads/"+mFilteredList.get(i).getPicture())
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .into(viewHolder.picpost);


        viewHolder.txt_id_post.setText((mFilteredList.get(i).getId_post()));
        viewHolder.txt_time.setText(mFilteredList.get(i).getTime());
        viewHolder.txt_editor.setText(mFilteredList.get(i).getEditor());
        viewHolder.txt_active.setText(mFilteredList.get(i).getActive());
        viewHolder.txt_headline.setText(mFilteredList.get(i).getHeadline());
        viewHolder.txt_picture.setText("http://bpbd.semarangkota.go.id/po-content/uploads/"+mFilteredList.get(i).getPicture());
        viewHolder.txt_picture_description.setText(mFilteredList.get(i).getPicture_description());
        viewHolder.txt_id_language.setText(mFilteredList.get(i).getId_language());
        viewHolder.txt_content.setText(mFilteredList.get(i).getContent());

        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd-MMM-yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(mFilteredList.get(i).getDate());
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        viewHolder.txtdate.setText(str);
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
        //return mFilteredList == null ? 0 : mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<ModelBerita> filteredList = new ArrayList<>();

                    for (ModelBerita androidVersion : mArrayList) {

                        if (androidVersion.getTitle().toLowerCase().contains(charString)) {
                            filteredList.add(androidVersion);
                        }
                    }
                    mFilteredList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<ModelBerita>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtjudulberita, txtdate,
                txt_id_post, txt_time, txt_editor, txt_active, txt_headline, txt_picture, txt_picture_description, txt_id_language, txt_content;
        private ImageView picpost;

        public ViewHolder(View view) {
            super(view);

            txtjudulberita = view.findViewById(R.id.txtjudulberita);
            txtdate = view.findViewById(R.id.txtdate);
            txt_id_post = view.findViewById(R.id.txt_id_post);
            txt_time = view.findViewById(R.id.txt_time);
            txt_editor = view.findViewById(R.id.txt_editor);
            picpost = view.findViewById(R.id.picpost);

            txt_active = view.findViewById(R.id.txt_active);
            txt_headline = view.findViewById(R.id.txt_headline);
            txt_picture = view.findViewById(R.id.txt_picture);

            txt_picture_description = view.findViewById(R.id.txt_picture_description);
            txt_id_language = view.findViewById(R.id.txt_id_language);
            txt_content = view.findViewById(R.id.txt_content);

            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view ) {
            Intent detail = new Intent(view.getContext(), DetailArtikel.class);
            detail.putExtra("title", txtjudulberita.getText());
            detail.putExtra("date", txtdate.getText());
            detail.putExtra("content", txt_content.getText());
//

            detail.putExtra("picture", txt_picture.getText());
//            detail.putExtra("kategori", txt_kategori.getText());
//            detail.putExtra("deskripsi", txt_deskripsi.getText());
//
//            detail.putExtra("foto_1", txt_foto_1.getText());
//            detail.putExtra("foto_2", txt_foto_2.getText());
//            detail.putExtra("foto_3", txt_foto_3.getText());
//            detail.putExtra("video", txt_video.getText());
//            detail.putExtra("alamat", txt_alamat.getText());
//            detail.putExtra("latitude", txt_latitude.getText());
//            detail.putExtra("longitude", txt_longitude.getText());
//            detail.putExtra("jam_postung", txt_jam_posting.getText().toString());

            view.getContext().startActivity(detail);
        }
    }
}