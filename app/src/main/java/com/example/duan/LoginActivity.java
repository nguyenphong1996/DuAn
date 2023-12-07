package com.example.duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.dao.UserDAO;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUser, edtPassword;
    private Button btnLogin;
    private TextView txtSingUp, txtForgetPassword;
    private UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtSingUp = findViewById(R.id.txtSingUp);
        txtForgetPassword = findViewById(R.id.txtForgetPassword);

        userDAO = new UserDAO(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPassword.getText().toString();

                boolean checkLogin = userDAO.checkLogin(user, pass);
                if (checkLogin){
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class); // chuyển màn hình
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class); // chuyển màn hình
                startActivity(intent);
            }
        });
        txtForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPassActivity.class); // chuyển màn hình
                startActivity(intent);
            }
        });

    }
}