package com.example.thuanhuynh.ktgiuaky;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by thuanhuynh on 4/3/18.
 */

public class CustomAdapter extends ArrayAdapter<HocVien> {
    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<HocVien> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.layout_list_view,null);
        }

        HocVien hv = getItem(position);
        if (hv!=null){
            ImageView img = (ImageView)v.findViewById(R.id.imageView2);
            if (hv.gethinhThuc()==0){
                img.setImageResource(R.drawable.chi);
            }else if (hv.gethinhThuc()==1){
                img.setImageResource(R.drawable.thu);
            }

            TextView tvNoiDung = (TextView)v.findViewById(R.id.tvnoidung);
            tvNoiDung.setText("Nội dung: "+hv.getnoiDung().toString());
            TextView tvSoTien = (TextView)v.findViewById(R.id.tvsotien);
            tvSoTien.setText("Số tiền: "+hv.getsoTien().toString());
            TextView tvHinhThuc = (TextView)v.findViewById(R.id.tvHinhThuc);
            if (hv.gethinhThuc()==0){
                tvHinhThuc.setText("Hình Thức: Chi");
            }else if (hv.gethinhThuc()==1){
                tvHinhThuc.setText("Hình Thức: Thu");
            }

        }
        return v;
    }
}
