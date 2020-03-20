import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CarritoDeLaCompra {
	// Atributos
	private Componente[] productos;
	private Date fecha;
	private Cliente c;

	// Constructores
	public CarritoDeLaCompra(Componente[] productos, String fecha, Cliente c) {
		super();
		this.productos = productos;
		setFecha(fecha);
		this.c = c;
	}

	// Métodos
	
	public boolean anyadirProducto(int codigo) { 
		int j = 0; 
		for(int i = 0; i <=productos.length; i++)
		 { if(this.productos[i].getCodigo() == codigo) { 
			 j = i;
		  } if(i == productos.length && j != 0) { productos[i] = productos[j]; return
		 true; } 
		} 
	return false; }
	 

	public void anyadirProducto(Componente producto) {
		productos[productos.length] = producto;
	}

	public boolean eliminarProducto(int codigo) {
		for (int i = 0; i < productos.length; i++) {
			if (this.productos[i].getCodigo() == codigo) {
				for (int j = i; j < productos.length; j++) { // productos.length-1
					this.productos[j] = productos[i + 1]; // this.productos[j] = productos[j + 1];
				}
				return true;
			}
		}
		System.out.println("No hay ningun objeto con ese codigo."); // Poner el System.out.println() en el test
		return false;
	}

	public Venta comprar(int fecha, boolean pago) {
		Date now= new Date();
		Venta v = new Venta(productos, pago, c, now);
	/*	if (pago != "transferencia bancaria" | pago != "pago con tarjeta") {
			System.out.println("Metodo de pago incorrecto");
		}*/
		return v;
	}

	public String toString() {
		String s = "\n";
		double precioTot = 0;
		if (productos.length > 0) {
			for (int i = 0; i < productos.length; i++) {
				s += productos[i].toString() + "\n";
				precioTot += productos[i].getPvp();
			}
			return s += "Precio total: " + precioTot;
		} else {
			return "No hay productos en el carrito";
		}

	}

	public Date fromStringToDate(String fechaS) {

		String [] fecha = fechaS.split("/");
		int dia = Integer.parseInt(fecha[0]); 
		int mes = Integer.parseInt(fecha[1]);
		int año = Integer.parseInt(fecha[2]);

		Calendar calendar = Calendar.getInstance();
		calendar.set(año,mes,dia);
 
		return calendar.getTime();
	};

	//Getters y setters
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		Date fechaD= fromStringToDate(fecha);
		this.fecha = fechaD;
	}


}
