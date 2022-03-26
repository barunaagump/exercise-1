package com.example.exercise;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class hasil extends AppCompatActivity {
    TextView Jenis;
    TextView Lama;
    TextView Task;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_hasil);
        this.Task = (TextView) findViewById(R.id.tf_task);
        this.Jenis = (TextView) findViewById(R.id.tf_jenistask);
        this.Lama = (TextView) findViewById(R.id.tf_lama);
        Bundle bundle = getIntent().getExtras();
        String task = bundle.getString("a");
        String jenis = bundle.getString("b");
        String lama = bundle.getString("c");
        this.Task.setText(task);
        this.Jenis.setText(jenis);
        this.Lama.setText(lama);
    }
}
