import java.util.Date;



public class TiendaOnline {

    private Cliente[] listaCliente;
    private Fabricante[] listaFabricante;
    private CarritoDeLaCompra[] listaCarrito;
    private ProductoEnStock[] inventario;
    private Venta[] listaVentas;
    private int numCliente, numFabricante, numCarrito, numInventario, numVenta;
    private int MaxCliente, MaxFabricante, MaxCarrito, MaxInventario, MaxVenta;
    public TiendaOnline(int C){

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


public boolean setProductoEnStock(Componente Producto, int cantidad){
    ProductoEnStock pStock= new ProductoEnStock(Producto, cantidad);
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

public String muestraVentas(){   //acabar..
    String s;
    for(Venta v: this.listaVentas){
        s= s+ v.toString();
    }
    return s;
}
}