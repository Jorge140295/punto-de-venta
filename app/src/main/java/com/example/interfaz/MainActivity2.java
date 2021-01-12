package com.example.interfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void menu (View view){
        Toast.makeText(this, "producto eliminado", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
        startActivityForResult(intent,0);


    }
}