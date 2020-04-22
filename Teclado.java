
public class Teclado extends Periferico{
  String idioma;
  
  public Teclado(Fabricante fabricante, int codigo, String descripcion, double pvp, String puerto, String idioma){
        super(fabricante, codigo, descripcion, pvp, puerto);
        this.idioma = idioma; 
    }
  
  public String toString(){
        return  super.toString() + "\tIdioma: " + this.idioma + "\n" ;
  }
  
  public String getIdioma(){
      return this.idioma;
    }
    
    public void setIdioma(String idioma) {
      this.idioma = idioma;
    }
  
}
