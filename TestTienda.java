import java.util.Scanner;

import java.util.Date;

public class TestTienda {

    public static void seguirComprando(CarritoDeLaCompra miCarrito, Componente[] tienda) {
        Scanner scan = new Scanner(System.in);
        boolean seguir = true;
        String decide;
        int code;

        while (seguir == true) {
            System.out.println("Quiere introducir un Componente? Si/NO");
            decide = scan.next();
            if (decide.equals("SI") == true || decide.equals("si") == true) {
                System.out.println("Introduzca el codigo del componente que desea introducir");
                code = scan.nextInt();
                if(!miCarrito.anyadirProducto(code, tienda)){                                                           
                    System.out.println("\n\tEl codigo que ha introducido no existe.\n");
                }


            } else if (decide.equals("NO") == true || decide.equals("no") == true) {
                System.out.println("\n\nCesta de compra actual. Usted tiene:\n" + miCarrito.toString());

                seguir = false;

            }
        }

    }

    public static void retirarProducto(CarritoDeLaCompra miCarrito) {
        Scanner scan = new Scanner(System.in);
        boolean seguir = true;
        String decide;
        int code;

        while (seguir == true) {
            System.out.println("Quiere retirar un Componente? Si/NO");
            decide = scan.next();
            if (decide.equals("SI") == true || decide.equals("si") == true) {
                System.out.println("Introduzca el codigo del componente que desea retirar");
                code = scan.nextInt();
                if(!miCarrito.eliminarProducto(code)){
                    System.out.println("\n\tNo hay ningun objeto con ese codigo");
                };

            } else if (decide.equals("NO") == true || decide.equals("no") == true) {
                System.out.println("\n\nCesta de compra actual, usted tiene:\n" + miCarrito.toString());
                seguir = false;
            }
        }
    }


    public static void pagarCompra(CarritoDeLaCompra miCarrito){
        int decide;
        Scanner scan = new Scanner(System.in);
        Venta tiquetVenta;

        System.out.println("--------------Decida el Método de pago que quiere usar-------------- \n"+ "Con tarjeta o sin Tarjeta(1/0):");
        decide= scan.nextInt();

        if(decide == 1){
            tiquetVenta = miCarrito.comprar(true); 
            System.out.println(tiquetVenta.toString());
        }else{
            tiquetVenta = miCarrito.comprar(false); 
            System.out.println(tiquetVenta.toString());
        };

    }
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
        System.out.println("-----------------Bienvenido a la tienda de informatica--------------");

        Fabricante amd = new Fabricante("AMD", 1000, 609344560);
        Fabricante intel = new Fabricante("Intel", 2000, 609344560);
        Fabricante apple = new Fabricante("Apple", 3000, 609344560);

        Componente[] tienda = { new Componente(amd, 1000, "Procesador AMD RAEDON", 320.0),
                new Componente(intel, 1001, "Procesador Intel Core i7", 387.78),
                new Componente(intel, 1002, "Módulo informatico sistema Intel S9256WK1HLC", 100.0),
                new Componente(apple, 1003, "Mack book pro", 0.999), new Componente(apple, 1004, "iPad Pro", 0.699), };

        Cliente sergio = new Cliente(01234, "Sergio", "Nieto", "4502 2304 768");
        Cliente marc = new Cliente(56789, "Marc", "Torrecilla", "3244 5356 2345");

        CarritoDeLaCompra miCarrito = new CarritoDeLaCompra("21/03/2020", sergio);
        String decide;

        boolean comprar = false;

        while(!comprar ){
        seguirComprando(miCarrito, tienda);
        retirarProducto(miCarrito);
        System.out.println("Quiere proceder al Pago? SI/NO");
        decide = scan.next();
        if (decide.equals("SI") == true || decide.equals("si") == true) {
            comprar=true;
        }else if (decide.equals("NO" ) == true || decide.equals("no") == true){
            comprar=false;
          }
        }
       pagarCompra(miCarrito);
      


    }
}