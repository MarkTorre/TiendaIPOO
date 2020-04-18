
public class Memoria extends Componente{
    private int tamaño;
       
    public Memoria(Fabricante fabricante, int codigo, String descripcion, double pvp, int tamaño){ 
       super(fabricante, codigo, descripcion, pvp);
       this.tamaño= tamaño;

   }

   public String toString(){
       return  super.toString() + "Tamaño: " + this.tamaño + "\n" ;
   }

    public int getTamaño(){
        return this.tamaño;
    }
    
    public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
}
