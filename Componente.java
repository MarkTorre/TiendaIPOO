public class Componente {
    //Atributos de Objeto
    private Fabricante fabricante;
    private int codigo;
    private String descripcion;
    private double pvp;

    //Constructor Componente
    public Componente(Fabricante fabricante, int codigo, String descripcion, double pvp){
        setFabricante(fabricante);
        setCodigo(codigo);
        setDescripcion(descripcion);
        setPvp(pvp);
    }
    
    //Constructor Copia
    public Componente(Componente comp){
        this(comp.getFabricante(),comp.getCodigo(), comp.getDescripcion(), comp.getPvp());

    }

/*------------------ toString ---------------------*/

    public String toString(){
        return "\tProducto: " + getCodigo() + " " + getDescripcion() +
                "\n\tPrecio: " + getPvp() + "\n\tFabricante: " + getFabricante().getNombre() +
                "( " + getFabricante().getCodigo() + " )";
}

/*----------------Métodos Setters ------------------*/

    public void setFabricante(Fabricante fabricante) {
        this.fabricante=fabricante;
    }

    public void setCodigo(int codigo){
        this.codigo= codigo;
    }
    public void setDescripcion(String descripcion){
        this.descripcion= descripcion;
    }

    public void setPvp(double pvp){
        this.pvp= pvp;
    }


/*----------------Métodos Getters----------------- */
    public Fabricante getFabricante(){
        return this.fabricante;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public double getPvp(){
        return this.pvp;
    }

}