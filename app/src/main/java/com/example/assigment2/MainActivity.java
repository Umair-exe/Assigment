package com.example.assigment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView btn,btn2;
    LinearLayout ll;
    FrameLayout sidebar;
    Boolean check = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.opt);
        sidebar = findViewById(R.id.sidebar_space);
        btn2 = findViewById(R.id.sidebar_opener);
        ll = findViewById(R.id.options);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FragmentManager fm = getSupportFragmentManager();


        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment frag;
        Intent intent;
        if(view.getId() == btn.getId()) {
            check = !check;
            ll.setVisibility(check == false ? view.VISIBLE : view.GONE);
        }

        if(view.getId() == btn2.getId()) {
            sidebar.setVisibility(view.VISIBLE);
            frag = new SidebarFragment();
            ft.replace(R.id.sidebar_space, frag);
            ft.addToBackStack(null);
            ft.commit();

        }
    }
}