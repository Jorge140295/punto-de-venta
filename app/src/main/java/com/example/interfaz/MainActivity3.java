package com.example.interfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText et;
    EditText et1;
    EditText et2;
    EditText et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        et = (EditText)findViewById(R.id.txt1);
        et1 = (EditText)findViewById(R.id.txt2);
        et2 = (EditText)findViewById(R.id.txt3);
        et3 = (EditText)findViewById(R.id.txt4);


    }
    public void menu (View view){

        Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
        startActivityForResult(intent,0);

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

        BaseDatos.update("productos", registro, "codigo = " + codigo, null  );
        BaseDatos.close();
        Toast.makeText(this, "producto modificado", Toast.LENGTH_LONG).show();






    }

    public void buscar( View view){
        Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
        startActivityForResult(intent,0);

        BaseD bdD = new BaseD(this,"db1",null,1);
        SQLiteDatabase BaseDatos = bdD.getWritableDatabase();
        String codigo = et1.getText().toString();
        Cursor fila = BaseDatos.rawQuery("select nombre_producto, precio_proveedor, precio_unitario  from productos where codigo = "+ codigo, null );

                et.setText(fila.getString(0));
                et1.setText(fila.getString(1));
                et2.setText(fila.getString(2));
                et3.setText(fila.getString(3));
                BaseDatos.close();
        Toast.makeText(this, "producto encontrado", Toast.LENGTH_LONG).show();
    }


}