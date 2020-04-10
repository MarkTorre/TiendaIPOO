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
	public static int MaxBought= 2; //1000


	// Constructor Vacio
	public CarritoDeLaCompra(Date fecha, Cliente c) {
		setFecha(fecha);
		this.c = c;
		this.productos= new Componente[MaxBought];
	}

	//Constructor Copia
	public CarritoDeLaCompra(CarritoDeLaCompra carrito) {
		this.productos= carrito.getProductos(); 
		setFecha(carrito.getFecha());
		this.c= carrito.getCliente();
		this.numComp= carrito.getNumeroComponentes();
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
	
	public boolean anyadirProducto(Componente componente ) { 
			this.numComp++;
			if (this.numComp < MaxBought ){this.productos[numComp]= componente;
			return true;}
			return false;
	}

	public boolean eliminarProducto(int codigo) {
		for (int i = 0; i < numComp; i++) {
			if (this.productos[i].getCodigo() == codigo) {
				for (int j = i+1; j <= numComp; j++) { 
					// Aquí ponemos j<=numComp para que en la última posición nos ponga un null 
					// No es pot fer ja que si la taula està plena es produeix un error java.lang.ArrayIndexOutOfBoundsException
					this.productos[j-1] = this.productos[j]; 
				}
				this.numComp--;
				// J: Si voleu posar l'últim a null s'ha de fer aquí
				// J: this.productos[this.numComp] = null;
				// J: Fixeu-vos que al haver decrementat el número segur que mai us podeu sortir de la taula
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

	public Componente[] getProductos(){
		return this.productos;
	}
	public int getNumeroComponentes(){
		return this.numComp;
	}
	public Date getFecha() {
		return this.fecha;
	}

	public Cliente getCliente() {
		return this.c;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}

