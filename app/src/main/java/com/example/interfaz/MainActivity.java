package com.example.interfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    EditText et1;
    EditText et2;
    EditText et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.txt1);
        et1 = (EditText)findViewById(R.id.txt2);
        et2 = (EditText)findViewById(R.id.txt3);
        et3 = (EditText)findViewById(R.id.txt4);

        SharedPreferences  preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et.setText( preferences1.getString("nombre producto", "")  );
        et1.setText( preferences1.getString("codigo de barra", "") );
        et2.setText( preferences1.getString("precio proveedor", "") );
        et3.setText( preferences1.getString("precio unitario", "") );


    }
    public void menu (View view){
        BaseD bdD = new BaseD(this,"db1",null,1);
        SQLiteDatabase BaseDatos = bdD.getWritableDatabase();
        String codigo = et1.getText().toString();
        String nombre_producto = et.getText().toString();
        String precio_proveedor = et2.getText().toString();
        String precio_unitario = et3.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("codigo_de_barra",codigo);
        registro.put("nombre_producto",nombre_producto);
        registro.put("precio_proveedor",precio_proveedor);
        registro.put("codigo_de_barra",precio_unitario);

        BaseDatos.insert("productos",null,registro);
        BaseDatos.close();

        Toast.makeText(this, "producto agregado", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, MainActivity5.class);
        startActivityForResult(intent,0);

        //SharedPreferences  preferences = getSharedPreferences("dato", 0);
        SharedPreferences  preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences1.edit();

        String datosN = et.getText().toString();

        editor.putString("nombre", datosN);

        editor.commit();





    }
    public void mostrar(View view){

        SharedPreferences  preferences1 = getSharedPreferences("datos", Context.MODE_PRIVATE);
        preferences1.getString("nombre_producto, codigo_de_barra, precio_proveedor, precio_unitario", "");

        Toast.makeText(this, "producto agregado", Toast.LENGTH_LONG).show();



    }





}