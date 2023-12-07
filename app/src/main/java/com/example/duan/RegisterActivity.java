package com.example.duan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan.dao.UserDAO;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtUserName, edtRegisterEmail, edtRegisterPass, edtRePass;
    private Button btn_back, btn_register;
    private UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtUserName = findViewById(R.id.edtUserName);
        edtRegisterEmail = findViewById(R.id.edtRegisterEmail);
        edtRegisterPass = findViewById(R.id.edtRegisterPass);
        edtRePass = findViewById(R.id.edtRePass);
        btn_back = findViewById(R.id.btn_back);
        btn_register = findViewById(R.id.btn_register);

        btn_back.setOnClickListener(v -> {
            finish();
        });

        userDAO = new UserDAO(this);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUserName.getText().toString();
                String email = edtRegisterEmail.getText().toString();
                String pass = edtRegisterPass.getText().toString();
                String repass = edtRePass.getText().toString();

                if (user.equals("") || email.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    if (pass.equals(repass)){
                        boolean checkRegister = userDAO.register(user, pass, email);
                        if (checkRegister){
                            Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegisterActivity.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        }
}