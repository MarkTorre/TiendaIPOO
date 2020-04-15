
public class Teclado {
  String idioma;
  
  public Teclado(Fabricante fabricante, int codigo, String descripcion, double pvp, String puerto, String idioma){
        super(fabricante, codigo, descripcion, pvp, puerto);
        this.idioma = idioma; 
    }
  
  public String toString(){
        return  super.toString() + "Idioma: " + this.idioma + "\n" ;
  }
  
  public String getIdioma(){
      return this.idioma;
    }
    
    public void setIdioma(int idioma) {
      this.idioma = idioma;
    }
  
}
