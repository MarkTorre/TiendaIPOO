import java.util.Scanner;



import java.util.Date;



public class TestTienda{

    public static void seguirComprando(CarritoDeLaCompra miCarrito, Componente [] tienda ) {
        Scanner scan = new Scanner(System.in);
        boolean seguir = true;
        String decide;
        int code;

        while (seguir== true) {
            System.out.println("Quiere introducir un Componente? Si/NO");
            decide = scan.next();
            if (decide.equals("SI") == true || decide.equals("si") == true) {
                System.out.println("Introduzca el codigo del componente que desea introducir");
                code= scan.nextInt();
                miCarrito.anyadirProducto(code, tienda);

            } else if (decide.equals("NO") == true || decide.equals("no") == true) {
                System.out.println("Cesta de compra actual, usted tiene:\n" + miCarrito.toString()
               );
            
                seguir = false;
        
                
            }
        }

    }

    public static void main(String[] args) {
       // Scanner scan = new Scanner(System.in);
        System.out.println("-----------------Bienvenido a la tienda de informatica--------------");
       
        Fabricante  amd = new Fabricante("AMD", 1000, 609344560);
        Fabricante  intel = new Fabricante("Intel", 2000, 609344560);
        Fabricante  apple = new Fabricante("Apple", 3000, 609344560);

       Componente[] tienda = {new Componente(amd,1000, "Procesador AMD RAEDON", 320.0),
                              new Componente(intel,1001, "Procesador Intel Core i7", 387.78),
                              new Componente(intel,1002, "Módulo informatico sistema Intel S9256WK1HLC", 100.0),
                              new Componente(apple,1003, "Mack book pro", 0.999),
                              new Componente(apple,1004, "iPad Pro", 0.699),
                            };
        
        Cliente sergio = new Cliente(01234,"Sergio","Nieto","4502 2304 768");
        Cliente marc = new Cliente(56789,"Marc","Torrecilla","3244 5356 2345");

        CarritoDeLaCompra miCarrito = new CarritoDeLaCompra("21/03/2020", sergio);
        seguirComprando(miCarrito, tienda);
      
   
    }
}