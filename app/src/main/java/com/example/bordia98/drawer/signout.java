package com.example.bordia98.drawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by bordia98 on 21/6/17.
 */

public class signout extends Fragment {


    signoutclicklistner activityCommandarsignout;

    public interface signoutclicklistner{
        public void yesclick();
        public void noclick();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommandarsignout =(signoutclicklistner) activity;
        }catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.signout,container,false);
        final Button yesclick = (Button)view.findViewById(R.id.yes);
        final Button noclick = (Button)view.findViewById(R.id.NO);

        yesclick.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        buttoneclick(v);
                    }
                }
        );


        noclick.setOnClickListener(
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
        getActivity().setTitle("Sign  out");
    }


    public void buttoneclick(View view)
    {
        activityCommandarsignout.yesclick();

    }
    public void buttonepick(View view)
    {
        activityCommandarsignout.noclick();
    }

}
