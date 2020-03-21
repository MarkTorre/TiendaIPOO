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
	private int numComp=0;
	public static int MaxBought= 1000;


	// Constructores
	public CarritoDeLaCompra(String fecha, Cliente c) {
		setFecha(fecha);
		this.c = c;
		this.productos= new Componente[MaxBought];
	}

	public CarritoDeLaCompra(Componente[] productos, String fecha, Cliente c) {
		super();
		this.productos = productos;
		setFecha(fecha);
		this.c = c;
	}

	
	public String toString() {
		String s = "\n";
		double precioTot = 0;
		if (numComp > 0) {
			for (int i = 0; i < numComp; i++) {
				if(productos[i] != null){
				s += this.productos[i].toString() + "\n\n";
				precioTot += productos[i].getPvp();
				}
			}
			return s += "Precio total: " + precioTot+ "\n"  ;
		} else {
			return "No hay productos en el carrito";
		}

	}
	// Métodos
	/*
	public boolean anyadirProducto(int codigo, Componente tienda[] ) { 
		int j = 0; 
		for(int i = 0; i <=productos.length; i++)
		 { if(this.productos[i].getCodigo() == codigo) { 
			 j = i;
		  } if(i == productos.length && j != 0) { productos[i] = productos[j]; return
		 true; } 
		} 
	return false; }*/

	public boolean anyadirProducto(int codigo, Componente tienda[] ) { 
		for(int i = 0; i < tienda.length; i++){
				if(tienda[i].getCodigo()== codigo){
					Componente componente = new Componente(tienda[i]);
					setComponente(componente);
					numComp=numComp+1;
					return true;
				}
		}	
		return false;
	}


	public boolean eliminarProducto(int codigo) {
		for (int i = 0; i < numComp; i++) {
			if (this.productos[i].getCodigo() == codigo) {
				for (int j = i+1; j <= numComp; j++) { // Aquí ponemos j<=numComp para que en la ultima posición nos ponga un null 
					this.productos[j-1] = this.productos[j]; // this.productos[j] = productos[j + 1];
				}
				numComp--;
				return true;
			}
		}
		System.out.println("No hay ningun objeto con ese codigo."); // Poner el System.out.println() en el test
		return false;
	}


	public Venta comprar(int fecha, boolean pago) {
		Date now= new Date();
		Venta v = new Venta(this.productos, pago, c, now);
	/*	if (pago != "transferencia bancaria" | pago != "pago con tarjeta") {
			System.out.println("Metodo de pago incorrecto");
		}*/
		return v;
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

	public void setComponente(Componente componente){
			this.productos[numComp]= componente;
	
	}

}
