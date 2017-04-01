package com.msalah.herenow.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.msalah.herenow.R;
import com.msalah.herenow.controller.CallsManager;
import com.msalah.herenow.model.AlarmTypes;
import com.msalah.herenow.model.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show();

        switch (view.getId()) {
            case R.id.here:
                break;
            case R.id.options:
                break;
            case R.id.positive:
                break;
            case R.id.priming:
                break;
            case R.id.user:
                break;

        }
        CallsManager.submitCall(new Call(AlarmTypes.Focus),this);
    }
}
