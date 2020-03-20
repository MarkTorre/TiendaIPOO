import java.util.Date;

public class Venta {
    private Date fecha;
    private Componente[] productos;
    private Cliente c;
    private  boolean metodopago;
    
    public Venta(Componente[] producto,boolean metodopago, Cliente c, Date fecha ){
           
            setComponente(productos);
            setMetodoPago(metodopago);
            setCliente(c);
            setFecha(fecha);

    }

/*******************Métodos Getter*****************/
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