package com.example.android.datamanagementpreffragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Open a User Preferences Entry Activity
        final Button button = (Button) findViewById(R.id.check_pref_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(
                        MainActivity.this,
                        ViewAndUpdatePreferencesActivity.class));
            }
        });
    }
}
