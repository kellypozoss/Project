package com.example.loginusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //variables extra
    String usuario, contrasena;

    EditText txtUsuario,txtContrasena;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContrasena = (EditText) findViewById(R.id.txtContrasena);

        btnLogin = (Button) findViewById( (R.id.btnLogin));
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                usuario = txtUsuario.getText().toString();
                contrasena = txtContrasena.getText().toString();
                if(!usuario.isEmpty() && !contrasena.isEmpty())
                {
                    validarUsuario("http://192.168.56.1/api_usuarios/Usuario.php");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Faltan datos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private  void validarUsuario(String URL)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { // Si se procesa
                if(!response.isEmpty())
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Datos erróneos", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() { // si no se procesa o hay otro error
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, toString(), Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map <String, String> parametro = new HashMap<String, String>();
                parametro.put("usuario", txtUsuario.getText().toString());
                parametro.put("contrasena", txtContrasena.getText().toString());
                return parametro;
            }
        };

        //para procesar las peticiones desde nuestra app
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}