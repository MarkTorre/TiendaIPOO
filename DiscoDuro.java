
public class DiscoDuro extends Memoria {
    private String tipo;
    public DiscoDuro(Fabricante fabricante, int codigo, String descripcion, double pvp, int tamaño, String tipo){
        super(fabricante, codigo, descripcion, pvp, tamaño);    
        this.tipo= tipo;
    }

    public String toString(){
        return  super.toString()+"Tipo: "+this.tipo+"\n" ;
    }

    public String getDiscoDuro(){
        return this.tipo;
    }
}