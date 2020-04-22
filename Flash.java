
public class Flash extends Memoria{
    int velocidad;

    public Flash(Fabricante fabricante, int codigo, String descripcion, double pvp, int tamaño, int velocidad){
        super(fabricante, codigo, descripcion, pvp, tamaño);
        this.velocidad=velocidad;
    }

    public String toString(){
        return  super.toString() + "\tVelocidad: " + this.velocidad + "\n";
    }

}
