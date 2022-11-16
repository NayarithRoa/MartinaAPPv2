package com.example.martinaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.martinaapp.BD.DBProductos;
import com.example.martinaapp.BD.Productos;

public class DetalleProducto extends AppCompatActivity {

    private TextView addToCartBtn;
    private TextView txtTitulo, txtprecio, descriptionTxt, txtCantidad, txtPrecioTotal;
    private ImageView btnMas, btnMenos, imgProducto;
    private Productos object;
    private int numberOder = 1;
    private DBProductos dbProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        dbProductos=new DBProductos(this);

        addToCartBtn=findViewById(R.id.addToCratBtn);
        txtTitulo=findViewById(R.id.txtTitulo);
        txtprecio=findViewById(R.id.txtprecio);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        txtCantidad=findViewById(R.id.txtCantidad);
        btnMas=findViewById(R.id.btnMas);
        btnMenos=findViewById(R.id.btnMenos);
        imgProducto=findViewById(R.id.imgProducto);
        txtPrecioTotal=findViewById(R.id.totalPriceTxt);

        object=(Productos)getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOder));
        caloryTxt.setText(object.getCalories()+"Calories");
        starTxt.setText(object.getStar()+"");
        titleTxt.setText(object.getTime()+" minutes");
        totalPriceTxt.setText(String.valueOf(numberOder * object.getFee()));

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOder = numberOder + 1;
                txtCantidad.setText(String.valueOf(numberOder));
                txtPrecioTotal.setText(String.valueOf(numberOder * object.getFee()));
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOder > 1){
                    numberOder = numberOder - 1;
                }
                txtCantidad.setText(String.valueOf(numberOder));
                txtPrecioTotal.setText(String.valueOf(numberOder * object.txtprecio()));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOder);
                managementCart.insertFood(object);
            }
        });
    }
}