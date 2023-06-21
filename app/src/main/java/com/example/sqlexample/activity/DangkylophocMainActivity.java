package com.example.sqlexample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqlexample.R;
import com.example.sqlexample.db.DatabaseHelper;
import com.example.sqlexample.model.Lophoc;
import com.example.sqlexample.model.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class DangkylophocMainActivity extends AppCompatActivity {

    Button dangkybtn;
    EditText kyhocEt;
    EditText tinchiET;
    AutoCompleteTextView sinhvienAC;
    AutoCompleteTextView lophocAC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangkylophoc_main);
        dangkybtn = findViewById(R.id.dangky_btn);
        kyhocEt = findViewById(R.id.kyhoc_et);
        tinchiET = findViewById(R.id.tinchi_et);
        sinhvienAC = findViewById(R.id.picksv_ac);
        lophocAC = findViewById(R.id.picklophoc_ac);
        DatabaseHelper db = new DatabaseHelper(this);
        List<Sinhvien> sinhvienList = db.getAllSinhvien();
        List<Lophoc> lophocList = db.getAllLophoc();
        List<String> sinhvienStr = new ArrayList<>();
        List<String> lophocStr = new ArrayList<>();
        for (Sinhvien x : sinhvienList){
            sinhvienStr.add(x.toString());
        }
        for (Lophoc x : lophocList){
            lophocStr.add(x.toString());
        }
        ArrayAdapter<String> svAdapter = new ArrayAdapter<String>(this,R.layout.item_list,sinhvienStr);
        ArrayAdapter<String> lophocAdapter = new ArrayAdapter<String>(this,R.layout.item_list,lophocStr);
        sinhvienAC.setAdapter(svAdapter);
        lophocAC.setAdapter(lophocAdapter);
        List<Sinhvien> pickSV = new ArrayList<>();
        List<Lophoc> pickLH = new ArrayList<>();



        sinhvienAC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pickSV.add(sinhvienList.get(i));
            }
        });
        lophocAC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pickLH.add(lophocList.get(i));
            }
        });

        dangkybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.dangkylophoc(pickLH.get(0),pickSV.get(0),kyhocEt.getText().toString(),Integer.parseInt(tinchiET.getText().toString()));
                finish();
            }
        });




    }
}