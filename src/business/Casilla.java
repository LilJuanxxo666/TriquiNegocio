package business;

public class Casilla {

    private byte posicion;
    private String simbolo;

    public Casilla(byte posicion) {
        setPosicion(posicion);
        simbolo = "";
    }

    private Casilla(byte posicion, String simbolo) {
        this.posicion = posicion;
        this.simbolo = simbolo;
    }

    public void marcar(String simbolo) {
        if(estaMarcada()) {
            throw new RuntimeException("No es posible volver a marcar. Ya existe en esta casilla el simbolo"+simbolo);
        }

        setSimbolo(simbolo);
    }

    public boolean estaMarcada() {
        return (!cadenaEsNulaOVacia(simbolo));
    }

    private boolean cadenaEsNulaOVacia (String cadena) {
        return (cadena == null || "".intern() == cadena.trim().intern());
    }

    private void setPosicion(byte posicion) {
        if(posicion < 1 || posicion > 9) {
            throw new RuntimeException("No es posible configurar una casilla en un rango por fuera de 1 a 9");
        }
        this.posicion = posicion;
    }

    private void setSimbolo(String simbolo) {

        if(cadenaEsNulaOVacia(simbolo)) {
            throw new RuntimeException("No es posible poner un simbolo vacio o nulo");
        }
        if(simbolo.trim().length() != 1) {
            throw new RuntimeException("No es posible poner un simbolo con longitud > 1");
        }
        this.simbolo = simbolo.trim();
    }
    public String getSimbolo() {
        return simbolo;
    }

    public byte getPosicion() {
        return posicion;
    }

    public Casilla getCasilla() {
        return new Casilla(getPosicion(), getSimbolo());
    }
}
