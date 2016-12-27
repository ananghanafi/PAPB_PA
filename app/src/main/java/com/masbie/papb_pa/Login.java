package com.masbie.papb_pa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * A login screen that offers login via email/password.
 * http://sourcey.com/beautiful-android-login-and-signup-screens-with-material-design/
 */
public class Login extends AppCompatActivity implements View.OnClickListener {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private Button upButton;
    private static final int REQUEST_READ_CONTACTS = 0;
    public static final String LOGIN_URL = "http://192.168.20.59/pgkba/";

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";

    private EditText editTextUsername;
    private EditText editTextPassword;


    private String username;
    private String password;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */

    // UI references.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        editTextUsername = (EditText) findViewById(R.id.input_email);
        editTextPassword = (EditText) findViewById(R.id.input_password);

        upButton = (Button) findViewById(R.id.btn_login);
        upButton.setTextColor(Color.BLACK);
        upButton.setOnClickListener(this);
//        upButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                attemptLogin();
//                  goToProfile();
//            }
//        });
    }

    private void goToProfile() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("login", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("akses", false);
        editor.putString("user", username);
        editor.commit();
        finish();
    }

    @Override
    public void onClick(View view) {
        userLogin();
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    private void userLogin() {
        username = editTextUsername.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("username", username);

        final ProgressDialog progressDialog = new ProgressDialog(Login.this);
//        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            goToProfile();
                            progressDialog.dismiss();
                        }else{
                            Toast.makeText(Login.this,response,Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this,error.toString(),Toast.LENGTH_LONG ).show();
                        progressDialog.dismiss();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME,username);
                map.put(KEY_PASSWORD,password);
                return map;
            }
        };
        TextView daftar = (TextView) findViewById(R.id.link_signup);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kedaftar=new Intent(Login.this, Daftar.class);
                startActivity(kedaftar);
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }
}

