package com.example.pratica;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class Selos extends Fragment{

   public Integer scinco;
   public Integer stres;

   TextView TROCO;
   

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.scinco = 0;
        this.stres = 0;
        TROCO = view.findViewById(R.id.txt_troco);
        this.trocos(12);
        TROCO.setText("CINCO:"+this.scinco.toString()+"   "+"TRES:"+this.stres.toString());
    }
    
    public Selos(){
        
    }
    
    
        // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    
    
    
    public static Selos newInstance(String param1, String param2) {
        Selos fragment = new Selos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selos, container, false);
    }
    
    
    
    
    public void trocos(int euros){
        if(euros >= 8){
	        Integer Quoc = euros/8;
    	        int R = euros % 8;
	        switch(R){
		        case 0:
			        this.scinco = Quoc;
			        this.stres = Quoc;
			        break;
		        case 1:
			        this.scinco = Quoc - 1;
    			        this.stres = Quoc + 2;
    			        break;
		        case 2:
			        this.scinco = Quoc + 1;
			        this.stres = Quoc - 1;
			        break;
		        case 3:
			        this.scinco = Quoc;
			        this.stres = Quoc + 1;
			        break;
		        case 4:
			        this.scinco = Quoc - 1;
			        this.stres = Quoc + 3;
			        break;
		        case 5:
			        this.scinco = Quoc + 1;
			        this.stres = Quoc;
			        break;
		        case 6:
			        this.scinco = Quoc;
			        this.stres = Quoc + 2;
			        break;
		        case 7:
			        this.scinco = Quoc + 2;
			        this.stres = Quoc - 1;
			        break;
            }
        } else {
	        if(euros == 3 || euros == 5){
		        this.stres = 1;
	        } else if( euros == 6){
		        this.stres = 2;
	        } else {
		        System.out.println("devolver euros");
	        }
        }
    }
}
