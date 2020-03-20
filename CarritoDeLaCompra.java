
public class CarritoDeLaCompra {
	//Atributos
	private Componente[] productos;
	private int fecha;
	private Cliente c;
	
	//Constructores
	public CarritoDeLaCompra(Componente[] productos, int fecha, Cliente c) {
		super();
		this.productos = productos;
		this.fecha = fecha;
		this.c = c;
	}
	
	
	//Métodos
	public boolean anyadirProducto(int codigo) {
		int j = 0;
		for(int i = 0; i <= productos.length; i++) {
			if(this.productos[i].getCodigo() == codigo) {
				j = i;
			}
			if(i == productos.length && j != 0) {
				productos[i] = productos[j];
				return true;
			}
		}
		return false;
	}

	public boolean eliminarProducto(int codigo) {	
		for(int i = 0; i < productos.length; i++) {
			if(this.productos[i].getCodigo() == codigo) {
				for(int j = i; j < productos.length; j++) {
					this.productos[i] = productos[i + 1];
				}
				return true;
			}
		}
		System.out.println("No hay ningun objeto con ese codigo.");
		return false;
	}
	
	public Venta comprar(int fecha, String pago) {
		Venta v = new Venta(productos, c, fecha, pago);
		if(pago != "transferencia bancaria" | pago != "pago con tarjeta") {
			System.out.println("Metodo de pago incorrecto");
		}
		return v;
	}
	
	public String toString() {
		String s = "\n";
		double precioTot = 0;
		if(productos.length > 0) {
			for(int i = 0; i < productos.length; i++) {
				s += productos[i].toString() + "\n";
				precioTot += productos[i].getPvp();
			}
			return s += "Precio total: " + precioTot;
		} else {
			return "No hay productos en el carrito";
		}
		
	}
	
	
	//Getters y setters
	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

}
