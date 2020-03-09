package com.example.blackjackjhony;

public class User {

    String name;
    String pass;
    int pontoJogador;
    int pontoBot;

    public User(String name, String pass, int pontoJogador, int pontoBot) {
        super();
        this.name = name;
        this.pass = pass;
        this.pontoJogador = pontoJogador;
        this.pontoBot = pontoBot;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPontoJogador(){
        return pontoJogador;
    }

    public void setPontoJogador(int pontoJogador){
        this.pontoJogador = pontoJogador;
    }

    public int getPontoBot(){
        return pontoBot;
    }

    public void setPontoBot(int pontoBot){
        this.pontoBot = pontoBot;
    }

}
