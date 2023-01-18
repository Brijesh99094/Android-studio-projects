package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnLeft, btnRight, btnMiddle;
    FrameLayout frmLayLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","created");

        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRIght);
        btnMiddle = (Button) findViewById(R.id.btnMiddle);
        frmLayLayout = (FrameLayout) findViewById(R.id.frmLayout);

        loadFragment(new BlankFragment());
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
        btnMiddle.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Log.d("btnCLick", view.getId() + "");
        switch (view.getId()){
            case R.id.btnLeft:
                Log.d("btnCLick",  "Left");
                loadFragment(new LeftFragment());
                break;
            case  R.id.btnMiddle:
                Log.d("btnCLick",  "Middle");
                loadFragment(new BlankFragment());
                break;
            case R.id.btnRIght:
                Log.d("btnCLick",  "Right");
                loadFragment(new RightFragment());
                break;
        }
    }

    @SuppressWarnings("deprecation")
    private void loadFragment(Fragment fragment){
        FragmentManager fM = getFragmentManager();
        FragmentTransaction fT = fM.beginTransaction();
        fT.replace(R.id.frmLayout, fragment);
        fT.commit();
    }
}