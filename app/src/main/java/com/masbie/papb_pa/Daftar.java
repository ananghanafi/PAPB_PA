package com.masbie.papb_pa;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;


public class Daftar extends AppCompatActivity {

    Button bt;
    ImageView profil;
    private Thread threadBackground;

    // Deklarasi handler sebagai jembatan antar Thread
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_daftar);
        bt = (Button) findViewById(R.id.button);
        profil = (ImageView) findViewById(R.id.imageView2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Daftar.this);
                builder.setMessage("Tunggu Akses....");
                builder.show();
                if (threadBackground == null
                        || threadBackground.getState() == Thread.State.TERMINATED) {
                    threadBackground = new Thread(runnableBackground3);

                    // Jalankan Thread
                    threadBackground.start();
                }
                Intent kephone = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(kephone, 0);
            }
        });


    }

    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if (resCode == RESULT_OK) {
            Uri target = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(target));
                profil.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    Runnable runnableBackground3 = new Runnable() {

        @Override
        public void run() {

            try {
//                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
//                builder.setMessage("Tunggu Sebentar ya....");
//                builder.show();
                Thread.sleep(1000);
                // Kirimkan angka random ke Thread UI melalui handler
                // Runnable yan dijalankan di Thread UI adalah runnableUI
                handler.post(runnableUI3);

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
    Runnable runnableUI3 = new Runnable() {
        @Override
        public void run() {
            Intent kedaftar = new Intent(Daftar.this, MainActivity.class);
            startActivity(kedaftar);
        }
    };


}
