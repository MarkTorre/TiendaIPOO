
public class Periferico extends Componente {
    private String tipo;

    public Periferico(Fabricante fabricante, int codigo, String descripcion, double pvp, String tipo){
        super(fabricante, codigo, descripcion, pvp);
        this.tipo=tipo;

    }

    public String toString(){
        return super.toString()+ this.tipo+"\n\t";
    }

    public String getTipo(){
        return this.tipo;
    }


}