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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class calculator extends AppCompatActivity {

    DrawerLayout drawerLayout;

    TextView workingsTV;
    TextView resultsTV;

    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        drawerLayout = findViewById(R.id.drawer_layout);

        initTextView();
    }

    //Calculator starts here

    public void initTextView() {
        workingsTV = (TextView) findViewById(R.id.workingsTextView);
        resultsTV = (TextView) findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue) {
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void clearOnClick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
    }

    public void equalOnClick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double) engine.eval(workings);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if (result != null)
            resultsTV.setText(String.valueOf(result.doubleValue()));
    }

    public void jpyToUsdOnClick(View view) {
        //1JYP = 0.0096USD
        ConvertCurrency(0.0096);
    }

    public void usdToInrOnClick(View view) {
        ConvertCurrency(73.63);
    }

    public void inrToUsdOnClick(View view) {
        ConvertCurrency(0.014);
    }

    public void gbpToUsdOnClick(View view) {
        ConvertCurrency(1.34);
    }

    private void ConvertCurrency(double v) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double) engine.eval(workings);
            result = result * v;
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if (result != null)
            resultsTV.setText(String.valueOf(result.doubleValue()));
    }


    public void oneOnClick(View view) {
        setWorkings("1");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void threeOnClick(View view) {
        setWorkings("3");
    }

    public void plusOnClick(View view) {
        setWorkings("+");
    }

    public void fourOnnClick(View view) {
        setWorkings("4");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void minusOnClick(View view) {
        setWorkings("-");
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void eightOnClick(View view) {
        setWorkings("8");
    }

    public void nineOnClick(View view) {
        setWorkings("9");
    }

    public void divideOnClick(View view) {
        setWorkings("/");
    }

    public void dotOnClick(View view) {
        setWorkings(".");
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
    }

    public void multiplyOnClick(View view) {
        setWorkings("*");
    }


    //Hamburger starts here
    public void ClickMenu(View view) {
        dashboard.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        dashboard.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view) {
        dashboard.redirectActivity(this, dashboard.class);
    }

    public void ClickChat(View view) {
        redirectAct(this);
    }

    public static void redirectAct(final Activity activity) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/WannaVisitBot"));
        activity.startActivity(intent);
    }

    public void ClickCalculator(View view) {
        recreate();
    }

    public void ClickLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
    }

    public void ClickExit(View view) {
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dashboard.closeDrawer(drawerLayout);
    }


}