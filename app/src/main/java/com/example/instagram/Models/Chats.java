package com.example.instagram.Models;

import android.os.Bundle;

import com.example.instagram.R;

public class Chats {


    private int imagen;
    private String Nombre;
    private String Chat;
    private String ChatHora;

    public Chats(int f,String nombre, String chat, String chathora) {
        imagen=f;
        Nombre=nombre;
        Chat=chat;
        ChatHora=chathora;
    }

    public Chats() {

    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getChat() {
        return Chat;
    }

    public void setChat(String chat) {
        Chat = chat;
    }

    public String getChatHora() {
        return ChatHora;
    }

    public void setChatHora(String chatHora) {
        ChatHora = chatHora;
    }


    public Bundle ChatToBundle() {
        Bundle b = new Bundle();
        b.putString("nombre",this.getNombre());
        b.putString("chat",this.getChat());
        b.putString("hora",this.getChatHora()+" h");

        return b;
    }
    public Chats restoreBundle(Bundle b){
        return new Chats(
                R.drawable.ic_launcher_background,
                b.getString("nombre"),
                b.getString("chat"),
                b.getString("hora")
        );
    }
}
