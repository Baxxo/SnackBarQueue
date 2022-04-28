package com.example.myapplication;

import com.google.android.material.snackbar.Snackbar;

import java.util.Stack;

public class SnackBarQueue {

    public static final int MAX_QUEUE_SIZE = 5;

    private final Stack<Snackbar> stack = new Stack<>();

    public void enqueue(Snackbar snackbar) {
        snackbar.addCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                super.onDismissed(snackbar, event);
                stack.remove(snackbar);
                showNext();
            }
        });
        if (stack.size() == MAX_QUEUE_SIZE) {
            stack.pop();
        }
        stack.push(snackbar);
    }

    public void showNext() {
        if (!stack.isEmpty()) {
            Snackbar snackbar = stack.pop();
            snackbar.show();
        }
    }
}
