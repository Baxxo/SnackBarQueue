package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private final SnackBarQueue snackBarQueue = new SnackBarQueue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View viewById = findViewById(R.id.constraintLayout);

        for (int i = 0; i < SnackBarQueue.MAX_QUEUE_SIZE; i++) {
            Snackbar make = Snackbar.make(viewById, "Snack " + i, Snackbar.LENGTH_LONG);
            make.setAction("OK", v1 -> make.dismiss());
            snackBarQueue.enqueue(make);
        }

        snackBarQueue.showNext();

    }
}