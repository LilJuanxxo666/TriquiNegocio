package business;

import java.util.*;

public class Juego {
    private Map<Integer ,Jugador> jugadores = new HashMap<>();
    private Scanner entrada = new Scanner(System.in);
    private Map<Byte, Casilla> tablero = new Tablero().getTablero();

    public Juego(){
        getJugadores();
        jugar();
    }

    private void jugar(){
        while(tablero.values().stream().filter(casilla -> casilla.getSimbolo().equals(jugadores.get(1).getSimbolo())).count() < 5){
            System.out.println("Ingresa la posición a jugar(1-9)");
            System.out.println(jugadores.get(getTurno()).getNombreJugador());
            byte posicion = entrada.nextByte();
            if (!tablero.get(posicion).estaMarcada()){
                tablero.get(posicion).marcar(jugadores.get(getTurno()).getSimbolo());
            }
            toStringTablero();
        }
    }
    private void toStringTablero(){
        byte indice = 1;
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                System.out.print(tablero.get(indice).getSimbolo() + " ");
                indice += 1;
            }
            System.out.println();
        }
    }

    private void getJugadores(){
        for (int i = 1; i < 3 ; i ++){
            System.out.println("Ingresa el jugador ("+i+")");
            System.out.println("Ingresa el nombre:");
            String nombre = entrada.next();
            System.out.println("Ingresa el simbolo");
            String simbolo = entrada.next();
            jugadores.put(i, new Jugador(nombre, simbolo));
        }
    }
    /*private void getTurno(){
        byte posicion = entrada.nextByte();
        map.values().stream().map(Casilla::getSimbolo).forEach(System.out::println);
        if((map.values().stream().filter(casilla -> casilla.getSimbolo().equals(jugadores.get(1).getSimbolo())).count() % 2) == 0){
            System.out.print("Juega el jugador 1 \nIngresa una posición(1-9)->");
            posicion = entrada.nextByte();
            map.get(posicion).marcar(jugadores.get(1).getSimbolo());
        }else{
            System.out.print("Juega el jugador 2 \nIngresa una posición(1-9)->");
            posicion = entrada.nextByte();
            map.get(posicion).marcar(jugadores.get(2).getSimbolo());
        }
    }*/
    private int getTurno(){
        return (int) ((tablero.values().stream().filter(casilla -> !casilla.getSimbolo().equals("")).count() % 2) + 1);
        //Retorna el numero del jugador a jugar, depende de los signos que hayan en el tablero
    }
    public static void main(String[] args) {
        Juego juego = new Juego();

    }
}
