package com.example.sqlexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlexample.R;
import com.example.sqlexample.model.Sinhvien;

import java.util.List;

public class SinhvienAdapter extends RecyclerView.Adapter<SinhvienAdapter.SinhvienViewHolder> {

    private List<Sinhvien> sinhvienList;
    private Context context;

    public SinhvienAdapter(Context context){
        this.context = context;
    }

    public void setData(List<Sinhvien> sinhvienList){
        this.sinhvienList = sinhvienList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SinhvienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinhvien,parent,false);
        return new SinhvienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhvienViewHolder holder, int position) {
        Sinhvien sinhvien = sinhvienList.get(position);
        holder.textView1.setText(sinhvien.getMaSv().toString());
        holder.textView2.setText(sinhvien.getTen());
        holder.textView3.setText(sinhvien.getQuequan());
        holder.textView4.setText(sinhvien.getNamsinh());
        holder.textView5.setText(sinhvien.getNamhoc().toString());
    }

    @Override
    public int getItemCount() {
        return sinhvienList.size();
    }

    public class SinhvienViewHolder extends RecyclerView.ViewHolder  {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;

        public SinhvienViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.masv_tv);
            textView2 = itemView.findViewById(R.id.tensv_tv);
            textView3 = itemView.findViewById(R.id.quequansv_tv);
            textView4 = itemView.findViewById(R.id.namsinhsv_tv);
            textView5 = itemView.findViewById(R.id.namhocsv_tv);
        }
    }
}
