package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText et_name;
    EditText et_password;
    String isiName = "Pascal";
    String isiPassword = "iniPascal";
    Button login;
    String name;
    String password;
    TextView regis;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.login_activity);
        this.regis = (TextView) findViewById(R.id.textView4);
        this.et_name = (EditText) findViewById(R.id.etName);
        this.et_password = (EditText) findViewById(R.id.etpassword);
        this.login = (Button) findViewById(R.id.bt_signin);
        this.regis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Login.this.startActivity(new Intent(Login.this.getApplicationContext(), home.class));
            }
        });
        this.login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Login.this.validasi();
            }
        });
    }

    public void validasi() {
        this.name = this.et_name.getText().toString();
        this.password = this.et_password.getText().toString();
        if (this.name.isEmpty()) {
            this.et_name.setError("Name Diperlukan");
        } else if (this.password.isEmpty()) {
            this.et_password.setError("Password Diperlukan");
        } else if (!this.name.equals(this.isiName) && !this.password.equals(this.isiPassword)) {
            Toast toast = Toast.makeText(getApplicationContext(), "Email dan Password Salah ", 1);
            toast.setGravity(81, 0, 0);
            toast.show();
        } else if (!this.name.equals(this.isiName)) {
            Toast toast2 = Toast.makeText(getApplicationContext(), "Nama Salah ", 1);
            toast2.setGravity(81, 0, 0);
            toast2.show();
        } else if (!this.password.equals(this.isiPassword)) {
            Toast toast3 = Toast.makeText(getApplicationContext(), "Password Salah ", 1);
            toast3.setGravity(81, 0, 0);
            toast3.show();
        } else {
            Bundle b = new Bundle();
            b.putString("a", this.name.trim());
            Intent i = new Intent(getApplicationContext(), Register.class);
            i.putExtras(b);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "Login Sukses ", 1).show();
            this.et_name.getText().clear();
            this.et_password.getText().clear();
        }
    }
}
