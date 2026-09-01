/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productos.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author thecr
 */
public class Venta {
     private int id;
    private LocalDate fecha;
    private int idCliente;

    // Constructor vacío
    public Venta() {
    }

    // Constructor completo
    public Venta(LocalDate fecha, int idCliente) {

    this.fecha = fecha;
    this.idCliente = idCliente;
}

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

}
