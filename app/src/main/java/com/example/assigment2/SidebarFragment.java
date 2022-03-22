package com.example.assigment2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SidebarFragment extends Fragment implements View.OnClickListener {


   Button close_btn;
   Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sidebar, container, false);
        close_btn = view.findViewById(R.id.closebtn);
        close_btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == close_btn.getId()) {
            //fl.setVisibility(view.GONE);
            intent = new Intent(this.getActivity(),MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        }

    }
}