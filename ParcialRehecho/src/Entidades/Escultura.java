
package Entidades;

/**
 *
 * @author Fabri
 */
public class Escultura extends ObraArte implements IVendible{

    private MaterialEscultura material;
    
    public Escultura(String titulo, double valor, Artista artista, MaterialEscultura material) {
        super(titulo, valor, artista);
        this.material = material;
    }

    @Override
    public double getValorComercial() {
        double valorFinal = this.valor;
        if(null != this.material){
            switch (this.material) {
            case MARMOL:
                valorFinal *= 1.50;
                break;
            case BRONCE:
                valorFinal *= 1.40;
                break;
            case MADERA:
                valorFinal *= 1.20;
                break;
            default:
                break;
            }
        }
        return valorFinal;
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
    
    @Override
    public boolean equals(Object obj)
    {
        boolean esIgual = false;
        if(obj instanceof Escultura){
            Escultura otra = (Escultura) obj;
            if(super.equals(otra)&& this.material == otra.material)
            {
                esIgual = true;
            }
        }
        return esIgual;
    }
}
