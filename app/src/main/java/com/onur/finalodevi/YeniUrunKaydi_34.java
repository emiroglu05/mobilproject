package com.onur.finalodevi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class YeniUrunKaydi_34 extends AppCompatActivity {

        EditText txturunno, txturunadi,txtmodelkodu,txtsiparisadedi;
        Button verikayit;
    FirebaseAuth kimlik;
    DatabaseReference veritabani;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_yeni_urun_kaydi34);
        txturunno=findViewById(R.id.txtUrunNo);
        txturunadi=findViewById(R.id.txtUrunAdi);
        txtmodelkodu=findViewById(R.id.txtModelKodu);
        txtsiparisadedi=findViewById(R.id.txtSiparisAdedi);
        kimlik=FirebaseAuth.getInstance();
        veritabani= FirebaseDatabase.getInstance().getReference("Final_projesi");

    }
    public void btngrdn (View view) {
        Intent gecis = new Intent (this, MainActivity2_34.class);
        startActivity(gecis);
    }
    public void verikayit(View view){
        String no=txturunno.getText().toString();
        String urunadi=txturunadi.getText().toString();
        String modelkodu=txtmodelkodu.getText().toString();
        String siparisadedi=txtsiparisadedi.getText().toString();
        UUID uuid=UUID.randomUUID();
        String ykayit=uuid.toString();
        if(!no.isEmpty()&&!urunadi.isEmpty()&&!modelkodu.isEmpty()&&!siparisadedi.isEmpty()){
            DatabaseReference yenikayit=veritabani.child(ykayit);
            yenikayit.child("urunno").setValue(no);
            yenikayit.child("urunadi").setValue(urunadi);
            yenikayit.child("modelkodu").setValue(modelkodu);
            yenikayit.child("siparisadedi").setValue(siparisadedi);
            Toast.makeText(this, "Veritabanı Kayıt İşlemi Başarılı!", Toast.LENGTH_SHORT).show();

                Intent gecis = new Intent (this, YeniUrunKaydi_34.class);
                startActivity(gecis);

        }else{
            Toast.makeText(this, "Alanlar boş bırakılamaz", Toast.LENGTH_SHORT).show();
        }

    }
}