package com.example.pratica;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


//Método onCreate é chamado quando a atividade é criada. Ele realiza várias inicializações,
// incluindo a configuração da interface do utilizador, e a definição da ActionBar (usando a Toolbar)
// e a adição do fragmento Home à atividade.
public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView = findViewById(R.id.img_home_screen);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar_toolbar_main);
        setSupportActionBar(toolbar);
        if(savedInstanceState == null){
            FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            Fragment home = Home.newInstance("","");
            ft.add(R.id.fragmentContainerView,home);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    //Método onCreateOptionsMenu é chamado quando o menu de opções é criado. Ele coloca o menu de opções e define os ícones como visíveis.
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        ((MenuBuilder) menu).setOptionalIconsVisible(true);
        return super.onCreateOptionsMenu(menu);
    }


    //Método onOptionsItemSelected é chamado quando um item do menu é selecionado. Ele verifica o ID do item selecionado e exibe um Toast com uma mensagem correspondente.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnu_calculadora_mainmenu) {
            Toast.makeText(this, "Calculadora", Toast.LENGTH_SHORT).show();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment calculadora = Calculadora.newInstance("", "");
            ft.replace(R.id.fragmentContainerView, calculadora);
            ft.addToBackStack(null);
            ft.commit();
        }
        if (id == R.id.mnu_selos_mainmenu) {
            Toast.makeText(this, "Selos", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}