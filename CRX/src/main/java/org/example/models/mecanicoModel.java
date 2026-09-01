package org.example.models;

public class mecanicoModel {
    private String nombre;
    private String direccion;
    private String telefono;
    private String dpi;
    private String email;
    private String especialidad;
    private int edad;

    public mecanicoModel(){}

    public mecanicoModel(String nombre, String direccion, String telefono, String dpi, String email, String especialidad, int edad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dpi = dpi;
        this.email = email;
        this.especialidad = especialidad;
        this.edad = edad;
    }
    public mecanicoModel(String nombre){
        this.nombre = nombre;
    }
    //Obtener
    public String getNombre(){
        return this.nombre;
    }
    //Setear
    public void setNombre(){
        this.nombre = nombre;
    }


    {

    }

}
