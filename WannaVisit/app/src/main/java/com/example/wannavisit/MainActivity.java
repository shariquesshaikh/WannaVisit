package com.example.wannavisit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    Button mNextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNextBtn = findViewById(R.id.next);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File[] Dirs = ContextCompat.getExternalFilesDirs(getApplicationContext(), null);

                File path = Dirs[1];

                path = new File(path + "/wannavisitlog.txt");

                String data = "Welcome to WannaVisit. We are happy to have a user like you. A great product emerges with contribution from the customers like you. We appreciate your effort to use our service. Have a nice day :)";

                try {
                    File file = new File(String.valueOf(path));
                    file.createNewFile();

                    FileOutputStream fout = new FileOutputStream(file, true);
                    fout.write(data.getBytes());
                    fout.close();

                    Toast.makeText(getBaseContext() , "Welcome!", Toast.LENGTH_LONG ).show();

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

                startActivity(new Intent(getApplicationContext(), login.class));
            }
        });

    }
}



