package com.example.martinaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.martinaapp.Adapters.ListaArticulosCarritoAdapter;
import com.example.martinaapp.Helper.AdministrarCarrito;

public class DetalleCarroCompras extends AppCompatActivity {
    RecyclerView.Adapter adapter;
    RecyclerView recyclerViewList;
    private AdministrarCarrito administrarCarrito;
    TextView txtTotalArt, txtvlrdomicilio, totalTxt, emptyTxt;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_carro_compras);

        txtTotalArt=findViewById(R.id.txtTotalArt);
        txtvlrdomicilio=findViewById(R.id.txtvlrdomicilio);
        totalTxt=findViewById(R.id.totalTxt);
        recyclerViewList=findViewById(R.id.view);
        scrollView=findViewById(R.id.scrollView);
        emptyTxt=findViewById(R.id.emptyTxt);

        listaInicial();
    }
    private void listaInicial() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter=new ListaArticulosCarritoAdapter(administrarCarrito.getListCart(), this, new cambioNumeroArticulos() {
            @Override
            public void changed() {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }
}