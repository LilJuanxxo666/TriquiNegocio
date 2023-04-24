package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tablero {
    private Map<Byte, Casilla> tablero = new HashMap<>();

    public Tablero(){
        inicializar();
    }

    private void inicializar() {
        for (byte indice = 1; indice <= 9; indice++) {
            tablero.put(indice, new Casilla(indice));
        }
    }
    public Map<Byte, Casilla> getTablero(){
        return tablero;
    }
    public void toStringTablero(){
        byte indice = 1;
        System.out.println("-------");
        for (int fila = 0; fila < 3; fila++) {
            System.out.print("|");
            for (int columna = 0; columna < 3; columna++) {
                if(tablero.get(indice).getSimbolo().equals("")){
                    System.out.print(" |");
                }else{
                    System.out.print(tablero.get(indice).getSimbolo() + "|");
                }
                indice += 1;
            }
            System.out.println();
        }
        System.out.println("-------");
    }
    public boolean ternaEsValida() {
        byte[][] terna = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};
        List<Casilla> casillas = new ArrayList<>();
        for (byte[] bytes : terna) {
            casillas.clear();
            casillas.add(tablero.get(bytes[0]));
            casillas.add(tablero.get(bytes[1]));
            casillas.add(tablero.get(bytes[2]));
            if(casillas.stream().map(Casilla::getSimbolo).distinct().count() == 1 && casillas.get(0).estaMarcada()){
                break;
            }
        }
        return casillas.stream().map(Casilla::getSimbolo).distinct().count() == 1 && casillas.get(0).estaMarcada();
    }
}