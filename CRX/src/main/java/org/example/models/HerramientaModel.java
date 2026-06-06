package org.example.models;

public class HerramientaModel {
    private String nombredeherramienta;
    private int cantidaddeherramienta;
    private int numerodemodelo;
    private String Estadodeherramientas;

    public HerramientaModel(){}

    public HerramientaModel(String nombredeherramienta, int cantidaddeherramienta, int numerodemodelo, String Estadodeherramientas) {
        this.nombredeherramienta = nombredeherramienta;
        this.cantidaddeherramienta = cantidaddeherramienta;
        this.numerodemodelo = numerodemodelo;
        this.Estadodeherramientas = Estadodeherramientas;

    }

    public HerramientaModel(String nombredeherramienta){
        this.nombredeherramienta = nombredeherramienta;
    }
    //Obtener
    public String getNombredeherramienta(){
        return this.nombredeherramienta;
    }

    //Setear
    public void setNombredeherramienta(String nombredeherramienta) {
        this.nombredeherramienta = nombredeherramienta;
    }

    {

    }

    {

    }
}
