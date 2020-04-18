
public class Raton extends Periferico{

    private int numBotones;

    public Raton(Fabricante fabricante, int codigo, String descripcion, double pvp, String tipo, int numBotones){
        super(fabricante, codigo, descripcion, pvp, tipo);
        this.numBotones=numBotones;
    }

    public String toString(){
        return super.toString() + this.numBotones +"\n";
    }

    public int getNumBotones(){
        return this.numBotones;
    }

}