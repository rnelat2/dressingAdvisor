package edu.illinois.cs.cs125.dressingadvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class clothing extends AppCompatActivity {
    private static final String TAG = "clothing:main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
        final Button addclothes = findViewById(R.id.addclothes);
        addclothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Pick clothes button clicked");
            }
        });
        final ImageButton top1 = findViewById(R.id.top1);
        top1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "top1 image clicked");
            }
        });
        final ImageButton top2 = findViewById(R.id.top2);
        top2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "top2 button clicked");
            }
        });
        final ImageButton top3 = findViewById(R.id.top3);
        top3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "top3 button clicked");
            }
        });
        final ImageButton bottom1 = findViewById(R.id.bottom1);
        bottom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "bottom1 button clicked");
            }
        });
        final ImageButton bottom2 = findViewById(R.id.bottom2);
        bottom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "bottom2 button clicked");
            }
        });
        final ImageButton bottom3 = findViewById(R.id.bottom3);
        bottom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "bottom3 button clicked");
            }
        });
        final ImageButton shoe1 = findViewById(R.id.shoe1);
        shoe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "shoe1 button clicked");
            }
        });
        final ImageButton shoe2 = findViewById(R.id.shoe2);
        shoe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "shoe2 button clicked");
            }
        });
        final ImageButton shoe3 = findViewById(R.id.shoe3);
        shoe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "shoe3 button clicked");
            }
        });
        final Button finish = findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "finish button clicked");
            }
        });

    }
}



