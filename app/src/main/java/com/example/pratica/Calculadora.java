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
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculadora#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculadora extends Fragment {

    public ArrayList<String> line;
    public String actual;
    public String displayer;
    
    
    Button bthome;
    Button bt_zero;
    Button bt_um;
    Button bt_dois;
    Button bt_tres;
    Button bt_quatro;
    Button bt_cinco;
    Button bt_seis;
    Button bt_sete;
    Button bt_oito;
    Button bt_nove;
    Button bt_somar;
    Button bt_subtrair;
    Button bt_multiplicar;
    Button bt_dividir;
    Button bt_porcentagem;
    Button bt_inverte;
    Button bt_virgula;
    Button bt_clear;
    Button bt_igual;

    TextView outdoor;
    /* 
    public boolean lastisOp(){
        int size = this.line.size()-1;
        if(this.line.get(size) == "*" && this.line.get(size) == "/" && this.line.get(size) == "%" && this.line.get(size) == "-" && this.line.get(size) == "+"){
            return true;
        }
        return false;
    }
    */

    


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.actual = "";
        this.displayer = "";
        this.line = new ArrayList<String>();
        
        bthome = view.findViewById(R.id.bt_bthome_calculadora);

        bt_zero = view.findViewById(R.id.button_zero); //
        bt_um = view.findViewById(R.id.button_1);//
        bt_dois = view.findViewById(R.id.button_2);//
        bt_tres = view.findViewById(R.id.button_3);//
        bt_quatro = view.findViewById(R.id.button_4);//
        bt_cinco = view.findViewById(R.id.button_5);//
        bt_seis = view.findViewById(R.id.button_6);//
        bt_sete = view.findViewById(R.id.button_7);//
        bt_oito = view.findViewById(R.id.button_8);//
        bt_nove = view.findViewById(R.id.button_9);//
        bt_somar = view.findViewById(R.id.button_soma);//
        bt_subtrair = view.findViewById(R.id.button_subtrair);//
        bt_multiplicar = view.findViewById(R.id.button_X);//
        bt_dividir = view.findViewById(R.id.button_divisao);//
        bt_porcentagem = view.findViewById(R.id.button_percentagem);//
        //bt_inverte = view.findViewById(R.id.button_negativo);
        bt_virgula = view.findViewById(R.id.butao_virgula);
        bt_clear = view.findViewById(R.id.button_C);
        bt_igual = view.findViewById(R.id.button_igual);
        
        outdoor = view.findViewById(R.id.txt_title_calculadora);
        
        bt_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("0");
                outdoor.setText(displayer);
            }
        });
        
        bt_um.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("1");
                outdoor.setText(displayer);
            }
        });
        
        
        bt_dois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("2");
                outdoor.setText(displayer);
            }
        });
        
        
        bt_tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("3");
                outdoor.setText(displayer);
            }
        });
        
        bt_quatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("4");
                outdoor.setText(displayer);
            }
        });
        
        bt_cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("5");
                outdoor.setText(displayer);
            }
        });
        
        bt_seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("6");
                outdoor.setText(displayer);
            }
        });
        
        bt_sete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("7");
                outdoor.setText(displayer);
            }
        });
        
        bt_oito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("8");
                outdoor.setText(displayer);
            }
        });
        
        bt_nove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("9");
                outdoor.setText(displayer);
            }
        });
        
        bt_somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    addSymbol("+");
                    outdoor.setText(displayer);
            }
        });
        
        bt_subtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    addSymbol("-");
                    outdoor.setText(displayer);
            }
        });
        
        bt_multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    addSymbol("x");
                    outdoor.setText(displayer);
            }
        });
        
        bt_dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    addSymbol("/");
                    outdoor.setText(displayer);
            }
        });
        
        bt_porcentagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    addSymbol("%");
                    outdoor.setText(displayer);
            }
        });
        
        bt_virgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(",");
                outdoor.setText(displayer);
            }
        });
        
        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                this.line.clear();
                this.actual = "";
                this.displayer="";
                outdoor.setText(displayer);
            }
        });
        
        
        bt_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol("=");
                String resultado = String.valueOf(terminator());
                outdoor.setText(resultado);
                addSymbol("C");
            }
        });
        
        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                Fragment home = Home.newInstance("","");
                ft.replace(R.id.fragmentContainerView, home);
                ft.addToBackStack(null);
                ft.commit();

            }
        });
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Calculadora() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Calculadora.
     */
    // TODO: Rename and change types and number of parameters
    public static Calculadora newInstance(String param1, String param2) {
        Calculadora fragment = new Calculadora();
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
        return inflater.inflate(R.layout.fragment_calculadora, container, false);
    }



    public void addSymbol(String simbolo){
        if(this.line.size() < 19){
        switch(simbolo){
            case "0":
                this.actual+="0";
                this.displayer+="0";
                break;
            case "1":
                this.actual+="1";
                this.displayer+="1";
                break;
            case "2":
                this.actual+="2";
                this.displayer+="2";
                break;
            case "3":
                this.actual+="3";
                this.displayer+="3";
                break;
            case "4":
                this.actual+="4";
                this.displayer+="4";
                break;
            case "5":
                this.actual+="5";
                this.displayer+="5";
                break;
            case "6":
                this.actual+="6";
                this.displayer+="6";
                break;
            case "7":
                this.actual+="7";
                this.displayer+="7";
                break;
            case "8":
                this.actual+="8";
                this.displayer+="8";
                break;
            case "9":
                this.actual+="9";
                this.displayer+="9";
                break;
            case ",":
                this.actual+=".";
                this.displayer+=".";
                break;
            case "+":
                this.line.add(this.actual);
                this.line.add("+");
                this.displayer+="+";
                this.actual = "";
                break;
            case "-":
                this.line.add(this.actual);
                this.line.add("-");
                this.displayer+="-";
                this.actual = "";
                break;
            case "x":
                this.line.add(this.actual);
                this.line.add("*");
                this.displayer+="*";
                this.actual = "";
                break;
            case "/":
                this.line.add(this.actual);
                this.line.add("/");
                this.displayer+="/";
                this.actual = "";
                break;
            case "%":
                this.line.add(this.actual);
                this.line.add("%");
                this.displayer+="%";
                this.actual = "";
                break;
            case "=":
                this.line.add(this.actual);
                this.actual = "";
                break;
        }
        }
    }


    public double calculate(String f,String op,String s){
        double valorf = Double.parseDouble(f);
        double valors = Double.parseDouble(s);
        switch(op){
          case "+":
            return valorf + valors;
          case "-":
            return valorf - valors;
          case "/":
            return valorf / valors;
          case "*":
            return valorf * valors;
          case "%":
            return valorf * valors/100;
          default:
            return 0;
        }
    }

    public double terminator(){
        int i = 1;
        double result = 0;
        
        while(this.line.contains("*")){
            int pos = this.line.indexOf("*");
            result = this.calculate(this.line.get(pos-1),"*",this.line.get(pos+1));
            this.line.set(pos-1, String.valueOf(result));
            this.line.remove(pos);
            this.line.remove(pos);
          }
          
          while(this.line.contains("/")){
            int pos = this.line.indexOf("/");
            result = this.calculate(this.line.get(pos-1),"/",this.line.get(pos+1));
            this.line.set(pos-1, String.valueOf(result));
            this.line.remove(pos);
            this.line.remove(pos);
          }
          
          while(this.line.contains("%")){
            int pos = this.line.indexOf("%");
            result = this.calculate(this.line.get(pos-1),"%",this.line.get(pos+1));
            this.line.set(pos-1, String.valueOf(result));
            this.line.remove(pos);
            this.line.remove(pos);
          }
        
        while(this.line.size() > 1){
            result = this.calculate(this.line.get(i-1),this.line.get(i),this.line.get(i+1));
            this.line.set(i-1,String.valueOf(result));
            this.line.remove(i);
            this.line.remove(i);
        }
        return result;
      }
      
}