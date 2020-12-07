package com.example.wannavisit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class calculator extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private View viw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void ClickMenu(View viw){
        dashboard.openDrawer(drawerLayout);
    }

    public void ClickLogo(View viw){
        dashboard.closeDrawer(drawerLayout);
    }

    public void ClickHome(View viw){
        dashboard.redirectActivity(this, dashboard.class);
    }

    public void ClickChat(View view){
        redirectAct(this);
    }

    //May get error
    public static void redirectAct(final Activity activity) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/WannaVisitBot"));
        activity.startActivity(intent);
    }

    public void ClickCalculator(View viw){
        recreate();
    }

    public void ClickLogout(View viw){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
    }

    public void ClickExit(View viw){
        finish();
        System.exit(0);

//        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();

        dashboard.closeDrawer(drawerLayout);
    }
}