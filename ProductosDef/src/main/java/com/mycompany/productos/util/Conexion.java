/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author thecr
 */
    
public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/productos";

    private static final String USER = "root";

    private static final String PASSWORD = "Casa2021/";

    public static Connection obtenerConexion() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

