package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Register extends AppCompatActivity {
    private static final String[] paths = {"item 1", "item 2", "item 3"};
    TextView Email;
    TextView JenisTask;
    TextView Lamatask;
    TextView Task;
    FloatingActionButton fab;
    private Spinner spinner;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.register_activity);
        this.Task = (TextView) findViewById(R.id.et_task);
        this.JenisTask = (TextView) findViewById(R.id.et_jenistask);
        this.Lamatask = (TextView) findViewById(R.id.et_lamatask);
        this.Email = (TextView) findViewById(R.id.tf_parsing);
        this.fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        Bundle bundle = getIntent().getExtras();
        String email = bundle.getString("a");
        String string = bundle.getString("b");
        this.Email.setText(email);
        this.fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Register.this.validate();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar) {
            validate();
        } else {
            startActivity(new Intent(getApplicationContext(), Login.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void validate() {
        if (this.Task.getText().toString().isEmpty() && this.JenisTask.getText().toString().isEmpty() && this.Lamatask.getText().toString().isEmpty()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Isi Semua Data ", 1);
            toast.setGravity(81, 0, 0);
            toast.show();
        } else if (this.Task.getText().toString().isEmpty()) {
            this.Task.setError("Masukan Task!");
        } else if (this.JenisTask.getText().toString().isEmpty()) {
            this.JenisTask.setError("Jenis Task!");
        } else if (this.Lamatask.getText().toString().isEmpty()) {
            this.Lamatask.setError("Lama Task!");
        } else {
            Bundle b = new Bundle();
            b.putString("a", this.Task.getText().toString().trim());
            b.putString("b", this.JenisTask.getText().toString().trim());
            b.putString("c", this.Lamatask.getText().toString().trim());
            Intent i = new Intent(getApplicationContext(), hasil.class);
            i.putExtras(b);
            startActivity(i);
            Toast toast2 = Toast.makeText(getApplicationContext(), "Berhasil", 1);
            toast2.setGravity(81, 0, 0);
            toast2.show();
        }
    }
}
