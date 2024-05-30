package com.onur.finalodevi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity2_34 extends AppCompatActivity {
    private FirebaseDatabase veritabani;
    private DatabaseReference veriyolu;

    private ListView icerikliste;
    ArrayList<String> liste;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main234);
        icerikliste=findViewById(R.id.kayitlist);


            liste = new ArrayList<>();
            adapter = new ArrayAdapter(MainActivity2_34.this,android.R.layout.simple_list_item_1,liste);

            veriyolu = FirebaseDatabase.getInstance().getReference("Final_projesi");
            // My top posts by number of stars
            veriyolu.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot veriler) {
                    for (DataSnapshot sonveri: veriler.getChildren()) {
                        String deger = sonveri.getValue().toString();

                        liste.add(deger);

                    }
                    icerikliste.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(MainActivity2_34.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
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