
package Entidades;

/**
 *
 * @author Fabri
 */
public class Pintura extends ObraArte implements IVendible{
    private TecnicaPintura tecnica;

    public Pintura(String titulo, double valor, String nombre, String apellido, TecnicaPintura tecnica) {
        super(titulo, valor, nombre, apellido);
        this.tecnica = tecnica;
    }

    @Override
    public double getValorComercial() {
        double valorFinal = this.valor;
        if(null != this.tecnica){
            switch (this.tecnica) {
            case OLEO:
                valorFinal *= 1.30;
                break;
            case ACRILICO:
                valorFinal *= 1.20;
                break;
            case ACUARELA:
                valorFinal *= 1.10;
                break;
            default:
                break;
            }
        }
        return valorFinal;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        boolean esIgual = false;
        if(obj instanceof Pintura){
            Pintura otra = (Pintura) obj;
            if(super.equals(otra)&& this.tecnica == otra.tecnica)
            {
                esIgual = true;
            }
        }
        return esIgual;
    }
       
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append(super.toString());
        sb.append("Valor: ").append(getValorComercial());
        sb.append(System.lineSeparator());
        
        return sb.toString();
    }
}
