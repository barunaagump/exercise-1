package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    EditText email;
    EditText nama;
    EditText pass;
    Button regis;
    EditText repass;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_home);
        this.nama = (EditText) findViewById(R.id.edh_name);
        this.email = (EditText) findViewById(R.id.edh_email);
        this.pass = (EditText) findViewById(R.id.edh_pass);
        this.repass = (EditText) findViewById(R.id.edh_repwd);
        Button button = (Button) findViewById(R.id.bt_register);
        this.regis = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (home.this.nama.getText().toString().isEmpty() || home.this.email.getText().toString().isEmpty()) {
                    home.this.nama.setError("Masukan Nama");
                    home.this.email.setError("Masukan Email");
                } else if (!home.this.pass.getText().toString().equals(home.this.repass.getText().toString())) {
                    Toast toast = Toast.makeText(home.this.getApplicationContext(), "Password Salah ", Toast.LENGTH_LONG);
                    toast.setGravity(81, 0, 0);
                    toast.show();
                } else {
                    Bundle b = new Bundle();
                    b.putString("a", home.this.nama.getText().toString().trim());
                    Intent intent = new Intent(home.this.getApplicationContext(), Register.class);
                    intent.putExtras(b);
                    Toast toast2 = Toast.makeText(home.this.getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG);
                    toast2.setGravity(81, 0, 0);
                    toast2.show();
                    home.this.startActivity(intent);
                }
            }
        });
    }
}
