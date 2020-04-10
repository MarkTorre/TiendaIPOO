import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class TestTienda {

    
    public static void seguirComprando(CarritoDeLaCompra miCarrito, Componente[] componente) {
        Scanner scan = new Scanner(System.in);
        boolean seguir = true;
        String decide;
        int code;

        while (seguir)
        	{
            System.out.println("Quiere añadir un componente? si/no");
            decide = scan.next();
            if (decide.equals("SI") || decide.equals("si")) 
            	{
                System.out.println("Introduzca el código del componente que desea añadir");
                code = scan.nextInt();
                if(!miCarrito.anyadirProducto(componente[1])){                                                              
                    System.out.println("\n\tNo se pueden añadir más componentes\n");
                }

            } else if (decide.equals("NO") || decide.equals("no") ) 
            {
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

        while (seguir)
        	{
            System.out.println("Quiere retirar un componente? si/no");
            decide = scan.next();
            if (decide.equals("SI") || decide.equals("si") ) {
                System.out.println("Introduzca el código del componente que desea retirar");
                code = scan.nextInt();
                if(!miCarrito.eliminarProducto(code)){
                    System.out.println("\n\tNo hay ningún objeto con ese código");
                }
                
            } else if (decide.equals("NO") || decide.equals("no") ) {
                System.out.println("\n\nCesta de compra actual. Usted tiene:\n" + miCarrito.toString());
                seguir = false;
            }
        }
    }


    public static void pagarCompra(CarritoDeLaCompra miCarrito){
        int decide;
        Scanner scan = new Scanner(System.in);
        Venta tiquetVenta;

        System.out.println("--------------Decida el método de pago que quiere usar-------------- \n"+ "Con tarjeta o por transferencia bancaria(0/1):");
        decide= scan.nextInt();

        if(decide == 1){
            tiquetVenta = miCarrito.comprar(true); 
            System.out.println(tiquetVenta.toString());
        } else {
            tiquetVenta = miCarrito.comprar(false); 
            System.out.println(tiquetVenta.toString());
        }
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
                new Componente(apple, 1003, "Mack book pro", 999.0), 
                new Componente(apple, 1004, "iPad Pro", 699.0), };
        
        System.out.println("Productos:\n");
        
        for(int i = 0; i < tienda.length; i++) {
        	System.out.println(tienda[i].toString() + "\n");
        }

        Cliente sergio = new Cliente(01234, "Sergio", "Nieto", "4502 2304 768");
        Cliente marc = new Cliente(56789, "Marc", "Torrecilla", "3244 5356 2345");
        
        Date now= new Date();

        CarritoDeLaCompra miCarrito = new CarritoDeLaCompra(now, sergio);
        
        String decide;
        boolean comprar = false;
        while(!comprar ){
        seguirComprando(miCarrito, tienda);
        retirarProducto(miCarrito);
        System.out.println("Quiere proceder al pago? si/no");
        decide = scan.next();
        if (decide.equals("SI") || decide.equals("si") ) {
            comprar=true;
        } else if (decide.equals("NO" )  || decide.equals("no") ){
            comprar=false;
          }
        }
       pagarCompra(miCarrito);
    }
}