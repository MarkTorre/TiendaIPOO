public class Componente {
    private Fabricante fabricante;
    private int codigo;
    private String descripcion;
    private double pvp;

public Componente(){

}

/*----------------Metodos Setters ------------------*/

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


/*----------------Mètodos Getters----------------- */
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