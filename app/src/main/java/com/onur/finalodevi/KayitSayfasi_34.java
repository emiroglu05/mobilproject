package com.onur.finalodevi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class KayitSayfasi_34 extends AppCompatActivity {

    private EditText txtEmail, txtParola;
    private String eposta, parola;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_sayfasi34);

        txtEmail = findViewById(R.id.edtEMail);
        txtParola = findViewById(R.id.edtParola);
        mAuth = FirebaseAuth.getInstance();
    }

    public void kaydol(View view) {
        eposta = txtEmail.getText().toString();
        parola = txtParola.getText().toString();
        if (!eposta.isEmpty() || !parola.isEmpty()) {
            mAuth.createUserWithEmailAndPassword(eposta, parola)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(KayitSayfasi_34.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                                Intent gecis = new Intent(KayitSayfasi_34.this, GirisSayfasi_34.class);
                                startActivity(gecis);
                            } else {
                                Toast.makeText(KayitSayfasi_34.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        } else {
            Toast.makeText(this, "Alanlar boş bırakılamaz", Toast.LENGTH_SHORT).show();
        }
    }
    public void kayittangeridon (View view) {
        Intent gecis = new Intent (this, MainActivity.class);
        startActivity(gecis);
    }
}