/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Fabri
 */
public class Museo {
    private int capacidad;
    private ArrayList<ObraArte> obras;
    
    public Museo()
    {
        this.capacidad = 3;
        this.obras = new ArrayList<>();
    }
    
    public Museo(int capacidad)
    {
        this();
        this.capacidad = capacidad;
    }
    
    public boolean sonIguales(ObraArte obra)
    {
        return this.obras.contains(obra);
    }
    
    public void agregar(ObraArte obra)
    {
        if(this.obras.size()>= this.capacidad)
        {
            System.out.println("No se puede agregar mas obras. El museo esta lleno");
        }else if(sonIguales(obra))
        {
            System.out.println("La obra ya se encuentra en el museo");
        }else
        {
            this.obras.add(obra);
            System.out.println("Obra agregada correctamente al museo");
        }
    }
    
    private double getValor(TipoValor tipo)
    {
        double valorFinal = 0;
        for(ObraArte obra : obras)
        {
            if(obra instanceof IVendible)
            {
                if(tipo == TipoValor.PINTURAS && obra instanceof Pintura)
                {
                    valorFinal += ((IVendible) obra).getValorComercial();
                }
                if(tipo == TipoValor.ESCULTURAS && obra instanceof Escultura)
                {
                    valorFinal += ((IVendible) obra).getValorComercial();
                }
                if(tipo == TipoValor.TODAS)
                {
                    valorFinal += ((IVendible) obra).getValorComercial();
                }
            }
        }
        return valorFinal;
    }
    
    public void ordenar()
    {
        Collections.sort(obras);
    }
    
    public double getValorDePinturas()
    {
        return getValor(TipoValor.PINTURAS);
    }
    
    public double getValorDeEsculturas()
    {
        return getValor(TipoValor.ESCULTURAS);
    }
    
    public double getValorTotal()
    {
        return getValor(TipoValor.TODAS);
    }
    
    public static String mostrar(Museo museo)
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("MUSEO\n").append("--------------------\n\n");
        sb.append("CAPACIDAD MUSEO: ").append(museo.capacidad).append("\n\n");
        sb.append("CANTIDAD OBRAS EXHIBIDAS: ").append(museo.obras.size()).append("\n\n");
        sb.append("DETALLES DE OBRAS\n\n").append("----------------------------------\n");
        for(ObraArte obra : museo.obras)
        {
            sb.append(obra).append("\n---------------------------\n");
        }
        
        sb.append("VALOR TOTAL PINTURAS: ").append(String.format("%.2f", museo.getValorDePinturas()));
        sb.append(System.lineSeparator());
        sb.append("VALOR TOTAL ESCULTURAS: ").append(String.format("%.2f", museo.getValorDeEsculturas()));
        sb.append(System.lineSeparator());
        sb.append("VALOR TOTAL OBRAS: ").append(String.format("%.2f", museo.getValorTotal()));
        sb.append(System.lineSeparator());
        
        return sb.toString();
    }
}
