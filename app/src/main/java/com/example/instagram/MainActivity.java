package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

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
    ChatsAdapter adapterComp;
    ListView lstChatsIg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstChatsIg = (ListView)findViewById(R.id.lstChatsIg);

        //Adapter Complejo
        Bundle b = getIntent().getExtras();
        if(b!=null){
            Chats chat = new Chats().restoreBundle(b);
            List<Chats> chats = LlenarListViewCompuest();
            chats.add(chat);
            adapterComp = new ChatsAdapter(
                    getApplicationContext(),
                    chats
            );
            lstChatsIg.setAdapter(adapterComp);
        }
        else{
            adapterComp = new ChatsAdapter(
              getApplicationContext(),
              LlenarListViewCompuest()
            );
        }
    lstChatsIg.setAdapter(adapterComp);
    }

    private List<Chats> LlenarListViewCompuest() {
        List<Chats> chats = new ArrayList<Chats>();
        chats.add(new Chats(R.drawable.ic_launcher_background,"jose pablo","Carita triste","2 h"));
        chats.add(new Chats(R.drawable.ic_launcher_background,"Anna Patricia","Hola","8 h"));
        chats.add(new Chats(R.drawable.ic_launcher_background,"Antonio Barrios","Hola","3 h"));
        chats.add(new Chats(R.drawable.ic_launcher_background,"Ernesto Mora","Envió un reel","8 h"));
        chats.add(new Chats(R.drawable.ic_launcher_background,"Madelaine","hola","8 h"));
        chats.add(new Chats(R.drawable.ic_launcher_background,"peter.w28","Visto","10 h"));

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