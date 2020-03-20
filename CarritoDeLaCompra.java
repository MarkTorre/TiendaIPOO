import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarritoDeLaCompra {
	//Atributos
	private Componente[] productos;
	private Date fecha;
	private Cliente c;
	
	//Constructores
	public CarritoDeLaCompra(Componente[] productos, Date fecha, Cliente c) {
		this.productos = productos;
		this.fecha = fecha;
		this.c = c;
	}
	
	
	//Métodos
	public void anyadirProducto(Fabricante fabricante, int codigo, String descripcion, double pvp) {
		this.productos[productos.length].setFabricante(fabricante);
		this.productos[productos.length].setCodigo(codigo);
		this.productos[productos.length].setDescripcion(descripcion);
		this.productos[productos.length].setPvp(pvp);
	}

	public boolean eliminarProducto(int codigo) {	
		for(int i = 0; i < productos.length; i++) {
			if(this.productos[i].getCodigo() == codigo) {
				for(int j = i; j < productos.length; j++) {
					this.productos[j] = productos[j + 1];
				}
				return true;
			}
		}
		System.out.println("No hay ningun objeto con ese codigo.");
		return false;
	}
	
	public Venta comprar(Date fecha, String pago) {
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
	public Date getFecha() {
		return fecha;
	}

	public Date setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
