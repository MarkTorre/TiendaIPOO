import java.util.Date;

public class MainTienda {
  public static void main(String[] args){
      //1.
      TiendaOnline tiendaOnline= new TiendaOnline();
      
      //2.
      /*Clientes */
      Cliente thomas= new Cliente(1234567, "Thomas","Shelby", "1231323132C");
      Cliente arthur= new Cliente(7655421, "Arthut", "Shelby","1243412214132R");
      Cliente elephantMan = new Cliente(2131324, "Joseph", "Merrick", "3214123123"); 
      Cliente senyorX= new Cliente(4256235, "Senyor", "X", "32141233142O");

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
     Date now1= new Date();
     CarritoDeLaCompra miCarrito = new CarritoDeLaCompra(now1, thomas);


      /*Llamar método añadir producto al carrito y el método de añadir carrito tienda online */
    
    
    //6. A medias 7.
    //(true/false --> Con Tarjeta/Sin Tarjeta)
    miCarrito.comprar(true);
    
    //8.
    System.out.println(tiendaOnline.showStockTienda());

    //9.

    
    //10.
    System.out.println(tiendaOnline.showStockTienda());

    //11.

    //12.


  }
}