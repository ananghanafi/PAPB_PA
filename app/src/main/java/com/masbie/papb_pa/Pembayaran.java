package com.masbie.papb_pa;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class Pembayaran extends AppCompatActivity {

    private Thread threadBackground;

    // Deklarasi handler sebagai jembatan antar Thread
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pembayaran);
        final Spinner spinner, spinner1;
        final Spinner spinner2, spinner3, spinner4;


        spinner = (Spinner) findViewById(R.id.spinner);
        spinner1 = (Spinner) findViewById(R.id.spinner2);
        spinner2 = (Spinner) findViewById(R.id.spinner3);
        spinner3 = (Spinner) findViewById(R.id.spinner5);
        spinner4 = (Spinner) findViewById(R.id.spinner6);
        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Pembayaran.this);
                builder.setMessage("Proses Pengiriman....");
                builder.show();
                if (threadBackground == null
                        || threadBackground.getState() == Thread.State.TERMINATED) {
                    threadBackground = new Thread(runnableBackground2);

                    // Jalankan Thread
                    threadBackground.start();
                }

            }
        });
        String[] values =
                {"Yogyakarta", "Banten", "Jawa Timur", "Jawa Tengah"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        String[] values1 =
                {"Surabaya", "Malang", "Lumajang", "Pasuruan"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter1);
        String[] values2 =
                {"Lowokwaru", "Karangploso", "Singosari", "Karanglo"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values2);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter2);
        String[] values3 =
                {"65151", "65152", "65132", "65231"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values3);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner3.setAdapter(adapter3);
        String[] values4 =
                {"Mobile Banking", "Transfer"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values4);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner4.setAdapter(adapter4);


    }
    Runnable runnableBackground2 = new Runnable() {

        @Override
        public void run() {

            try {
//                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
//                builder.setMessage("Tunggu Sebentar ya....");
//                builder.show();
                Thread.sleep(2500);
                // Kirimkan angka random ke Thread UI melalui handler
                // Runnable yan dijalankan di Thread UI adalah runnableUI
                handler.post(runnableUI2);

                // Set delay sebelum menggenerate angka lainnya.


                // Jika terjadi exception, yaitu pada saat sleep tombol stop diklik
                // Telan exceptionnya
            } catch (
                    Exception ex
                    )

            {
            }

            // Tidak boleh mengubah/memanipulasi elemen UI
            // dari Thread yang bukan Thread UI
            //textAngka.setText(angka.toString());


        }
    };
    Runnable runnableUI2 = new Runnable() {
        @Override
        public void run() {
            Intent kedaftar = new Intent(Pembayaran.this, MainActivity.class);
            startActivity(kedaftar);
        }
    };
}