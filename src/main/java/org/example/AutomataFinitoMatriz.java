package org.example;

public class AutomataFinitoMatriz extends AutomataFinito{

    private int [] [] matriz;

    public AutomataFinitoMatriz(int num, int alfabeto) {
        super(num, alfabeto);
    }

    public AutomataFinitoMatriz(int num, int alfabeto, boolean[] finales, int[][] m) {
        super(num, alfabeto, finales);
        this.matriz=m;
    }

    @Override
    public int transicion(int estado, int letra) {
        int t=this.matriz[estado][letra];
        if(t!=-1){
            return t;
        }
        return 0;
    }

    @Override
    public int cierreTransicion(int estado, int[] cadena) {
        int estadoFinal=-1;
        if (cadena.length>0){
            estadoFinal=transicion(estado,cadena[0]);
            for(int i=0;i<cadena.length;i++){
                estadoFinal=transicion(estado,cadena[i]);
            }
        }
        return estadoFinal;
    }

    @Override
    public boolean perteneceLenguaje(int[] cadena) {
        int i=cierreTransicion(0,cadena);
        if(i==-1){
          return false;
        }
        return super.getFinales()[i];
    }
}
