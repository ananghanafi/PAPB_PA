package com.masbie.papb_pa;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        TextView kedaftar = (TextView) findViewById(R.id.link_signup);
        kedaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kedaftar = new Intent(Login.this, Daftar.class);
                startActivity(kedaftar);
            }
        });


    }

}
