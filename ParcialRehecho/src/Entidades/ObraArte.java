
package Entidades;

import java.util.Random;

/**
 *
 * @author Fabri
 */
public abstract class ObraArte implements Comparable<ObraArte>{
    protected Artista artista;
    protected int cantidadDeElementos;
    protected String titulo;
    protected double valor;
    protected static Random generadorDeElementos;
    
    static
    {
        generadorDeElementos = new Random();
    }
    
    public ObraArte(String titulo, double valor, Artista artista)
    {
        this.titulo = titulo;
        this.valor = valor;
        this.artista = artista;
    }
    
    public ObraArte(String titulo, double valor, String nombre, String apellido)
    {
        this(titulo, valor, new Artista(nombre, apellido));
    }
    
    public int getCantidadDeElementos()
    {
        if(cantidadDeElementos == 0)
        {
            this.cantidadDeElementos = generadorDeElementos.nextInt(10) + 1;
        }
        return this.cantidadDeElementos;
    }
    
    private String mostrar(ObraArte obra)
    {
        return "";
    }
    
    public static boolean sonIguales(ObraArte o1, ObraArte o2){
        boolean esIgual = false;
        if(Artista.sonIguales(o1.artista, o2.artista) && o1.titulo.equals(o2.titulo))
        {
            esIgual = true;
        }
        return esIgual;
    }
    
    @Override
    public int compareTo(ObraArte otra)
    {
        return this.titulo.compareTo(otra.titulo);
    }
    
    @Override
    public boolean equals(Object obj){
        boolean esIgual = false;
        if(this == obj)
        {
            esIgual = true;
        }else if(obj != null && this.getClass() == obj.getClass())
        {
            ObraArte otra = (ObraArte)obj;
            //if(this.titulo.equals(otra.titulo) && Artista.sonIguales(this.artista, otra.artista))
            if(ObraArte.sonIguales(this,otra))
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
        
        sb.append("Titulo: ").append(this.titulo);
        sb.append(System.lineSeparator());
        sb.append("Artista: ").append(this.artista.getNombreApellido());
        sb.append(System.lineSeparator());
        sb.append("Cantidad de elementos: ").append(this.getCantidadDeElementos());
        sb.append(System.lineSeparator());
        
        return sb.toString();
    }
    
}
