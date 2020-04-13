import java.util.Date;

public class Venta {
    //Atributos Objeto(aA.O)
    private Date fecha;
    private Componente[] productos;
    public int numComp;
    private Cliente c;
    private  boolean metodopago;
    //Constructor Venta
    public Venta(Componente[] producto,boolean metodopago, Cliente c,Date fecha , int numComp ){
           
            setComponente(producto);
            setMetodoPago(metodopago);
            setCliente(c);
            setFecha(fecha);
            this.numComp= numComp;

    }
    //Método toString
    public String toString(){
        
        String s = "";
		double precioTot = 0;
        String pago; 

        if(this.metodopago){
                pago = "transferencia bancaria";
        } else {
                pago = "pago con tarjeta";
        }

		if (this.numComp > 0) {
            
        System.out.println("Fecha: " + getFechaCompra() + "\n" + "ID cliente: " + c.getCodigo() + "\n" + "Método de pago: " + pago + "\n\n");

			for (int i = 0; i < this.numComp; i++) {
				if(this.productos[i] != null){
					s += this.productos[i].getCodigo() + "\n";
					precioTot += productos[i].getPvp();
				}
			}
			return s += "\nPrecio total de la venta: " + precioTot + "\n"  ;
		} else {
			return "No hay productos en el carrito se ha anulado la venta.";
		} 
    }

/*******************Métodos Getter*****************/
    public Componente[] getComponente(){
        return this.productos;
    }

    public boolean getMetodoPago(){
        return this.metodopago;
    }

    public Cliente getCliente(){
        return this.c;
    }

    public Date getFechaCompra(){
        return this.fecha;
    }
/******************Métodos Setters*****************/
  
    public void setComponente(Componente[] productos){
        this.productos=productos;
    }

    public void setMetodoPago(boolean metodopago){
        this.metodopago=metodopago;
    }

    public void setCliente(Cliente c) {
        this.c=c;
    }

    public void setFecha(Date fecha){
        this.fecha= fecha;
    };

}
