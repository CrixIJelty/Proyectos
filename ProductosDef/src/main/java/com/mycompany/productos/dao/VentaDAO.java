/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productos.dao;

import com.mycompany.productos.model.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class VentaDAO {

    private Connection con;

    // Constructor
    public VentaDAO(Connection con) {
        this.con = con;
    }

    // Método insertar
    public void insertar(Venta v) throws SQLException {

        String sql = "INSERT INTO venta(fecha, id_Cliente) VALUES (?, ?)";

        try (PreparedStatement ps =
                con.prepareStatement(sql)) {

            ps.setDate(
                    1,
                    Date.valueOf(v.getFecha())
            );

            ps.setInt(
                    2,
                    v.getIdCliente()
            );

            ps.executeUpdate();
        }
    }
}