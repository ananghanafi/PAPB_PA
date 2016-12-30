package com.masbie.papb_pa;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Login extends AppCompatActivity {
    private Thread threadBackground;

    // Deklarasi handler sebagai jembatan antar Thread
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        Button bt = (Button) findViewById(R.id.btn_login);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setMessage("Tunggu Sebentar ya....");
                builder.show();
                if (threadBackground == null
                        || threadBackground.getState() == Thread.State.TERMINATED) {
                    threadBackground = new Thread(runnableBackground1);

                    // Jalankan Thread
                    threadBackground.start();
                }
            }
        });
        TextView kedaftar = (TextView) findViewById(R.id.link_signup);
        kedaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setMessage("Di tunggu dulu....");
                builder.show();
                if (threadBackground == null
                        || threadBackground.getState() == Thread.State.TERMINATED) {
                    threadBackground = new Thread(runnableBackground);

                    // Jalankan Thread
                    threadBackground.start();
                }
            }
        });


    }

    Runnable runnableBackground1 = new Runnable() {

        @Override
        public void run() {

            try {
//                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
//                builder.setMessage("Tunggu Sebentar ya....");
//                builder.show();
                Thread.sleep(2500);
                // Kirimkan angka random ke Thread UI melalui handler
                // Runnable yan dijalankan di Thread UI adalah runnableUI
                handler.post(runnableUI1);

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

    Runnable runnableBackground = new Runnable() {

        @Override
        public void run() {

            try {

                Thread.sleep(2500);
                // Kirimkan angka random ke Thread UI melalui handler
                // Runnable yan dijalankan di Thread UI adalah runnableUI
                handler.post(runnableUI);

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
    Runnable runnableUI1 = new Runnable() {
        @Override
        public void run() {
            Intent kehome = new Intent(Login.this, MainActivity.class);
            startActivity(kehome);
        }
    };
    Runnable runnableUI = new Runnable() {
        @Override
        public void run() {
            Intent kedaftar = new Intent(Login.this, Daftar.class);
            startActivity(kedaftar);
        }
    };
}
