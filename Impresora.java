
public class Impresora extends Periferico {
  String impresion;
  
  public Impresora(Fabricante fabricante, int codigo, String descripcion, double pvp, String puerto, String impresion){
        super(fabricante, codigo, descripcion, pvp, puerto);
        this.impresion = impresion; 
    }
  
  public String toString(){
        return  super.toString() + "\tImpresion: " + this.impresion + "\n" ;
  }
  
  public String getImpresion(){
      return this.impresion;
    }
    
    public void setImpresion(String impresion) {
      this.impresion = impresion;
    }
  
}
