package com.herokuapp.ezhao.colors;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends FragmentActivity {
    RelativeLayout rlScreen;
    TextView tvHex;
    Random randomGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlScreen = (RelativeLayout) findViewById(R.id.rlScreen);
        tvHex = (TextView) findViewById(R.id.tvHex);
        randomGenerator = new Random();
        setRandomBackground(null);
    }

    public void setRandomBackground(View view) {
        int color = Color.argb(255, randomGenerator.nextInt(255), randomGenerator.nextInt(255), randomGenerator.nextInt(255));
        String hexColor = String.format("#%06X", (0xFFFFFF & color));
        rlScreen.setBackgroundColor(color);
        tvHex.setText(hexColor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
