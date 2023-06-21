package com.example.sqlexample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sqlexample.R;
import com.example.sqlexample.adapter.SinhvienAdapter;
import com.example.sqlexample.db.DatabaseHelper;

public class DanhsachSVMainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach_svmain);
        rv = findViewById(R.id.sv_rv);
        DatabaseHelper db = new DatabaseHelper(this);
        SinhvienAdapter adapter = new SinhvienAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rv.setLayoutManager(linearLayoutManager);

        adapter.setData(db.getAllSinhvien());
        rv.setAdapter(adapter);


    }
}