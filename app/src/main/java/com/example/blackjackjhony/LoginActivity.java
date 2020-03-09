package com.example.blackjackjhony;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button btLogin;
    CheckBox btShowPass;
    ArrayList<User> lista = new ArrayList<>();
    String admin = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        btLogin = findViewById(R.id.login);
        btShowPass = findViewById(R.id.showPass);

        if (lista.isEmpty()){
            User user = new User(admin, admin, 0, 0);
            lista.add(user);
        }

    }

    public void onClickLogin(View v){
        Intent intent = new Intent (this, MainActivity.class);
        String usuario;
        String senha;
        usuario = user.getText().toString();
        senha = pass.getText().toString();
        int notFound = 404;

   for(int i = 0; i < lista.size(); i++){

            if(((usuario.equals(lista.get(i).getName()) && senha.equals(lista.get(i).getPass())))){
                notFound = 0;
                Bundle bundle = new Bundle();
                bundle.putString("nome", user.getText().toString());
                bundle.putInt("pontoJogador", lista.get(i).getPontoJogador());
                bundle.putInt("pontoBot", lista.get(i).getPontoBot());
                intent.putExtras(bundle);
                startActivityForResult(intent, 2);
                break;
            }
            notFound = 404;
        }
            if(notFound == 404){
                Toast.makeText(LoginActivity.this, "Usuário ou Senha não encontrado.", Toast.LENGTH_SHORT).show();
            }



    }

    public void onClickCadastro(View v){
        Intent intent = new Intent (this, RegisterActivity.class);
        startActivityForResult(intent, 1);
    }


    public void onClickShowPass(View v){
        if(btShowPass.isChecked()){
            pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

         }else{
            pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                Bundle bundle = data.getExtras();
                String nome = bundle.getString("nome");
                String senha = bundle.getString("senha");
                int pontoJ = bundle.getInt("pontoJogador");
                int pontoB = bundle.getInt("pontoBot");
                User user = new User(nome, senha, pontoJ, pontoB);
                lista.add(user);


            }

        }

        if(requestCode == 2){
            if(resultCode == Activity.RESULT_OK){
                Bundle bundle = data.getExtras();
                int pontoJ = bundle.getInt("pontoJogador");
                int pontoB = bundle.getInt("pontoBot");

                for(int i = 0; i < lista.size(); i++){

                    if(user.getText().toString().equals(lista.get(i).getName())){
                        lista.get(i).setPontoJogador(bundle.getInt("pontoJogador"));
                        lista.get(i).setPontoBot(bundle.getInt("pontoBot"));
                        return;
                    }



            }
        }

    }

    }

}

