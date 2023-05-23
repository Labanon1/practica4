package org.example;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorLexico {
    private AutomataFinito automata;
    private int[] cadena;
    private int posActual;
    private Token tokens;
    private List<Token> historico;

    public AnalizadorLexico(AutomataFinito af, int[] c, Token t){
        this.automata=af;
        this.cadena=c;
        this.posActual=0;
        this.tokens=t;
        this.historico=new ArrayList<Token>();
    }

    public Token nextToken() {

    }

    public boolean hasMoreTokens(){
        if (this.automata.getNumEstados()>this.historico.size()){
            return true;
        }
        return false;
    }

    public List<Token> getHistorico(){
        return this.historico;
    }

    public void reset(){
        this.posActual=0;
        this.historico=new ArrayList();
    }
    public void nuevaCadena(int[] c){
        this.cadena=c;
        this.posActual=0;
        this.historico.clear();
    }
    public void finalizarAnalisis(){
        this.cadena=null;
        this.posActual=0;
        this.historico.clear();
    }


}
