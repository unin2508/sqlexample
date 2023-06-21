package com.example.sqlexample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.sqlexample.R;
import com.example.sqlexample.adapter.LophocAdapter;
import com.example.sqlexample.db.DatabaseHelper;
import com.example.sqlexample.model.Lophoc;

import java.util.List;

public class DanhSachLopHocMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_lop_hoc_main);
        recyclerView = findViewById(R.id.lophoc_rv);
        LophocAdapter adapter = new LophocAdapter(this);
        DatabaseHelper db = new DatabaseHelper(this);
        List<Lophoc> lophocList = db.getAllLophoc();
        for (Lophoc lophoc : lophocList){
            Log.d("debug",lophoc.toString());
        }

        adapter.setUp(lophocList);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }
}