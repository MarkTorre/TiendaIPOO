import java.util.Date;



public class TiendaOnline {

    private Cliente[] listaCliente;
    private Fabricante[] listaFabricante;
    private CarritoDeLaCompra[] listaCarrito;
    private ProductoEnStock[] inventario;
    private Venta[] listaVentas;
    private int numCliente, numFabricante, numCarrito, numInventario, numVenta;
    private static int MaxCliente, MaxFabricante, MaxCarrito, MaxInventario, MaxVenta;

    public TiendaOnline(){
        this.listaCliente = new Cliente[MaxCliente];
        this.listaFabricante = new Fabricante[MaxFabricante];
        this.listaCarrito = new CarritoDeLaCompra[MaxCarrito];
        this.inventario = new ProductoEnStock[MaxInventario];
        this.listaVentas = new Venta[MaxVenta];
    }

/*--------Métodos SETTERS-----------*/
/*NOTA: condicionarlos para que no hayan 2 clientes */
public boolean setCliente(Cliente cliente){
    for(Cliente c : this.listaCliente){
            if(c.getCodigo() == cliente.getCodigo()){
                return false;
            }
    }
    this.listaCliente[numCliente]=cliente;
    this.numCliente++;
    return true;
}

public String showClientes(){
    String s="\n\t";
    for(Cliente client: this.listaCliente){
        s= s + client.toString()+ "\n";
    }
    return s;
}

public boolean setFabricante(Fabricante fabricante){
    for(Fabricante f : this.listaFabricante){
        if(f.getCodigo() == fabricante.getCodigo()){
            return false;
        }
    }
    this.listaFabricante[numFabricante]= fabricante;
    this.numFabricante++;
    return true;
}

public String showFabricantes(){
    String s="\n\t";
    for(Fabricante f : this.listaFabricante){
        s= s + f.toString()+ "\n";
    }
    return s;
}


public boolean setProductoEnStock(ProductoEnStock pStock){
    for(ProductoEnStock componente : this.inventario){
        if(componente.getComponente() == pStock.getComponente()){
            return false;
        }
    }
    this.inventario[numInventario]= pStock;
    this.numInventario++;
    return true;
}



public boolean setCarritoDeLaCompra(Cliente c, Date fecha){
    CarritoDeLaCompra carrito= new CarritoDeLaCompra(fecha, c);
    for(CarritoDeLaCompra listacarro: this.listaCarrito ){
        if(listacarro.getCliente() == carrito.getCliente()){
            return false;
        }
    }
    this.listaCarrito[numCarrito]=carrito;
    this.numCarrito++;
    return true;
}

public boolean setVentas(Venta v){
    if(numVenta< MaxVenta){ this.listaVentas[numVenta] = v; return true;}
    return false;
   
}

public String muestraVentas(Cliente c){   //acabar..
    String s="";
    for(Venta v: this.listaVentas){
        s= s+ v.toString();
    }
    return s;
}
//8. Hecho
public void comprarCarro(int posicionCarro, boolean tipoPago){ //*falta actualizar el stock...
    this.listaCarrito[posicionCarro].comprar(tipoPago);
}

//9. Revisar
/*
public void devolucioComponente(Date fecha, Cliente c, String codigoComponente){
        for(Venta venta: this.listaVentas){
            if(venta.getFechaCompra() == fecha && venta.getCliente() == c){
                venta.
                for(Componente comp: venta.getComponente()){
                    if(comp.getCodigo() == codigoComponente){
                        
                    }
                }
            }
            
        }
}
*/
//10. Hecho
public String showStockTienda(){
    String s="\n";
    for(ProductoEnStock prodStock: this.inventario){
        s= s+ "Producto en Stock: \n" + prodStock.getComponente().getDescripcion()+
        "\n\t Código interno: " + prodStock.getComponente().getCodigo()+
        "\n\t Cantidad disponible: " + prodStock.getDisponible();
    }
    return s;
}

}