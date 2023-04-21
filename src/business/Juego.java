package business;

import java.util.*;

public class Juego {
    private Map<Integer ,Jugador> jugadores = new HashMap<>();
    private Scanner entrada = new Scanner(System.in);

    private Tablero tablero = new Tablero();

    public Juego(){
        getJugadores();
        jugar();
    }

    private void jugar(){
        while(tablero.getTablero().values().stream().filter(casilla -> casilla.getSimbolo().equals(jugadores.get(1).getSimbolo())).count() < 5){
            System.out.println("Ingresa la posición a jugar(1-9)");
            System.out.println(jugadores.get(getTurno()).getNombreJugador());
            byte posicion = entrada.nextByte();
            if (!tablero.getTablero().get(posicion).estaMarcada()){
                tablero.getTablero().get(posicion).marcar(jugadores.get(getTurno()).getSimbolo());
            }
            tablero.toStringTablero();
            byte[][] terna = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},
                    {1, 4, 7}, {2, 5, 8}, {3, 6, 9},
                    {1, 5, 9}, {3, 5, 7}};
            for(byte[] ciclo:terna){
                if(tablero.ternaEsValida(ciclo[0], ciclo[1], ciclo[2])){
                    System.out.println("Gano");
                }
            }
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
        if(jugadores.get(1).getSimbolo().equalsIgnoreCase(jugadores.get(2).getSimbolo()) ||
                jugadores.get(1).getNombreJugador().equalsIgnoreCase(jugadores.get(2).getNombreJugador())){
            System.out.println("Simbolos o nombres iguales");
            jugadores.clear();
            getJugadores();
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
        return (int) ((tablero.getTablero().values().stream().filter(casilla -> !casilla.getSimbolo().equals("")).count() % 2) + 1);
        //Retorna el numero del jugador a jugar, depende de los signos que hayan en el tablero
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
