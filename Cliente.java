public class Cliente{

    //Atributos Ojeto (A.O) 
    private int codigo;
    private String nombre, apellido,tarjeta;

    //Constructor Cliente 
    public Cliente(int codigo,String nombre, String apellido, String tarjeta){
            setCodigo(codigo);
            setNombre(nombre);
            setNumeroTarjeta(tarjeta);
    }

/*----------------Metodos Setters ------------------*/
    public void setCodigo(int codigo) {
        this.codigo=codigo;
    }

    public void setNombre(String nombre){
        this.nombre= nombre;
    }

    public void setApellido(String apellido){
        this.apellido= apellido;
    }

    public void setNumeroTarjeta(String tarjeta){
        this.tarjeta= tarjeta;
    
    }


/*----------------Mètodos Getters----------------- */
    public int getCodigo(){
        return this.codigo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public String getNumeroTarjeta(){
        return this.tarjeta;
    }

}