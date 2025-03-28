package com.example.pratica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Selos extends Fragment {

    public Integer scinco;
    public Integer sdois;
    public Integer sum;

    TextView TROCO;
    EditText valorDinheiroEditText;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.scinco = 0;
        this.sdois = 0;
        this.sum = 0;
        TROCO = view.findViewById(R.id.converter_selos_troco); // Corrigido para pegar a referência correta do TextView
        valorDinheiroEditText = view.findViewById(R.id.converter_dinheiro_selos);
        Button converterButton = view.findViewById(R.id.button_converter_selos);

        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorDinheiroStr = valorDinheiroEditText.getText().toString();
                if (!valorDinheiroStr.isEmpty()) {
                    int valorDinheiro = Integer.parseInt(valorDinheiroStr);
                    trocos(valorDinheiro);
                    TROCO.setText("€5 =" + scinco.toString() + "\n€2 = " + sdois.toString()+"\n€1 = "+sum.toString());
                }
            }
        });
    }


    public Selos() {

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


    public void trocos(int euros) {
        this.scinco = 0;
        this.sdois = 0;
        this.sum = 0;
        while(euros > 0){
            if(euros>=5){
                this.scinco++;
                euros-=5;
            }else if(euros >= 2){
                this.sdois++;
                euros-=2;
            }else if(euros>=1){
                this.sum++;
                euros--;
            }
        }
    }
}