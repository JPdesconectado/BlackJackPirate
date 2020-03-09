package com.example.blackjackjhony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

        EditText usuario;
        EditText senha;
        EditText nomeCompleto;
        EditText email;
        Button btCadastrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usuario = findViewById(R.id.usuario);
        senha = findViewById(R.id.senha);
        nomeCompleto = findViewById(R.id.nomeCompleto);
        email = findViewById(R.id.email);
        btCadastrar = findViewById(R.id.cadastrar);


    }


        public void onClickCadastrar(View v){
            int error401, error402, error403, error404 = 404;

            if(usuario.getText().toString().equals("")){
                usuario.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                usuario.setError("O usuário não pode estar em branco.");
                error401 = 404;
            }else{
                usuario.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E2E2D0")));
                usuario.setError(null);
                error401 = 0;
            }

            if(senha.getText().toString().equals("")){
                senha.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                senha.setError("A senha não pode estar em branco.");
                error402 = 404;

            }else{
                senha.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E2E2D0")));
                senha.setError(null);
                error402 = 0;
            }

            if(nomeCompleto.getText().toString().equals("")){
                nomeCompleto.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                nomeCompleto.setError("O nome não pode estar em branco.");
                error403 = 404;

            }else{
                nomeCompleto.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E2E2D0")));
                nomeCompleto.setError(null);
                error403 = 0;
            }

            if(email.getText().toString().equals("")){
                email.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
                email.setError("O email  não pode estar em branco.");
                error404 = 404;
            }else{
                email.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E2E2D0")));
                email.setError(null);
                error404 = 0;
            }

            if(error401 == 404 || error402 == 404 || error403 == 404 || error404 == 404){



            } else{

                Intent returnIntent = new Intent();
                Bundle bundle = new Bundle();
                String user = usuario.getText().toString();
                String pass = senha.getText().toString();
                bundle.putString("nome", usuario.getText().toString());
                bundle.putString("senha", senha.getText().toString());
                bundle.putInt("pontoJogador", 0);
                bundle.putInt("pontoBot", 0);
                returnIntent.putExtras(bundle);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        }




}
