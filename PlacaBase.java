
class PlacaBase extends Componente{
    private String tipoProcesador, tamaño, ranura;
 
    public PlacaBase(Fabricante fabricante, int codigo, String descripcion,
     double pvp, String tipoProcesador, String tamaño, String ranura){
        super(fabricante, codigo, descripcion, pvp);
        this.tipoProcesador= tipoProcesador;
        this.tamaño=tamaño;
        this.ranura=ranura;
    }

    public String toString(){
        return super.toString() +"Tipo de procesador: "+ this.tipoProcesador
        +"Tamaño: "+ this.tamaño +"Ranura: "+ this.ranura;
    }
    
    public String getTipoProcesador(){
        return this.tipoProcesador;
    }

    public String getTamaño(){
        return this.tamaño;
    }
    public String getRanura(){
        return this.ranura;
    }
}