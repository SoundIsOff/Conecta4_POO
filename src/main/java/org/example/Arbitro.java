package org.example;


/**
 * Clase que comprobará en el tablero si hay ganador mediante los métodos
 * horizontal, vertical y diagonal. Si alguno de estos se cumple, se acabará la partida.
 */
public class Arbitro {
    Tablero tablero;
    boolean hayGanador;


    /**
     * Constructor crea un tablero con el tablero pasado como parámetro.
     * @param tablero el tablero
     */
    public Arbitro(Tablero tablero){
        this.tablero=tablero;

    }

    /**
     * Método que comprueba si hay ganador devolviendo true si hay 4 en raya horizontal, vertical o diagonal.
     * @param caracter caracter de la casilla en la que se ha colocado la ficha.
     * @return devuelve true si ha encontrado combinación ganadora en horizontal, vertical o diagonal.
     */
    public boolean compruebaGanador(char caracter){
        hayGanador = compruebaHorizontal(caracter) || compruebaDiagonal(caracter) || compruebaVertical(caracter);
        return hayGanador;
    }

    /**
     * Método que comprueba si hay ganador en horizontal.
     * @param caracter caracter de la casilla en la que se ha colocado la ficha.
     * @return devuelve true si ha encontrado combinación ganadora en horizontal.
     */
    public boolean compruebaHorizontal(char caracter){
        boolean encontrado=false;
        for(int i=0;i<tablero.getNumfilas();i++){
            for(int j=0;j<tablero.getNumcolumnas()-3;j++){
                if(tablero.casillas[i][j].getFicha().getContenido()==caracter&&tablero.casillas[i][j+1].getFicha().getContenido()==caracter&&
                        tablero.casillas[i][j+2].getFicha().getContenido()==caracter&&tablero.casillas[i][j+3].getFicha().getContenido()==caracter){
                    encontrado=true;
                }
            }
        }
        return encontrado;
    }

    /**
     * Método que comprueba si hay ganador en vertical.
     * @param caracter caracter de la casilla en la que se ha colocado la ficha.
     * @return devuelve true si ha encontrado combinación ganadora en vertical.
     */
    public boolean compruebaVertical(char caracter){
        boolean encontrado=false;
        for(int i=0;i<tablero.getNumcolumnas();i++){
            for(int j=0;j<tablero.getNumfilas()-3;j++){
                if(tablero.casillas[j][i].getFicha().getContenido()==caracter&&tablero.casillas[j+1][i].getFicha().getContenido()==caracter&&
                        tablero.casillas[j+2][i].getFicha().getContenido()==caracter&&tablero.casillas[j+3][i].getFicha().getContenido()==caracter){
                    encontrado=true;
                }
            }
        }
        return encontrado;
    }

    /**
     * Método que comprueba si hay ganador en diagonal.
     * @param caracter caracter de la casilla en la que se ha colocado la ficha.
     * @return devuelve true si ha encontrado combinación ganadora en diagonal.
     */
    public boolean compruebaDiagonal(char caracter){
        boolean encontrado=false;
        for(int i=0;i<tablero.getNumcolumnas()-3;i++){
            for(int j=0;j<tablero.getNumfilas()-3;j++){
                if(tablero.casillas[j][i].getFicha().getContenido()==caracter&&tablero.casillas[j+1][i+1].getFicha().getContenido()==caracter&&
                        tablero.casillas[j+2][i+2].getFicha().getContenido()==caracter&&tablero.casillas[j+3][i+3].getFicha().getContenido()==caracter){
                    encontrado=true;
                }
            }
        }
        for(int i=tablero.getNumcolumnas();i>3;i--){
            for(int j=0;j<tablero.getNumfilas()-3;j++){
                if(tablero.casillas[j][i-1].getFicha().getContenido()==caracter&&tablero.casillas[j+1][i-2].getFicha().getContenido()==caracter&&
                        tablero.casillas[j+2][i-3].getFicha().getContenido()==caracter&&tablero.casillas[j+3][i-4].getFicha().getContenido()==caracter){
                    encontrado=true;
                }
            }
        }
        return encontrado;
    }

}
