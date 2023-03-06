package business;

public class Jugador {

    private String jugador, simbolo;
    public Jugador(String simbolo) {
        this.simbolo = setSimbolo(simbolo);
    }
    public Jugador(String jugador, String simbolo) {
        this.simbolo = setSimbolo(simbolo);
        this.jugador = setJugador(jugador);
    }
    private String setSimbolo(String simbolo){
        if(simbolo.trim().equals("")) {
            throw new RuntimeException("No es posible poner un simbolo vacio o nulo");
        }
        if(simbolo.trim().length() != 1) {
            throw new RuntimeException("No es posible poner un simbolo con longitud > 1");
        }
        else{
            return simbolo;
        }
    }
    private String setJugador(String jugador){
        if(jugador.trim().equals("")) {
            throw new RuntimeException("No es posible poner un nombre de jugador vacio o nulo");
        }
        if(jugador.trim().length() > 8) {
            throw new RuntimeException("No es posible poner un nombre con una longitud > 1");
        }
        else{
            return jugador;
        }
    }
}
