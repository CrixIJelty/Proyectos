/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productos.dao;

import com.mycompany.productos.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author thecr
 */
public class UsuarioDao {

    private Connection con;

    public UsuarioDao(Connection con) {

        this.con = con;
    }

    public Usuario login(
            String nombre,
            String password) throws Exception {

        String sql =
                "SELECT * FROM usuario "
                + "WHERE nombre=? AND password=?";

        try (PreparedStatement ps =
                con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, password);

            try (ResultSet rs =
                    ps.executeQuery()) {

                if (rs.next()) {

                    Usuario u = new Usuario();

                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setPassword(rs.getString("password"));
                    u.setRol(rs.getString("rol"));

                    return u;
                }
            }
        }

        return null;
    }
}
