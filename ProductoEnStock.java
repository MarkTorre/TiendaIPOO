public class ProductoEnStock {
    private Componente componente;
    private int udsDisponibles, udsReservadas; 
	
    
    public ProductoEnStock(Componente componente, int udsDisponibles){
        this.componente = componente; 
        this.udsDisponibles = udsDisponibles;
        this.udsReservadas = 0;
    }


    public Componente getComponente(){
    	return this.componente;
    }  

	public int getUdsDisponibles() {
		return udsDisponibles;
	}

	public void setUdsDisponibles(int udsDisponibles) {
		this.udsDisponibles = udsDisponibles;
	}

	public int getUdsReservadas() {
		return udsReservadas;
	}

	public void setUdsReservadas(int udsReservadas) {
		this.udsReservadas = udsReservadas;
	}
	
}
