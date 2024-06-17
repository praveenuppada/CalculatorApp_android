package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.internal.NavigationMenu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    public EditText e1, e2;

    TextView t1;

    int num1, num2;

    public boolean getNumbers() {
        String s1 = e1.getText().toString();

        String s2 = e2.getText().toString();

        if (s1.equals("Please enter value 1") && s2.equals(null)) {
            String result = "Please enter value 2";
            e2.setText(result);
            return false;
        }
        if (s1.equals(null) && s2.equals("Please enter value 2")) {
            String result = "Please enter value 1";
            e1.setText(result);
            return false;
        }
        if (s1.equals("Please enter value 1") || s2.equals("Please enter value 2")) {
            return false;
        }
        if ((!s1.equals(null) && s2.equals(null)) || (!s1.equals("") && s2.equals(""))) {
            String result = "Please enter value 2";
            e2.setText(result);
            return false;
        }
        if ((s1.equals(null) && !s2.equals(null)) || (s1.equals("") && !s2.equals(""))) {
            String result = "Please enter value 1";
            e1.setText(result);
            return false;
        }
        if (s1.equals(null) && s2.equals(null) || s1.equals("") && s2.equals("")) {
            String result1 = "Please enter value 1";
            e1.setText(result1);
            String result2 = "Please enter value 2";
            e2.setText(result2);
            return false;
        } else {
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);
        }
        return true;
    }

    public void doSum(View v) {
        if (getNumbers()) {
            int sum = num1 + num2;
            t1.setText(Integer.toString(sum));
        } else {
            t1.setText("Error Please enter required values");
        }
    }

    public void clearTextNum1(View v) {
        e1.getText().clear();
    }

    public void clearTextNum2(View v) {
        e2.getText().clear();
    }

    public void doPow(View v) {
        if (getNumbers()) {
            double sum  = Math.pow(num1, num2);
            t1.setText(Double.toString(sum));
        } else {
            t1.setText("Error Please enter required values");
        }
    }

    public void doSub(View v) {
        if (getNumbers()) {
            int sum = num1 - num2;
            t1.setText(Integer.toString(sum));
        }
        else {
            t1.setText("Error Please enetr required values");
        }
    }

    public void doMul(View v) {
        if (getNumbers()) {
            int sum = num1 * num2;
            t1.setText(Integer.toString(sum));
        }
        else {
            t1.setText("Error Please enter required values");
        }
    }

    public void doDiv(View v) {
        if (getNumbers()) {
            double sum = num1 / (num2 * 1.0);
            t1.setText(Double.toString(sum));
        } else {
            t1.setText("Error Please enter required values");
        }
    }

    public void doMod(View v) {
        if (getNumbers()) {
            double sum = num1 % num2;
            t1.setText(Double.toString(sum));
        } else {
            t1.setText("Error Please enter required values");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.num1);
        e2 = (EditText) findViewById(R.id.num2);
        t1 = (TextView) findViewById(R.id.result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id  = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp (navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}