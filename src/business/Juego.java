package business;

import java.util.*;

public class Juego {
    private Map<Integer ,Jugador> jugadores = new HashMap<>();
    private Scanner entrada = new Scanner(System.in);
    private Map<Byte, Casilla> map = new Tablero().getTablero();

    public Juego(){
        getJugadores();
    }

    private void getJugadores(){
        for (int i = 1; i < 3 ; i ++){
            System.out.println("Ingresa el jugador ("+i+")");
            jugadores.put(i, new Jugador(entrada.next(), entrada.next()));
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
        return (int) (map.values().stream().filter(casilla -> casilla.getSimbolo().equals(jugadores.get(1).getSimbolo())).count() % 2) + 1;
        //Retorna el numero del jugador a jugar, depende de los signos que hayan en el tablero
    }
    public static void main(String[] args) {
        Juego juego = new Juego();
        System.out.println(juego.getTurno());
    }
}
