package com.nurzainpradana.koperasimasjid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VerificationAct extends AppCompatActivity {

    Button btn_verifikasi_lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        btn_verifikasi_lanjut = findViewById(R.id.btn_verifikasi_lanjut);

        btn_verifikasi_lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregister2 = new Intent(VerificationAct.this, RegisterTwoAct.class);
                startActivity(gotoregister2);
            }
        });

    }
}
