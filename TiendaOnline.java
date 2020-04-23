import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class TiendaOnline {
	
	private Cliente[] listaCliente;
	private Fabricante[] listaFabricante;
	private CarritoDeLaCompra[] listaCarrito;
	private ProductoEnStock[] inventario;
	private Venta[] listaVentas;
	private int numCliente, numFabricante, numCarrito, numInventario, numVenta;
	private static int MaxCliente=1000, MaxFabricante=1000, MaxCarrito=1000, MaxInventario=1000, MaxVenta=1000;
	
	public TiendaOnline(){
		this.listaCliente = new Cliente[MaxCliente];
	    this.listaFabricante = new Fabricante[MaxFabricante];
	    this.listaCarrito = new CarritoDeLaCompra[MaxCarrito];
	    this.inventario = new ProductoEnStock[MaxInventario];
		this.listaVentas = new Venta[MaxVenta];
		this.numCliente=0;
		this.numFabricante=0;
		this.numCarrito=0;
		this.numInventario=0;
		this.numVenta=0;
	}
	
	public Venta[] getVenta(){
		return this.listaVentas;
	}

	public ProductoEnStock[] getStock(){
		return this.inventario;
	}

	public int getNumInventario() {
		return this.numInventario;
	
	}
	//1.
	public boolean setCliente(Cliente cliente){
		for(int i =0;i<this.listaCliente.length; i++){
			if(this.listaCliente[i] == cliente){return false;}
		}
	    this.listaCliente[numCliente]=cliente;
	    this.numCliente++;
	    return true;
	}
	
	public String showClientes(){
		String s="\n\t";
		for(int i=0; i<numCliente; i++){
			s= s + this.listaCliente[i].toString()+ "\n";
		}
	    return s;
	}
	
	public boolean setFabricante(Fabricante fabricante){
		for(int i =0;i<this.listaFabricante.length; i++){
			if(this.listaFabricante[i] == fabricante){return false;}
		}
	    this.listaFabricante[numFabricante]= fabricante;
	    this.numFabricante++;
	    return true;
	}
	
	public String showFabricantes(){
		String s="\n\t";
		for(int i=0; i<numFabricante; i++){
			s= s + this.listaFabricante[i].toString()+ "\n";
		}
	    return s;
	}

	//2.
	public void actualizaStock(int codigo, int unidades) {
		for(int i=0; i<numInventario; i++){
			if(this.inventario[i].getComponente().getCodigo() == codigo){
				this.inventario[i].setUdsDisponibles(this.inventario[i].getUdsDisponibles() + unidades);
			}

			if(this.inventario[i].getUdsDisponibles()<=0){
				this.inventario[i].setUdsDisponibles(0);
			}
		}
	}

    //3.
	public boolean setProductoEnStock(ProductoEnStock pStock){ 					

		for(int i=0; i<numInventario; i++){
			if(this.inventario[i].getComponente().getCodigo() == pStock.getComponente().getCodigo()){
				return false;
			}
		}
	    this.inventario[numInventario] = pStock;
	    this.numInventario++;
	    return true;
	}

	//4.
	public boolean setCarritoDeLaCompra(Cliente c){
		Date fecha= new Date();
		for(int i=0; i<numCarrito; i++){
			if(this.listaCarrito[i].getCliente() == c){
				return false;
			}
		}
		CarritoDeLaCompra carrito= new CarritoDeLaCompra(fecha, c);
	    this.listaCarrito[numCarrito]=carrito;
	    this.numCarrito++;
	    return true;
	}

	//5.
	public void añadirProductoCarro(Cliente cliente, Componente producto){
		for(int i=0; i<numCarrito; i++){
			if(this.listaCarrito[i].getCliente()==cliente){
				this.listaCarrito[i].añadirProducto(producto);
			}
		}

	}
	//5.
	public void eliminarProductoCarro(Cliente cliente, int codigo){
			for(int i=0; i<numCarrito; i++){
				if(this.listaCarrito[i].getCliente() == cliente){
					this.listaCarrito[i].eliminarProducto(codigo);
			}
		}
	}

	//6.
	public String mostrarCarritos() {
		String s = "";
		if(this.listaCarrito.length > 0) {
			for(int i=0; i< numCarrito; i++){
				s += this.listaCarrito[i].toString() + "\n";
			}
		} else {
			s = "No hay carritos de la compra.";
		}
		return s;
	}

	public String muestraVentas(Cliente c){ 
	    String s = "";
		for(int i=0; i<numVenta; i++){
			s = s + this.listaVentas[i].toString();
		}
	    return s;
	}

	//7.
	public boolean eliminaCarrito(Cliente c) {
		for(int i = 0; i < this.listaCarrito.length; i++) {
			if(this.listaCarrito[i].getCliente() == c) {
				for(int j = i; j < this.listaCarrito.length; j++) {
					this.listaCarrito[j] = this.listaCarrito[j + 1];
				}
				this.numInventario--;
				return true;
			}
		} 
		return false;
	}
	
	    //devolución total de la venta
	public boolean eliminaVenta(Cliente c, Date d) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
		String date= formatter.format(d);
		String date2;
		for(int i = 0; i < numVenta; i++) {
			date2= formatter.format(this.listaVentas[i].getFechaCompra());
			if( date2.contentEquals(date) && this.listaVentas[i].getCliente() == c) {
				if(i == numVenta-1){ 
					for(int z=0; z< this.listaVentas[i].getNumComp(); z++){

						actualizaStock(this.listaVentas[i].getComponente()[z].getCodigo(), 1);
					}
					this.listaVentas[i]=null;
					this.numVenta--;
					return true; }
				for(int z=0; z< this.listaVentas[i].getNumComp(); z++){
					actualizaStock(this.listaVentas[i].getComponente()[z].getCodigo(), 1);
				}
				for(int j = i; j < numCarrito-1; j++) {
					this.listaVentas[j] = this.listaVentas[j + 1];
				}
				this.numVenta--;
				return true;
			}
		} 
		return false;
	}

	//8.
	public void comprarCarro(int posicionCarro, boolean tipoPago){ 
		Venta venta=this.listaCarrito[posicionCarro].comprar(tipoPago);
	
		for(int j=0;j<this.listaCarrito[posicionCarro].getNumeroComponentes();j++){
			this.listaCarrito[posicionCarro].getProductos()[j]=null;
		}
		setVentas(venta);
		for(int i=0; i<venta.getComponente().length; i++){
			if(venta.getComponente()[i] != null){actualizaStock(venta.getComponente()[i].getCodigo(), -1);}
		}
	}
	
	//9. 
	
	public boolean devolucioComponente(Date fecha, Cliente c, int codigoComponente){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
		String f= formatter.format(fecha);
        String f2;
			for(int i=0; i<numVenta; i++){
				f2= formatter.format(this.listaVentas[i].getFechaCompra());
				if(f2.contentEquals(f) && this.listaVentas[i].getCliente() == c){
					Componente [] compList = this.listaVentas[i].getComponente();
					for(int j=0; j<compList.length; j++){
						if(compList[j].getCodigo() == codigoComponente){
							if(j==this.listaVentas[i].getNumComp()-1){compList[j]=null; return true;}
							for(int z=j; z<this.listaVentas[i].getNumComp()-1; z++){
								compList[z]=compList[z+1];
							}
							int numcomp = this.listaVentas[i].getNumComp();
							this.listaVentas[i].setNumComp(numcomp-1);
							/*compList[numcomp]=null;*/
							actualizaStock(codigoComponente, 1);
							return true;
						}
					}
				}

			}
			return false;
	}

	//10.
	public String showStockTienda(){
	    String s="\n";
		for(int i=0; i<numInventario; i++){
			s= s+ "\nProducto en Stock: \n\t" + this.inventario[i].getComponente().getDescripcion()+
	        "\n\tCódigo interno: " + this.inventario[i].getComponente().getCodigo()+
	        "\n\tCantidad disponible: " + this.inventario[i].getUdsDisponibles();
		}
	    return s;
	}

	
	public boolean setVentas(Venta v){
	    if(numVenta< MaxVenta){ this.listaVentas[numVenta] = v; this.numVenta++; return true;}
	    return false;
	   
	}

	public boolean verificaCliente(Cliente c) {
        for(Cliente cliente : this.listaCliente) {
            if(cliente.getCodigo() == c.getCodigo()) {
                return true;
            }
        }
        return false;
    }
    public boolean verificaFabricante(Fabricante f) {
        for(Fabricante fabricante : this.listaFabricante) {
            if(fabricante.getCodigo() == f.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
