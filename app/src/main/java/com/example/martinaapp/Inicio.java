package com.example.martinaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.martinaapp.Adapters.ListaProductosAdapter;
import com.example.martinaapp.BD.DBProductos;
import com.example.martinaapp.BD.Productos;

import java.util.ArrayList;

public class Inicio extends AppCompatActivity {
    RecyclerView recyclerViewCategotyList, listaEstudiantes;
    ListaProductosAdapter adapter;
    ArrayList<Productos> listaArrayProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        recyclerVistaProductos();
    }

    private void recyclerVistaProductos() {
        listaEstudiantes = findViewById(R.id.view2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        listaEstudiantes.setLayoutManager(linearLayoutManager);

        DBProductos dbProductos = new DBProductos(Inicio.this);

        listaArrayProductos= new ArrayList<>();
        adapter= new ListaProductosAdapter(dbProductos.mostrarProductos());
        listaEstudiantes.setAdapter(adapter);


        /*ArrayList<Productos> listaArrayProductos = new ArrayList<>();
        listaArrayProductos.add(new FoodDomain("Pepperoni pizza","pizza1","slices pepperoni ,mozzarella cheese, fresh oregano, grounf black pepper, pizza sauce",13.0,5,20,1000));
        listaArrayProductos.add(new FoodDomain("Chesse burger","burger","slices pepperoni ,mozzarella cheese, fresh oregano, grounf black pepper, pizza sauce",15.0,4,18,1500));
        listaArrayProductos.add(new FoodDomain("Pizza","pizza3","slices pepperoni ,mozzarella cheese, fresh oregano, grounf black pepper, pizza sauce",13.0,5,20,1000));
        adapter2=new RecommendedAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);*/
    }
}