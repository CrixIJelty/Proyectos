/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productos.dao;
import com.mycompany.productos.model.Producto;
import com.mycompany.productos.util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author thecr
 */
public class ProductoDao {
    private Connection con;

    // Constructor
    public ProductoDao(Connection con) {
        this.con = con;
    }

    // ============================
    // INSERTAR PRODUCTO
    // ============================

    public void insertar(Producto p) throws SQLException {

        String sql = "INSERT INTO producto(nombre, descripcion, precio, stock) " + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps =
                con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());

            ps.executeUpdate();

            // Obtener ID generado automáticamente
            try (ResultSet rs = ps.getGeneratedKeys()) {

                if (rs.next()) {
                    p.setId(rs.getInt(1));
                }
            }
        }
    }

    // ============================
    // LISTAR PRODUCTOS
    // ============================

    public List<Producto> listar() throws SQLException {

        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT id, nombre, descripcion, precio, stock FROM producto";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                lista.add(new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                ));
            }
        }

        return lista;
    }

    // ============================
    // BUSCAR PRODUCTO POR ID
    // ============================

    public Producto buscarPorId(int id) throws SQLException {

        String sql = "SELECT id, nombre, descripcion, precio, stock from producto where id = ?";

        try (Connection con = Conexion.obtenerConexion(); 
                PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Producto(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getDouble("precio"),
                            rs.getInt("stock")
                    );
                }
            }
        }

        return null;
    }

    // ============================
    // ACTUALIZAR PRODUCTO
    // ============================

    public void actualizar(Producto p) throws SQLException {

        String sql = "UPDATE producto "+ "SET nombre=?, descripcion=?, precio=?, stock=? "+ "WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getId());

            ps.executeUpdate();
        }
    }

    // ============================
    // ELIMINAR PRODUCTO
    // ============================

       public void eliminar(int id) throws SQLException {

        String sql = "DELETE FROM producto WHERE id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }

}