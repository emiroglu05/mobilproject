package com.onur.finalodevi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2_34 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main234);
    }
    public void urundetay (View view) {
        Intent gecis = new Intent (this, UrunDetay_34.class);
        startActivity(gecis);
    }
    public void yeniurunkaydi (View view) {
        Intent gecis = new Intent (this, YeniUrunKaydi_34.class);
        startActivity(gecis);
    }
    public void cikisyap(View view){
        AlertDialog.Builder onay=new AlertDialog.Builder(this);
        onay.setTitle("KULLANICI ÇIKIŞI");
        onay.setMessage(" Çıkış Yapmak İstediğinizden Emin misiniz?");
        onay.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            Intent gecis = new Intent (MainActivity2_34.this, MainActivity.class);
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity2_34.this, "Çıkış Yapıldı.", Toast.LENGTH_SHORT).show();

                startActivity(gecis);
            }

        }).setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity2_34.this, "Çıkış İptal Edildi", Toast.LENGTH_SHORT).show();
            }
        });
        onay.show();
    }
}