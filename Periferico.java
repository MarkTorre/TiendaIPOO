
public class Periferico extends Componente{
  private String puerto;
  
  public Periferico(Fabricante fabricante, int codigo, String descripcion, double pvp, String puerto){
    super(fabricante, codigo, descripcion, pvp);
    this.puerto = puerto;
  }
  
     public String toString(){
       return  super.toString() + "Puerto de comunicacion: " + this.puerto + "\n" ;
   }

    public String getPuerto(){
      return this.puerto;
    }
    
    public void setPuerto(String puerto) {
      this.puerto = puerto;
    }
}
