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

public class GirisSayfasi_34 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_sayfasi34);
    }

    public void girisyap (View view) {
        Toast.makeText(this, "Giriş Başarılı, Hoşgeldiniz", Toast.LENGTH_SHORT).show();
        Intent gecis = new Intent (this, MainActivity2_34.class);
        startActivity(gecis);
    }
    public void btngeridon (View view) {
        Intent gecis = new Intent (this, MainActivity.class);
        startActivity(gecis);
    }
}