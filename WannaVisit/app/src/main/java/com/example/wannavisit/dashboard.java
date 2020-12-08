package com.example.wannavisit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.view.MenuItem;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class dashboard extends AppCompatActivity {

    Button mGateway, mMarine, mNehru, mPark, mClink;
    DrawerLayout drawerLayout;

//    String fileName = "";
//    String filePath = "";
//    String fileContent = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Main Content
        mGateway = findViewById(R.id.gateway_h);
        mMarine = findViewById(R.id.marine_h);
        mNehru = findViewById(R.id.nehru_h);
        mPark = findViewById(R.id.sanjay_h);
        mClink = findViewById(R.id.sealink_h);

//        fileName = "wannavisit.txt";
//        filePath = "wannavisit";

//        File file = new File(getExternalFilesDir(filePath), fileName);


//        String state = Environment.getExternalStorageState();
//
//        if (Environment.MEDIA_MOUNTED.equals(state)) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        mGateway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //visited gateway
//                File root = android.os.Environment.getExternalStorageDirectory();
//                File dir = new File(root.getAbsolutePath() + "/wannavisit");
//                dir.mkdirs();
//                File file = new File(dir, "wv.txt");
//
////        File file = new File("/sdcard/mymyfilefile.txt");
////        try {
////            file.createNewFile();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//                try {
//                    FileOutputStream f = new FileOutputStream(file);
//                    PrintWriter pw = new PrintWriter(f);
//                    pw.println("Hi , How are you");
//                    pw.println("Explored Gateway of India");
//                    pw.flush();
//                    pw.close();
//                    f.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
////            Log.i(TAG, "******* File not found. Did you" +
////                    " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                fileContent = "Explored Gateway of India";

                startActivity(new Intent(getApplicationContext(), gateway.class));
            }
        });

        mMarine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fileContent = "Explored Marine Drive.";
                startActivity(new Intent(getApplicationContext(), marine.class));
            }
        });

        mNehru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), nehru.class));
            }
        });

        mPark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), sanjay.class));
            }
        });

        mClink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), clink.class));
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View viw) {
        //open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view) {
        //Close Drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //close drawer layout
        //check condition
        if (drawerLayout.isDrawerOpen((GravityCompat.START))) {
            //when it is open
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view) {
        recreate();
    }

    public void ClickChat(View view) {
        redirectAct(this);
    }


    public static void redirectAct(final Activity activity) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/WannaVisitBot"));
        activity.startActivity(intent);
    }

    public void ClickCalculator(View view) {
        redirectActivity(this, calculator.class);
    }

    public void ClickExit(View view) {
        finish();
    }


    public void ClickLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
    }

    public static void redirectActivity(Activity activity, Class one) {
        Intent intent = new Intent(activity, one);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}