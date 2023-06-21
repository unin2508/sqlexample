package com.example.sqlexample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqlexample.R;
import com.example.sqlexample.db.DatabaseHelper;
import com.example.sqlexample.model.Sinhvien;

public class ThemSinhVienMainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sinh_vien_main);
        editText1 = findViewById(R.id.tensv);
        editText2 = findViewById(R.id.namsinhsv);
        editText3 = findViewById(R.id.quequansv);
        editText4 = findViewById(R.id.namhocsv);
        button = findViewById(R.id.themsv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                int namhoc = Integer.parseInt(String.valueOf(editText4.getText()));
                db.addSV(new Sinhvien(editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),namhoc));
                finish();
            }
        });

    }
}