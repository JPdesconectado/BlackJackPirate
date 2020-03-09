package com.example.blackjackjhony;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView usuario;
    TextView pontosA, pontosB, pontosJogador, pontosBot;
    ImageView ivA1, ivA2, ivA3, ivA4, ivA5, ivA6, ivA7, ivA8;
    ImageView ivB1, ivB2, ivB3, ivB4, ivB5, ivB6, ivB7, ivB8;
    ArrayList<ImageView> listaA = new ArrayList<>();
    ArrayList<ImageView> listaB = new ArrayList<>();
    int pa = 0;
    int pb = 0;
    int contador = 2;
    int contadorB = 2;
    int vinteeum, vinteumdois = 0;
    int winner = 0;
    Random r = new Random();
    int pontoJ, pontoB;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.layout.main_menu);
        usuario = findViewById(R.id.usuario);
        pontosA = findViewById(R.id.pontosA);
        pontosB = findViewById(R.id.pontosB);
        pontosJogador = findViewById(R.id.pontosJogador);
        pontosBot = findViewById(R.id.pontosBot);
        Bundle bundle = getIntent().getExtras();
        String nome = bundle.getString("nome");
        pontoJ = bundle.getInt("pontoJogador");
        pontoB = bundle.getInt("pontoBot");
        usuario.setText(nome);
        pontosJogador.setText(String.valueOf(pontoJ));
        pontosBot.setText(String.valueOf(pontoB));
        definirImagens();
        encherListas();
        inicioGame();

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.novoJogo:
                        listaA.clear();
                        listaB.clear();
                        switch(winner){
                            case 0:
                                break;

                            case 1:
                                pontoJ+=1;
                                break;

                            case 2:
                                pontoB+=1;
                                break;

                        }
                        winner = 0;
                        pa = 0;
                        pb = 0;
                        contador = 2;
                        contadorB = 2;
                        vinteeum = 0;
                        vinteumdois = 0;
                        removerImagem();
                        inicioGame();
                        pontosA.setText(String.valueOf(pa));
                        pontosB.setText(String.valueOf(pb));
                        pontosJogador.setText(String.valueOf(pontoJ));
                        pontosBot.setText(String.valueOf(pontoB));
                        break;

                    case R.id.regras:
                        Toast.makeText(MainActivity.this, "REGRAS EEEEE", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_settings:
                        Intent returnIntent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putInt("pontoJogador", pontoJ);
                        bundle.putInt("pontoBot", pontoB);
                        returnIntent.putExtras(bundle);
                        setResult(Activity.RESULT_OK, returnIntent);
                        finish();
                        break;
                }
                return false;
            }
        });



        if(vinteeum == 3 && vinteumdois == 3){
            pa = 21;
            Toast.makeText(MainActivity.this, "DRAW.", Toast.LENGTH_SHORT).show();
        }

        if(vinteeum == 3){
            winner = 1;
            pontosA.setText(String.valueOf(21));
            Toast.makeText(MainActivity.this, "Players Wins.", Toast.LENGTH_SHORT).show();

        }else{
            pontosA.setText(String.valueOf(pa));
        }

        if(vinteumdois == 3){
            winner = 2;
            pontosB.setText(String.valueOf(21));
            Toast.makeText(MainActivity.this, "BOT Wins.", Toast.LENGTH_SHORT).show();

        }else{
            pontosB.setText(String.valueOf(pb));
        }

    }

    public void onClickNewCard(View view){

            if(pa < 21 && winner == 0){
                if(contador < listaA.size()){
                    sortearCartaA(listaA.get(contador));
                    pontosA.setText(String.valueOf(pa));
                    contador++;
                }

            }

            if(pa == 21){
                winner = 1;
                Toast.makeText(MainActivity.this, "Players Wins.", Toast.LENGTH_SHORT).show();
            }

            if(pa > 21){
                Toast.makeText(MainActivity.this, "BOT Wins.", Toast.LENGTH_SHORT).show();
                winner = 2;

            }


    }

    public void onClickStop(View view){

        while ((pb <= pa && pa < 21) && winner == 0){

                if(contadorB < listaB.size()){
                    sortearCartaB(listaB.get(contadorB));
                    pontosB.setText(String.valueOf(pb));
                    contadorB++;
                }

            }

        if(pb == 21 || (pb > pa && pb <= 21) || pa > 21 ){
            winner = 2;
            Toast.makeText(MainActivity.this, "BOT Wins.", Toast.LENGTH_SHORT).show();
        }else{
            winner = 1;
            Toast.makeText(MainActivity.this, "Players Wins.", Toast.LENGTH_SHORT).show();
        }

        }


    public void sortearCartaA(ImageView img){
            int i = r.nextInt(13) + 1;
            switch(i){

                case 1:
                    img.setImageResource(R.drawable.spade1);
                    pa += 1;
                    vinteeum +=1;
                    break;

                case 2:
                    img.setImageResource(R.drawable.spade2);
                    pa += 2;
                    break;

                case 3:
                    img.setImageResource(R.drawable.spade3);
                    pa += 3;
                    break;

                case 4:
                    img.setImageResource(R.drawable.spade4);
                    pa += 4;
                    break;

                case 5:
                    img.setImageResource(R.drawable.spade5);
                    pa += 5;
                    break;


                case 6:
                    img.setImageResource(R.drawable.spade6);
                    pa += 6;
                    break;


                case 7:
                    img.setImageResource(R.drawable.spade7);
                    pa += 7;
                    break;

                case 8:
                    img.setImageResource(R.drawable.spade8);
                    pa += 8;
                    break;

                case 9:
                    img.setImageResource(R.drawable.spade9);
                    pa += 9;
                    break;


                case 10:
                    img.setImageResource(R.drawable.spade10);
                    pa += 10;
                    break;

                case 11:
                    img.setImageResource(R.drawable.spade11);
                    pa += 10;
                    vinteeum = 2;
                    break;

                case 12:
                    img.setImageResource(R.drawable.spade12);
                    pa += 10;
                    vinteeum = 2;
                    break;

                case 13:
                    img.setImageResource(R.drawable.spade13);
                    pa += 10;
                    vinteeum = 2;
                    break;

            }

    }
    public void sortearCartaB(ImageView img){
        int i = r.nextInt(13) + 1;
        switch(i){

            case 1:
                img.setImageResource(R.drawable.spade1);
                pb += 1;
                vinteumdois += 1;
                break;

            case 2:
                img.setImageResource(R.drawable.spade2);
                pb += 2;
                break;

            case 3:
                img.setImageResource(R.drawable.spade3);
                pb += 3;
                break;

            case 4:
                img.setImageResource(R.drawable.spade4);
                pb += 4;
                break;

            case 5:
                img.setImageResource(R.drawable.spade5);
                pb += 5;
                break;


            case 6:
                img.setImageResource(R.drawable.spade6);
                pb += 6;
                break;


            case 7:
                img.setImageResource(R.drawable.spade7);
                pb += 7;
                break;

            case 8:
                img.setImageResource(R.drawable.spade8);
                pb += 8;
                break;

            case 9:
                img.setImageResource(R.drawable.spade9);
                pb += 9;
                break;


            case 10:
                img.setImageResource(R.drawable.spade10);
                pb += 10;
                break;

            case 11:
                img.setImageResource(R.drawable.spade11);
                pb += 10;
                vinteumdois = 2;
                break;

            case 12:
                img.setImageResource(R.drawable.spade12);
                pb += 10;
                vinteumdois = 2;
                break;

            case 13:
                img.setImageResource(R.drawable.spade13);
                pb += 10;
                vinteumdois = 2;
                break;

        }

    }
    public void definirImagens(){
        ivA1 = findViewById(R.id.ivA1);
        ivA2 = findViewById(R.id.ivA2);
        ivA3 = findViewById(R.id.ivA3);
        ivA4 = findViewById(R.id.ivA4);
        ivA5 = findViewById(R.id.ivA5);
        ivA6 = findViewById(R.id.ivA6);
        ivA7 = findViewById(R.id.ivA7);
        ivA8 = findViewById(R.id.ivA8);

        ivB1 = findViewById(R.id.ivB1);
        ivB2 = findViewById(R.id.ivB2);
        ivB3 = findViewById(R.id.ivB3);
        ivB4 = findViewById(R.id.ivB4);
        ivB5 = findViewById(R.id.ivB5);
        ivB6 = findViewById(R.id.ivB6);
        ivB7 = findViewById(R.id.ivB7);
        ivB8 = findViewById(R.id.ivB8);
    }
    public void encherListas(){

        listaA.add(ivA1);
        listaA.add(ivA2);
        listaB.add(ivB1);
        listaB.add(ivB2);


        listaA.add(ivA3);
        listaA.add(ivA4);
        listaB.add(ivB3);
        listaB.add(ivB4);


        listaA.add(ivA5);
        listaA.add(ivA6);
        listaB.add(ivB5);
        listaB.add(ivB6);


        listaA.add(ivA7);
        listaA.add(ivA8);
        listaB.add(ivB7);
        listaB.add(ivB8);


    }
    public void inicioGame(){
        encherListas();
        sortearCartaA(listaA.get(0));
        sortearCartaA(listaA.get(1));
        sortearCartaB(listaB.get(0));
        sortearCartaB(listaB.get(1));
    }
    public void removerImagem(){
        ivA1.setImageResource(0);
        ivA2.setImageResource(0);
        ivA3.setImageResource(0);
        ivA4.setImageResource(0);
        ivA5.setImageResource(0);
        ivA6.setImageResource(0);
        ivA7.setImageResource(0);
        ivA8.setImageResource(0);


        ivB1.setImageResource(0);
        ivB2.setImageResource(0);
        ivB3.setImageResource(0);
        ivB4.setImageResource(0);
        ivB5.setImageResource(0);
        ivB6.setImageResource(0);
        ivB7.setImageResource(0);
        ivB8.setImageResource(0);

    }

}
