class PlacaBase extends Componente{
    public PlacaBase(Fabricante fabricante, int codigo, String descripcion, double pvp, int tamaño){
        super(fabricante, codigo, descripcion, pvp);
    }

    public String toString(){
        return super.toString();
    }
    
}