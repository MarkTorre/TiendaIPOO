public class Fabricante{
    //Atributos de Objeto (A.0)
    private String nombre;
    private int codigo, telefono;

    public Fabricante(String nombre, int codigo, int telefono){
        setNombre(nombre);
        setCodigo(codigo);
        setTelefono(telefono);
    }
/*----------------toString() ------------------*/

    public String toString(){

        return "\n\tnombre: " +this.nombre+ "\n\tcódigo: " + 
        this.codigo + "\n\tteléfono: " +this.telefono;
    }
/*----------------Métodos Setters ------------------*/

    public void setNombre(String nombre) {
        this.nombre =nombre;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }

/*----------------Métodos Getters----------------- */
    public String getNombre(){
        return this.nombre;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public int getTelefono(){
        return this.telefono;
    }



}