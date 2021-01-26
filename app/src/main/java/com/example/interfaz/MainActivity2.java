package com.example.interfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText et1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1 = (EditText)findViewById(R.id.txt2);

    }
    public void menu (View view){
        Toast.makeText(this, "producto eliminado", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
        startActivityForResult(intent,0);

        BaseD bdD = new BaseD(this,"db1",null,1);
        SQLiteDatabase BaseDatos = bdD.getWritableDatabase();
        String codigo = et1.getText().toString();

        BaseDatos.delete("productos","codigo" + codigo, null);




    }
}