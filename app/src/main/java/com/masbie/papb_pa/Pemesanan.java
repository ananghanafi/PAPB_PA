package com.masbie.papb_pa;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class Pemesanan extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pemesanan);
        final Spinner spinner, spinner1;

        spinner = (Spinner) findViewById(R.id.spinner4);
        spinner1 = (Spinner) findViewById(R.id.spinner7);
        Button bt = (Button) findViewById(R.id.next);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keOrder = new Intent(Pemesanan.this, Pembayaran.class);
                startActivity(keOrder);

            }
        });
        String[] values =
                {"Cotton", "Levis", "Denim", "Kain"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        String[] values1 =
                {"M", "L", "XL", "XXL"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);


    }
}