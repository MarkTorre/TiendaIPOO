
public class Raton {
  int botones;
  
  public Raton(Fabricante fabricante, int codigo, String descripcion, double pvp, String puerto, int botones){
        super(fabricante, codigo, descripcion, pvp, puerto);
        this.botones = botones; 
    }
  
  public String toString(){
        return  super.toString() + "Botones: " + this.botones + "\n" ;
  }
  
  public String getBotones(){
      return this.botones;
    }
    
    public void setBotones(int botones) {
      this.botones = botones;
    }
}
