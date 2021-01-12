package com.example.interfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void menu (View view){
        Toast.makeText(this, "producto modificado", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
        startActivityForResult(intent,0);


    }


}