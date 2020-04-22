
class PlacaBase extends Componente{
    String procesador, ranura;
    int ancho, largo;
    
    public PlacaBase(Fabricante fabricante, int codigo, String descripcion, double pvp, int tamaño, String procesador, String ranura, int ancho, int largo){
        super(fabricante, codigo, descripcion, pvp);
        this.procesador = procesador;
        this.ranura = ranura;
        this.ancho = ancho;
        this.largo = largo;
    }

    public String toString(){
        return super.toString() + "\tProcesador: " + this.procesador + "\n\t" + "Ancho: " + this.ancho + "\n\t" + "Largo: " + this.largo + "\n\t" + "Ranura: " + this.ranura + "\n";
    }
    
}
