package com.example.sqlexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlexample.R;
import com.example.sqlexample.model.Lophoc;

import java.util.List;

public class LophocAdapter extends RecyclerView.Adapter<LophocAdapter.LophocViewHolder> {

    private List<Lophoc> lophocList;
    private Context context;

    public LophocAdapter(Context context){
        this.context = context;
    }

    public void setUp(List<Lophoc> lophocList){
        this.lophocList = lophocList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LophocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lophoc,parent,false);
        return new LophocViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LophocViewHolder holder, int position) {
        holder.textView1.setText("3");
        holder.textView2.setText(this.lophocList.get(position).getTen().toString());
        holder.textView3.setText(this.lophocList.get(position).getMota().toString());
    }

    @Override
    public int getItemCount() {
        if (lophocList != null){
            return lophocList.size();
        } else {
            return 0;
        }

    }

    public class LophocViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public LophocViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.malophoc_tv);
            textView2= itemView.findViewById(R.id.tenlophoc_tv);
            textView3 = itemView.findViewById(R.id.motalop_tv);
        }
    }
}
