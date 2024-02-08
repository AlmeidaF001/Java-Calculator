package com.example.pratica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculadora#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculadora extends Fragment {

    public ArrayList<String> line;
    public String actual;
    public String displayer;

    //Lista dos botões da calculadora e do display
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

    //Função que é chamada quando o fragment é criado
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
        bt_virgula = view.findViewById(R.id.button_virgula);
        bt_clear = view.findViewById(R.id.button_C);
        bt_igual = view.findViewById(R.id.button_igual);

        outdoor = view.findViewById(R.id.txt_resultado);


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
        //Configuração de listeners dos botões da calculadora
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
                //this.line.clear();
                //this.actual = "";
                //this.displayer="";
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
                Fragment home = Home.newInstance("", "");
                ft.replace(R.id.fragmentContainerView, home);
                ft.addToBackStack(null);
                ft.commit();

            }
        });
    }


    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Construtor Padrão
    public Calculadora() {
    }

    //Método que cria uma nova instância do fragmento da Calculadora e cria um pacote de argumentos (Bundle) para passar dados para o fragmento
    //Define também os argumentos passados durante a criação do fragmento e retorna uma instancia do fragmento
    public static Calculadora newInstance(String param1, String param2) {
        Calculadora fragment = new Calculadora();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    // Metodo chamado quando o Fragmento está a ser criado, e verifica se existem argumentos passados durante a criação do fragmento
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //Recebe os argumentos passados durante a criação do fragmento
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    //
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_calculadora, container, false);
    }

    //Faz a verificação se a expressão excedeu o limite de 19 Operações e Adicioona que corresponde a expressão digitada
    //Aplica restrições de operações e números
    public void addSymbol(String simbolo) {
        if (this.line.size() < 19) {
            switch (simbolo) {
                case "0":
                    this.actual += "0";
                    this.displayer += "0";
                    break;
                case "1":
                    this.actual += "1";
                    this.displayer += "1";
                    break;
                case "2":
                    this.actual += "2";
                    this.displayer += "2";
                    break;
                case "3":
                    this.actual += "3";
                    this.displayer += "3";
                    break;
                case "4":
                    this.actual += "4";
                    this.displayer += "4";
                    break;
                case "5":
                    this.actual += "5";
                    this.displayer += "5";
                    break;
                case "6":
                    this.actual += "6";
                    this.displayer += "6";
                    break;
                case "7":
                    this.actual += "7";
                    this.displayer += "7";
                    break;
                case "8":
                    this.actual += "8";
                    this.displayer += "8";
                    break;
                case "9":
                    this.actual += "9";
                    this.displayer += "9";
                    break;
                case ",":
                    this.actual += ".";
                    this.displayer += ".";
                    break;
                case "+":
                    this.line.add(this.actual);
                    this.line.add("+");
                    this.displayer += "+";
                    this.actual = "";
                    break;
                case "-":
                    this.line.add(this.actual);
                    this.line.add("-");
                    this.displayer += "-";
                    this.actual = "";
                    break;
                case "x":
                    this.line.add(this.actual);
                    this.line.add("*");
                    this.displayer += "*";
                    this.actual = "";
                    break;
                case "/":
                    this.line.add(this.actual);
                    this.line.add("/");
                    this.displayer += "/";
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
        }
    }

    //Realiza o calculo da expressão de acordo com a operação
    public double calculate(String f, String op, String s) {
        double valorf = Double.parseDouble(f);
        double valors = Double.parseDouble(s);
        switch (op) {
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


    //Realiza a avaliação da expressão em formato de lista
    public double terminator() {
        int i = 1;
        double result = 0;

        while (this.line.contains("*")) {
            int pos = this.line.indexOf("*");
            result = this.calculate(this.line.get(pos - 1), "*", this.line.get(pos + 1));
            this.line.set(pos - 1, String.valueOf(result));
            this.line.remove(pos);
            this.line.remove(pos);
        }

        while (this.line.contains("/")) {
            int pos = this.line.indexOf("/");
            result = this.calculate(this.line.get(pos - 1), "/", this.line.get(pos + 1));
            this.line.set(pos - 1, String.valueOf(result));
            this.line.remove(pos);
            this.line.remove(pos);
        }

        while (this.line.contains("%")) {
            int pos = this.line.indexOf("%");
            result = this.calculate(this.line.get(pos - 1), "%", this.line.get(pos + 1));
            this.line.set(pos - 1, String.valueOf(result));
            this.line.remove(pos);
            this.line.remove(pos);
        }

        while (this.line.size() > 1) {
            result = this.calculate(this.line.get(i - 1), this.line.get(i), this.line.get(i + 1));
            this.line.set(i - 1, String.valueOf(result));
            this.line.remove(i);
            this.line.remove(i);
        }
        return result;
    }

}