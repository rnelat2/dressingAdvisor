package edu.illinois.cs.cs125.dressingadvisor;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DressingAdv extends AppCompatActivity {
    private static final String TAG = "dressingAdv:main";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dressing_adv);
        final Button PickClothing = findViewById(R.id.clothing);
        PickClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Pick clothes button clicked");//a
            }
        });
    }
}
