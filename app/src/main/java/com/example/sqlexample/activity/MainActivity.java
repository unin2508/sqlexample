package com.example.sqlexample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sqlexample.R;
import com.example.sqlexample.db.DatabaseHelper;
import com.example.sqlexample.model.SinhvienLophoc;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.getallsv);
        button2 = findViewById(R.id.addsv);
        button3 = findViewById(R.id.danhsachlophoc);
        button4 = findViewById(R.id.addlophoc);
        button5 = findViewById(R.id.dangkylophoc);
        button6 = findViewById(R.id.thongke);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DanhsachSVMainActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ThemSinhVienMainActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DanhSachLopHocMainActivity.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ThemLophocMainActivity.class);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DangkylophocMainActivity.class);
                startActivity(intent);
            }
        });
        List<SinhvienLophoc> sinhvienLophocList = new DatabaseHelper(getApplicationContext()).getAllLophocTinchi();
        for (SinhvienLophoc x : sinhvienLophocList){
            Log.d("debug",x.toString());
        }
    }
}