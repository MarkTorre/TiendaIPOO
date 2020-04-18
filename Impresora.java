
public class Impresora extends Componente {
  String impresion;
  
  public Impresora(Fabricante fabricante, int codigo, String descripcion, double pvp, String puerto, String impresion){
        super(fabricante, codigo, descripcion, pvp, puerto);
        this.impresion = impresion; 
    }
  
  public String toString(){
        return  super.toString() + "Impresion: " + this.impresion + "\n" ;
  }
  
  public String getImpresion(){
      return this.impresion;
    }
    
    public void setImpresion(int impresion) {
      this.impresion = impresion;
    }
  
}
