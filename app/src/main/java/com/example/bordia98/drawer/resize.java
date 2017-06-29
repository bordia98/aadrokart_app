package com.example.bordia98.drawer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Activity;
import android.widget.ImageView;


public class resize extends Fragment{


    resizeclickListener activityCommandarresize;

    public interface resizeclickListener{

        public void onrpick();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommandarresize=(resizeclickListener) activity;
        }catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resize,container,false);
        final Button rpick = (Button)view.findViewById(R.id.rpick);




        rpick.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        buttonepick(v);
                    }
                }
        );
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("resize");

    }

     public void buttonepick(View view)
    {
        activityCommandarresize.onrpick();
    }
}
