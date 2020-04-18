class Impresora extends Periferico{
    private String tipoImpresion;

    public Impresora(Fabricante fabricante, int codigo, String descripcion, double pvp, String tipo, String tipoImpresion){
        super(fabricante, codigo, descripcion, pvp, tipo);
        this.tipoImpresion=tipoImpresion;

    }

    public String toString(){
        return super.toString() + this.tipoImpresion +"\n";
    }

    public String getTipoImpresion(){
        return this.tipoImpresion;
    }
    
}