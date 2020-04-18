
public class Teclado extends Periferico {
    private String idioma;

    public Teclado(Fabricante fabricante, int codigo, String descripcion, double pvp, String tipo, String idioma){
        super(fabricante, codigo, descripcion, pvp, tipo);
        this.idioma=idioma;
    }

    public String toString(){
        return super.toString() + this.idioma +"\n";
    }

    public String getIdioma(){
        return this.idioma;
    }
    

}