/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productos.dao;

import com.mycompany.productos.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author thecr
 */
public class ClienteDao {

    private Connection con;

    public ClienteDao(Connection con) {
        this.con = con;
    }

    public void insertar(Cliente c)
            throws SQLException {

        String sql = "INSERT INTO cliente(nombre, telefono, direccion)" + "VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getDireccion());

            ps.executeUpdate();
        }
    }
}
