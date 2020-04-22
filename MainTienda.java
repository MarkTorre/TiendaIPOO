import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainTienda {
  
  public static void unidadesDisponibles(ProductoEnStock stockProducto, TiendaOnline tiendaOnline, Cliente c, Componente comp){
    if(stockProducto.getUdsDisponibles() > stockProducto.getUdsReservadas()) {
      tiendaOnline.añadirProductoCarro(c, comp);
      stockProducto.setUdsReservadas(stockProducto.getUdsReservadas() + 1);
    }
  }

  public static String infoComponente(int codigoComp,TiendaOnline tiendaOnline){
  for(int i=0; i < tiendaOnline.getNumInventario(); i++){  
      if(codigoComp == tiendaOnline.getStock()[i].getComponente().getCodigo()){
        return "\nComponente Encontrado: \n"+ tiendaOnline.getStock()[i].getComponente().toString();
      }
    }
    return "El componente no existe";
  }
  public static void main(String[] args){
      //1.
      TiendaOnline tiendaOnline= new TiendaOnline();
      
      //2.
      /*Clientes */
      Cliente thomas= new Cliente(1234567, "Thomas","Shelby", "1231323132C");
      Cliente arthur= new Cliente(7655421, "Arthut", "Shelby","1243412214132R");
      Cliente elephantMan = new Cliente(2131324, "Joseph", "Merrick", "3214123123"); 
      Cliente senyorX= new Cliente(4256235, "Senyor", "X", "32141233142O");
/*  Añadir a lista Tienda Online */
      tiendaOnline.setCliente(thomas); 
      tiendaOnline.setCliente(arthur); 
      tiendaOnline.setCliente(elephantMan); 
      tiendaOnline.setCliente(senyorX); 
      /*Fabricantes */
      Fabricante amd = new Fabricante("AMD", 1000, 609344560);
      Fabricante intel = new Fabricante("Intel", 2000, 609344560);
      Fabricante apple = new Fabricante("Apple", 3000, 609344560);
     
      tiendaOnline.setFabricante(amd);
      tiendaOnline.setFabricante(intel);
      tiendaOnline.setFabricante(apple);
/*  Añadir a lista Tienda Online */
      //3.
     Componente procesador1 = new Componente(amd, 1000, "Procesador AMD RAEDON", 320.0);
     Componente procesador2= new Componente(intel, 1001, "Procesador Intel Core i7", 387.78);
     Componente modulo=  new Componente(intel, 1002, "Módulo informatico sistema Intel S9256WK1HLC", 100.0);
     Componente portatil=new Componente(apple, 1003, "Mack book pro", 999.0);
     Componente tablet= new Componente(apple, 1004, "iPad Pro", 699.0);

     ProductoEnStock stockProcesador1 = new ProductoEnStock(procesador1,100);
     ProductoEnStock stockProcesador2 = new ProductoEnStock(procesador2,70);
     ProductoEnStock stockModulo = new ProductoEnStock(modulo,150);
     ProductoEnStock stockPortatil = new ProductoEnStock(portatil,150);
     ProductoEnStock stockTablet = new ProductoEnStock(tablet,150);
     //4.

     tiendaOnline.setProductoEnStock(stockProcesador1);
     tiendaOnline.setProductoEnStock(stockProcesador2);
     tiendaOnline.setProductoEnStock(stockModulo);
     tiendaOnline.setProductoEnStock(stockPortatil);
     tiendaOnline.setProductoEnStock(stockTablet);

     //5.
     
     

     if(tiendaOnline.verificaCliente(thomas)){
 
     tiendaOnline.setCarritoDeLaCompra(thomas);

     unidadesDisponibles(stockProcesador1, tiendaOnline, thomas, procesador1);
     unidadesDisponibles(stockProcesador2, tiendaOnline, thomas, procesador2);
     unidadesDisponibles(stockModulo, tiendaOnline, thomas, modulo);
     unidadesDisponibles(stockModulo, tiendaOnline, thomas, modulo);
     unidadesDisponibles(stockPortatil, tiendaOnline, thomas, portatil);
     unidadesDisponibles(stockTablet, tiendaOnline, thomas, tablet);}

      /*Llamar método añadir producto al carrito y el método de añadir carrito tienda online */
    
    
    //6. A medias 7.
    //(true/false --> Con Tarjeta/Sin Tarjeta)
   
    Venta vent= tiendaOnline.comprarCarro(0, true);
    /*miCarrito.comprar(true);*/
    /*Actualizar Stock*/
    //8.
    System.out.println(vent.toString());
    System.out.println(tiendaOnline.showStockTienda());

    //9.
      /*Borrar producto de una venta (devolucion) 
      vent.getFechaCompra()
      */
if(tiendaOnline.verificaCliente(thomas)){
    if(tiendaOnline.devolucioComponente(tiendaOnline.getVenta()[0].getFechaCompra(), thomas, 1002))
    {System.out.println("Se ha cancelado");}else System.out.println("No se ha cancelado") ;

    System.out.println(tiendaOnline.showStockTienda());
    /*Borrar de todos los productos (devolucion total de la venta) */
    tiendaOnline.eliminaVenta(thomas, tiendaOnline.getVenta()[0].getFechaCompra());
    
    //10.
    System.out.println(tiendaOnline.showStockTienda());
    }

    //11.
    System.out.println(infoComponente(1002, tiendaOnline));
    System.out.println(infoComponente(4832142, tiendaOnline));

    //12.
    /* */

    /*Últimos tres puntos antes de los opcionales
    * Nuevo fabricante
	Fabricante hp = new Fabricante("HP", 4000, 609344564);
	
	* Nuevos productos
	Ram ram1 = new Ram(amd, 1005, "G. Skill Aegis", 19.99, 4, "DDR3");
	Flash flash1 = new Flash(amd, 1006, "Kingston HyperX Fury Blue", 27.0, 4, 1600);
	DiscoDuro D1 = new DiscoDuro(intel, 1007, "Intel Consumer SSD", 154.38, 1000, "Interno");
	
	PlacaBase placa1 = new PlacaBase(intel, 1008, "Asus PRIME Z370", 159.9, 16, "Intel", "DIMM", 305, 244);
	
	Teclado teclado1 = new Teclado(apple, 1009, "Magic Keyboard", 99.0, "USB", "Español");
	Raton raton1 = new Raton(apple, 1010, "Magic Mouse 2", 80.01, "Bluetooth", 0);
	Impresora impresora1 = new Impresora(hp, 1011, "ColorLaser 150a", 145.36, "USB", "Laser");
	
	1. Añadir producto al stock
	ProductoEnStock stockRam1 = new ProductoEnStock(ram1, 60);
	ProductoEnStock stockFlash1 = new ProductoEnStock(flash1, 60);
	ProductoEnStock stockD1 = new ProductoEnStock(D1, 40);
	ProductoEnStock stockPlaca1 = new ProductoEnStock(placa1, 30);
	ProductoEnStock stockTeclado1 = new ProductoEnStock(teclado1, 80);
	ProductoEnStock stockRaton1 = new ProductoEnStock(raton1, 80);
	ProductoEnStock stockImpresora1 = new ProductoEnStock(impresora1, 20);
	
	tiendaOnline.setProductoEnStock(stockRam1);
	tiendaOnline.setProductoEnStock(stockFlash1);
	tiendaOnline.setProductoEnStock(stockD1);
	tiendaOnline.setProductoEnStock(stockPlaca1);
	tiendaOnline.setProductoEnStock(stockTeclado1);
	tiendaOnline.setProductoEnStock(stockRaton1);
	tiendaOnline.setProductoEnStock(stockImpresora1);
	
	2. Crear carritos, añadir productos y comprarlos
	CarritoDeLaCompra carrito2 = new CarritoDeLaCompra(now1, arthur);
	carrito2.añadirProducto(ram1);
	carrito2.añadirProducto(D1);
	carrito2.añadirProducto(teclado1);
	carrito2.añadirProducto(raton1);
	
	CarritoDeLaCompra carrito3 = new CarritoDeLaCompra(now1, senyorX);
	carrito3.añadirProducto(flash1);
	carrito3.añadirProducto(placa1);
	carrito3.añadirProducto(impresora1);
	
	carrito2.comprar(True);
	carrito3.comprar(False);
	
	3. Mostrar la info. de los nuevos componentes
	System.out.println("Memoria RAM:\n" + ram1.toString() + "\n\n" + "Memoria FLASH:\n" + flash1.toString() + "\n\n" + "Disco duro:\n" + D1.toString() + "\n\n");
	System.out.println("Placa base:\n" + placa1.toString() + "\n\n");
	System.out.println("Teclado:\n" + teclado1.toString() + "\n\n" + "Ratón:\n" + raton1.toString() + "\n\n" + "Impresora:\n" + impresora1.toString() + "\n\n");
    */
  
    

    
    
  }
}
