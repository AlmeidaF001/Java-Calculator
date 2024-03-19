package com.example.pratica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class Calculadora extends Fragment {

    public ArrayList<String> line;
    public String actual;
    public String displayer;

    //region Inicialização dos botões e TextView
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
    Button bt_virgula;
    Button bt_clear;
    Button bt_delete;
    Button bt_igual;
    TextView outdoor;

    //endregion
    @Override

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.actual = "";
        this.displayer = "";
        this.line = new ArrayList<String>();

        //Incialização dos botões e TextView
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
        bt_virgula = view.findViewById(R.id.button_virgula);
        bt_clear = view.findViewById(R.id.button_C);
        bt_delete = view.findViewById(R.id.button_DEL);
        bt_igual = view.findViewById(R.id.button_igual);

        //Inicialização do TextView
        outdoor = view.findViewById(R.id.txt_resultado);
        bthome = view.findViewById(R.id.bt_bthome_calculadora);

        //region Tratamento de eventos dos botões
        bt_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canAddZero()) {
                    if (maxSize()) {
                        addSymbol("0");
                        outdoor.setText(displayer);
                    } else {
                        Toast.makeText(getActivity(), "Tamanho maximo atingido", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        bt_um.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxSize()) {
                    addSymbol("1");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Tamanho maximo atingido", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_dois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxSize()) {
                    addSymbol("2");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Tamanho maximo atingido", Toast.LENGTH_LONG).show();
                }
            }
        });


        bt_tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxSize()) {
                    addSymbol("3");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Tamanho maximo atingido", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_quatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxSize()) {
                    addSymbol("4");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Tamanho maximo atingido", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxSize()) {
                    addSymbol("5");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Tamanho maximo atingido", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxSize()) {
                    addSymbol("6");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Tamanho maximo atingido", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_sete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxSize()) {
                    addSymbol("7");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Tamanho maximo atingido", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_oito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxSize()) {
                    addSymbol("8");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Tamanho maximo atingido", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_nove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maxSize()) {
                    addSymbol("9");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Tamanho maximo atingido", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canAdd()) {
                    addSymbol("+");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Operação invalida!", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_subtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canAdd()) {
                    addSymbol("-");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Operação invalida!", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canAdd()) {
                    addSymbol("x");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Operação invalida!", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canAdd()) {
                    addSymbol("/");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Operação invalida!", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_porcentagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canAdd()) {
                    addSymbol("%");
                    outdoor.setText(displayer);
                } else {
                    Toast.makeText(getActivity(), "Operação invalida!", Toast.LENGTH_LONG).show();
                }
            }
        });

        bt_virgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canAddPoint()) {
                    addSymbol(",");
                    outdoor.setText(displayer);
                }
            }
        });

        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                outdoor.setText(displayer);
            }
        });

        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteLast();
                outdoor.setText(displayer);
            }
        });


        bt_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(canSolve() && notBlank()){
                addSymbol("=");
                String resultado = String.valueOf(terminator());
                outdoor.setText(resultado);
                reset();

                if (canSolve() && notBlank()) {
                    addSymbol("=");
                    String resultado = String.valueOf(terminator());
                    outdoor.setText(resultado);
                    reset();

                }

            }
        });

        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                Fragment home = Home.newInstance("", "");
                ft.replace(R.id.fragmentContainerView, home);
                ft.addToBackStack(null);
                ft.commit();

            }
        });//endregion
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Calculadora() {

    }

    // Método newInstance é usado para criar uma nova instância de um fragmento e configurar argumentos para essa instância.
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

    // Metodo que  cria e retorna a interface de utilizador associada ao fragmento.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculadora, container, false);
    }

    //Metodo que verifica se ainda é possivel adicionar um operator matematico á expressão atual .
    public boolean canAdd(){
        if(this.displayer.length() > 0){
            char ultimo = this.displayer.charAt(this.displayer.length()-1);
            if(ultimo == '+' || ultimo == '/' || ultimo == '%' || ultimo == '-' || ultimo == '*'){
                return false;
            }
            return true;
        }
        return false;
    }

    //Metodo que verifica se é possivel adicionar uma virgula ao numero.
    public boolean canAddPoint(){
        if(this.actual.length() > 0){
            if(this.actual.indexOf(".") == -1) return true;
        }
        return false;
    }

    //Metodo que verifica se a string actual tem menos de 10 caracteres
    public boolean maxSize(){
        return this.actual.length() < 10;
    }

    //Metodo que verifica se a string actual não está vazia
    public boolean notBlank(){
        return this.actual.length() > 0;
    }

    //metodo que verifica a conta matematica é possivel de resolver
    public boolean canSolve(){
        return this.line.size()%2 == 0;
    }

    //metodo que verifica se é possivel adicionar um digito zero.
    public boolean canAddZero(){
        return !this.actual.equals("0");
    }

    //metodo que verifica se a string actual é negativa.
    public String bUltimo(){
        return this.line.get(this.line.size()-1);
    }

    //metodo que remove o ultimo caracter da string actual e da lista line
    public void deleteLast(){
        if(this.displayer.length() > 0) this.displayer = this.displayer.substring(0, this.displayer.length()-1);
        if(notBlank()){
            this.actual = this.actual.substring(0, this.actual.length()-1);
        } else {
            if(this.line.size() > 0){
                this.line.remove(this.line.size()-1);
                this.actual = this.line.get(this.line.size()-1);
                this.line.remove(this.line.get(this.line.size()-1));
            }
        }
    }

    // region Função addSymbol adiciona ao display o respetivo numero assinalado com base nos botões clicados.
    public void addSymbol(String simbolo){
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
                this.displayer += "%";
                this.actual = "";
                break;
            case "=":
                this.line.add(this.actual);
                this.actual = "";
                break;
        }
    }//endregion

    // Função calculate realiza operações aritméticas com base em dois números com base num operador.
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
                return valorf * valors / 100;
            default:
                return 0;
        }
    }

    // Função reset limpa a lista de strings "line", e as strings "actual" e "displayer".
    public void reset() {
        this.line.clear();
        this.actual = "";
        this.displayer = "";
    }

    // O método terminator realiza operações aritméticas numa lista de strings chamada "line".
    // Ele processa os operadores '*', '/', e '%' primeiro, seguidos pelos operadores restantes em ordem.
    // O resultado final é retornado.
    public double terminator() {
        int i = 1;
        double result = 0;

        // Processa operadores '*'
        while (this.line.contains("*")) {
            int pos = this.line.indexOf("*");
            result = this.calculate(this.line.get(pos - 1), "*", this.line.get(pos + 1));
            this.line.set(pos - 1, String.valueOf(result));
            this.line.remove(pos);
            this.line.remove(pos);
        }
        // Processa operadores '/'
        while (this.line.contains("/")) {
            int pos = this.line.indexOf("/");
            result = this.calculate(this.line.get(pos - 1), "/", this.line.get(pos + 1));
            this.line.set(pos - 1, String.valueOf(result));
            this.line.remove(pos);
            this.line.remove(pos);
        }
        // Processa operadores '%'
        while (this.line.contains("%")) {
            int pos = this.line.indexOf("%");
            result = this.calculate(this.line.get(pos - 1), "%", this.line.get(pos + 1));
            this.line.set(pos - 1, String.valueOf(result));
            this.line.remove(pos);
            this.line.remove(pos);
        }
        // Processa operadores restantes por ordem logica
        while (this.line.size() > 1) {
            result = this.calculate(this.line.get(i - 1), this.line.get(i), this.line.get(i + 1));
            this.line.set(i - 1, String.valueOf(result));
            this.line.remove(i);
            this.line.remove(i);
        }
        return result;

    }

}


