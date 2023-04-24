package business;

import java.util.*;
import java.util.Random;


public class Juego {
    private Map<Integer ,Jugador> jugadores = new HashMap<>();
    private Scanner entrada = new Scanner(System.in);

    private Tablero tablero = new Tablero();

    public Juego(){
        getJugadores();
        jugar();
    }

    private void jugar(){
        byte posicion;
        Random random = new Random();
        while(tablero.getTablero().values().stream().filter(casilla -> casilla.getSimbolo().equals(jugadores.get(1).getSimbolo())).count() < 5
        && !tablero.ternaEsValida()) {
            if(jugadores.get(getTurno()).getTipoJugador() == TipoJugador.MAQUINA){
                posicion = (byte) (random.nextInt(9) + 1);
            }else{
                System.out.println("Juega jugador->"+getTurno()+"."+jugadores.get(getTurno()).getNombreJugador());
                System.out.print("Ingresa la posición a jugar(1-9)->");
                posicion = entrada.nextByte();
            }
            if (!tablero.getTablero().get(posicion).estaMarcada()) {
                tablero.getTablero().get(posicion).marcar(jugadores.get(getTurno()).getSimbolo());
                tablero.toStringTablero();
            }
        }
        if(tablero.ternaEsValida()){
            int ganador = 1;
            System.out.println("¡¡El ganador es->"+jugadores.get(ganador==getTurno()?2:1).getNombreJugador()+"!!");
        }else{
            System.out.println("No hubo ganador");
        }
    }

    private void getJugadores(){
        String simbolo = "", nombre;
        for (int i = 1; i < 3 ; i ++){
            System.out.println("Ingresa el jugador ("+i+")");
            System.out.print("Tipo Jugador:\n1.Maquina\n2.Jugador\n->");
            if(entrada.nextInt() == 2){
                System.out.print("Ingresa el nombre->");
                nombre = entrada.next().trim();
                System.out.print("Ingresa el simbolo->");
                simbolo = entrada.next().toUpperCase().trim();
                jugadores.put(i, new Jugador(nombre, simbolo, TipoJugador.JUGADOR));
            }else{
                jugadores.put(i, new Jugador("Maquina "+i, simbolo = (simbolo.equals("X")) ? "O" : "X", TipoJugador.MAQUINA));
            }
        }
        if(jugadores.get(1).getSimbolo().equalsIgnoreCase(jugadores.get(2).getSimbolo()) ||
                jugadores.get(1).getNombreJugador().equalsIgnoreCase(jugadores.get(2).getNombreJugador())){
            if(jugadores.get(1).getTipoJugador() == TipoJugador.MAQUINA){
                jugadores.put(1, new Jugador("Maquina "+1, simbolo = (simbolo.equals("X")) ? "O" : "X", TipoJugador.MAQUINA));
            }else{
                System.out.println("Simbolos o nombres iguales");
                jugadores.clear();
                getJugadores();
            }
        }
    }
    private int getTurno(){
        return (int) ((tablero.getTablero().values().stream().filter(casilla -> !casilla.getSimbolo().equals("")).count() % 2) + 1);
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
