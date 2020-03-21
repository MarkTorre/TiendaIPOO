import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CarritoDeLaCompra {
   //Atributos Objeto(A.O)
	private Componente[] productos;
	private Date fecha;
	private Cliente c;
	private int numComp=0;

	//Atributo Classe (A.C)
	public static int MaxBought= 1000;


	// Constructor Tabla Vacia
	public CarritoDeLaCompra(String fecha, Cliente c) {
		setFecha(fecha);
		this.c = c;
		this.productos= new Componente[MaxBought];
	}
	//Constructor Tabla Definida
	public CarritoDeLaCompra(Componente[] productos, String fecha, Cliente c) {
		super();
		this.productos = productos;
		setFecha(fecha);
		this.c = c;
	}

	
	public String toString() {
		String s = "\n";
		double precioTot = 0;
		if (this.numComp > 0) {
			for (int i = 0; i < this.numComp; i++) {
				if(productos[i] != null){
				s += this.productos[i].toString() + "\n\n";
				precioTot += productos[i].getPvp();
				}
			}
			return s +="----------------------------------"+"\nPrecio total: " + precioTot+ "\n"  ;
		} else {
			return "\t No hay productos en el carrito\n";
		}


	}
	//Métodos Lista (Tabla) Componentes
	public boolean anyadirProducto(int codigo, Componente tienda[] ) { 
		for(int i = 0; i < tienda.length; i++){
				if(tienda[i].getCodigo()== codigo){
					Componente componente = new Componente(tienda[i]);
					setComponente(componente);
					this.numComp=this.numComp+1;
					return true;
				}
		}	
		return false;
	}


	public boolean eliminarProducto(int codigo) {
		for (int i = 0; i < numComp; i++) {
			if (this.productos[i].getCodigo() == codigo) {
				for (int j = i+1; j <= numComp; j++) { // Aquí ponemos j<=numComp para que en la última posición nos ponga un null 
					this.productos[j-1] = this.productos[j]; 
				}
				this.numComp--;
				return true;
			}
		}
		return false;
	}


	public Venta comprar(boolean pago) {
		Componente[] componentes= this.productos;
		Date now= new Date();
		int numerocompra = this.numComp;
		Venta v = new Venta(componentes, pago, this.c, now, numerocompra);
		return v;
	}



	//Métodos Getters y setters
	public int getNumeroComponentes(){
		return this.numComp;
	}
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

	//Métodos de conversión
	public Date fromStringToDate(String fechaS) {

		String [] fecha = fechaS.split("/");
		int dia = Integer.parseInt(fecha[0]); 
		int mes = Integer.parseInt(fecha[1]);
		int año = Integer.parseInt(fecha[2]);

		Calendar calendar = Calendar.getInstance();
		calendar.set(año,mes,dia);
 
		return calendar.getTime();
	};


}
