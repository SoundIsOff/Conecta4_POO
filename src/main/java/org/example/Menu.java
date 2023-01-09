package org.example;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * Clase que contiene el menú del juego.
 */
public class Menu {
    public List<ModoJuego> modo;
    private static final String FIN = "\nGracias por jugar!";
    Scanner teclado = new Scanner(System.in);

    public Menu(List<ModoJuego> modo) {
        this.modo = modo;
    }

    /**
     * Imprime el menú del juego y permite elegir una opción.
     */
    public void elegirModo(){
        int opcion=-1;
        do {
            int i = 1;
            try {
                System.out.printf("\nELIGE EL MODO DE JUEGO: ");
                for (ModoJuego modoJuego : modo){
                    System.out.printf("\n"+i+". "+ modoJuego.getClass().getSimpleName());
                    i++;
                }
                System.out.printf("\n"+"4. Salir.\n");
                opcion = teclado.nextInt();
            }
            catch (InputMismatchException exception) {
                System.out.println("Valor no valido");
                teclado.next();
            }
            if (opcion == 4 )
                System.out.printf(FIN);
            else if (opcion > 0 && opcion <= modo.size())
                modo.get(opcion-1).jugar();
            else System.out.printf("Opción incorrecta.");

        } while (opcion != 4 );
    }

}
