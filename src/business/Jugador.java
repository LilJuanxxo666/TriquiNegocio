package business;

public class Jugador {

    private String nombreJugador, simbolo;
    private TipoJugador tipoJugador;
    public Jugador(String nombreJugador, String simbolo, TipoJugador tipoJugador) {
        this.simbolo = setSimbolo(simbolo);
        this.nombreJugador = setJugador(nombreJugador);
        this.tipoJugador = tipoJugador;
    }
    private String setSimbolo(String simbolo){
        if(simbolo.trim().equals("")) {
            throw new RuntimeException("No es posible poner un simbolo vacio o nulo");
        }
        else if(simbolo.trim().length() != 1) {
            throw new RuntimeException("No es posible poner un simbolo con longitud > 1");
        }
        else{
            return simbolo;
        }
    }
    private String setJugador(String nombreJugador){
        if(nombreJugador.trim().equals("")) {
            throw new RuntimeException("No es posible poner un nombre de jugador vacio o nulo");
        }
        else if(nombreJugador.trim().length() > 10) {
            throw new RuntimeException("No es posible poner un nombre con una longitud > 1");
        }
        else{
            return nombreJugador;
        }
    }
    public String getSimbolo(){
        return simbolo;
    }

    public String getNombreJugador(){
        return nombreJugador;
    }
    public TipoJugador getTipoJugador(){return tipoJugador; }

}
