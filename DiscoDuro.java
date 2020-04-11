
public class DiscoDuro extends Memoria {
    String tipo;
    public DiscoDuro(Fabricante fabricante, int codigo, String descripcion, double pvp, int tamaño, String tipo){
        super(fabricante, codigo, descripcion, pvp, tamaño);    
        this.tipo= tipo;
    }

    public String toString(){
        return  super.toString()+this.tipo+"\n" ;
    }

}