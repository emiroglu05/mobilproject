package com.onur.finalodevi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void kaydol (View view) {
        Intent gecis = new Intent (this, KayitSayfasi_34.class);
        startActivity(gecis);
    }

    public void giris (View view) {

        Intent gecis = new Intent (this, GirisSayfasi_34.class);
        startActivity(gecis);
    }
    public void prjhakkinda (View view) {
        Intent gecis = new Intent (this, proje_34.class);
        startActivity(gecis);
    }


}