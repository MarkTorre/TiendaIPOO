
public class Memoria extends Componente{
    private int tamaño;
       
    public Memoria(Fabricante fabricante, int codigo, String descripcion, double pvp, int tamaño){ 
       super(fabricante, codigo, descripcion, pvp);
       this.tamaño= tamaño;

   }

   public String toString(){
       String t= String.valueOf(tamaño);
        return  super.toString()+t+"\n" ;
   }

    public int getTamaño(){
        return this.tamaño;
    }
}