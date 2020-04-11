
public class ProductoEnStock { 
    private Componente componente;
    private int disponible, reservado; 

    public ProductoEnStock(Componente componente, int disponible){
        
            this.componente=componente;  //no creamos un nuevo componente porque queremos solo la referencia
            this.disponible=disponible;
            this.reservado=0;
    }

public Componente getComponente(){
    return this.componente;
}  

public int getDisponible(){
    return this.disponible;
}

}