package com.example.wannavisit;

//import androidx.annotation.NonNull;
//import androidx.appcompat.app.ActionBarDrawerToggle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

//import com.google.android.material.navigation.NavigationView;

public class dashboard extends AppCompatActivity {
    //implements NavigationView.OnNavigationItemSelectedListener
//    private DrawerLayout drawer;
    Button mGateway, mMarine, mNehru, mPark, mClink;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Drawable Feature OR Hamburger Icon

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        drawer = findViewById(R.id.drawer_layout);

//        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
//                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//
//        drawer.addDrawerListener(toggle);
//
//        toggle.syncState();


        //Main Content
        mGateway = findViewById(R.id.gateway_h);
        mMarine = findViewById(R.id.marine_h);
        mNehru = findViewById(R.id.nehru_h);
        mPark = findViewById(R.id.sanjay_h);
        mClink = findViewById(R.id.sealink_h);

        mGateway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), gateway.class));
            }
        });

        mMarine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    public void ClickMenu(View viw){
        //open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close Drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //close drawer layout
        //check condition
        if(drawerLayout.isDrawerOpen((GravityCompat.START))){
            //when it is open
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        recreate();
    }

    public void ClickChat(View view){
        redirectAct(this);
    }

    //May get error
    public static void redirectAct(final Activity activity) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/WannaVisitBot"));
        activity.startActivity(intent);
    }

    public void ClickCalculator(View view){
        redirectActivity(this,calculator.class);
    }

    public void ClickExit(View view){
//        super.onDestroy();
        finish();
        System.exit(0);
    }


    public void ClickLogout(View view){
//        logout(this);
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
    }

//    public static void logout(final Activity activity){
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        builder.setTitle("Logout");
//        builder.setMessage("Do you want to Logout?");
//
//        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(getApplicationContext(), login.class));
//                finish();
////                activity.finishAffinity();
////                System.exit(0);
//            }
//        });
//
//        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        builder.show();
//    }

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

    //    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch(item.getItemId()){
//            case R.id.nav_chat:
//                break;
//            case R.id.nav_calculate:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new calculatorFrag()).commit();
//                break;
//        }
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    //Back press handling
//    @Override
//    public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }


}