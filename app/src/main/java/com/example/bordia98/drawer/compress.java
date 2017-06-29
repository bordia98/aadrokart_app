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



public class compress extends Fragment{


    compressclickListener activityCommandar_compress;

    public interface compressclickListener{

        public void oncpick();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommandar_compress=(compressclickListener) activity;
        }catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.compress,container,false);
            final Button cpick = (Button)view.findViewById(R.id.cpick);



        cpick.setOnClickListener(
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
        getActivity().setTitle("compress");

    }


    public void buttonepick(View view)
    {
        activityCommandar_compress.oncpick();
    }
}
