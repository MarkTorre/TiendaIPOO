import java.util.Scanner;
import java.util.Date;

public class TestTienda{

    public static void seguirComprando( ) {
        Scanner scan = new Scanner(System.in);
        boolean seguir = true;
        String decide;

        while (seguir == true) {
            System.out.println("Quiere introducir un Componente? Si/NO");
            decide = scan.nextLine();
            if (decide == "SI" || decide == "si") {
                System.out.println("Introduzca el codigo del componente que desea introducir");

            } else if (decide == "NO" || decide == "no") {
                seguir = false;

            }
        }

    }

    public static void main(String[] args) {
       // Scanner scan = new Scanner(System.in);
        System.out.println("-----------------Bienvenido a la tienda de informatica--------------");
       
        seguirComprando();

   
    }
}