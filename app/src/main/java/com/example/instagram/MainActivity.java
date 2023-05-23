package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.instagram.ChatsAdapter.ChatsAdapter;
import com.example.instagram.Models.Chats;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ChatsAdapter adapter1;
    ListView Cratos;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cratos = (ListView)findViewById(R.id.Cratos);

        //Adapter Complejo
        Bundle b = getIntent().getExtras();
        if(b!=null){
            Chats chat = new Chats().restoreBundle(b);
            List<Chats> chats = LlenarListViewCompuest();
            chats.add(chat);
            adapter1 = new ChatsAdapter(
                    getApplicationContext(),
                    chats
            );
            Cratos.setAdapter(adapter1);
        }
        else{
            adapter1 = new ChatsAdapter(
              getApplicationContext(),
              LlenarListViewCompuest()
            );
        }
    Cratos.setAdapter(adapter1);
    }

    private List<Chats> LlenarListViewCompuest() {
        List<Chats> chats = new ArrayList<Chats>();
        chats.add(new Chats(R.drawable.ic_launcher_background,"Carlos Sánchez","Hola Como Hacemos Para la Tareas","50 Min"));
        chats.add(new Chats(R.drawable.ic_launcher_background,"Juan Carlos UTP","Comos Estas","1 H"));
        chats.add(new Chats(R.drawable.ic_launcher_background,"Antonio Zamora","Te Quedaste","3 H"));
        chats.add(new Chats(R.drawable.ic_launcher_background,"Carlos Oviedo","Envió un reel","8 H"));
        chats.add(new Chats(R.drawable.ic_launcher_background,"Daphne","Hola Corazon","8 H"));
        chats.add(new Chats(R.drawable.ic_launcher_background,"Peter","MAMAGUEVO DIGO GLUP GLUP GLUP","10 H"));

        return chats;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.miNew){
            Intent i = new Intent(getApplicationContext(),FormActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Opción no habilitada",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}