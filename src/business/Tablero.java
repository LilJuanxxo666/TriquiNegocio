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
        Map<Byte, Casilla> tablero = new HashMap<>();

        for (byte indice = 1; indice <= 9; indice++) {
            tablero.put(indice, this.tablero.get(indice).cloneCasilla());
        }
        return tablero;
    }

    private boolean ternaEsValida(byte posicionUno, byte posicionDos, byte posicionTres) {
        List<Casilla> casillas = new ArrayList<>();

        casillas.add(tablero.get(posicionUno));
        casillas.add(tablero.get(posicionDos));
        casillas.add(tablero.get(posicionTres));

        return casillas.stream().map(Casilla::getSimbolo).distinct().count() == 1 && casillas.get(0).estaMarcada();
    }
}