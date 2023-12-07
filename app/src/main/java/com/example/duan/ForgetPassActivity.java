package com.example.duan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgetPassActivity extends AppCompatActivity {

    EditText edtEmailRecovery;
    Button btnSendEmail, btnQuayLai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        edtEmailRecovery = findViewById(R.id.edtEmailRecovery);
        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnQuayLai = findViewById(R.id.btnQuayLai);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmailRecovery.getText().toString();
                if (email.equals("")){
                    edtEmailRecovery.setError("Vui lòng nhập email");
                }else {
                    showDiaglog();
                }
            }
        });

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void showDiaglog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_forgot);
        dialog.show();
    }
}