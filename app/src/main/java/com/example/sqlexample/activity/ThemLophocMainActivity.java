package com.example.sqlexample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqlexample.R;
import com.example.sqlexample.db.DatabaseHelper;
import com.example.sqlexample.model.Lophoc;
import com.example.sqlexample.model.Sinhvien;

public class ThemLophocMainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_lophoc_main);
        editText1 = findViewById(R.id.tenlophoc);
        editText2 = findViewById(R.id.motalop);
        button = findViewById(R.id.themlophoc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                db.addlophoc(new Lophoc(editText1.getText().toString(),editText2.getText().toString()));
                finish();
            }
        });
    }
}