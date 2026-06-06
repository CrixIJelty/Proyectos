/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productos.dao;
import com.mycompany.productos.model.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
/**
 *
 * @author thecr
 */
public class DetalleVentaDao {
    private Connection con;

    public DetalleVentaDao(Connection con) {
        this.con = con;
    }

    public DetalleVentaDao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
// INSERTAR DETALLE
    public void insertar(DetalleVenta dv)
            throws SQLException {

        String sql =
                "INSERT INTO detalle_venta" + "(id_venta, id_producto, cantidad, precio) "+ "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps =
                con.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, dv.getIdVenta());
            ps.setInt(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecio());

            ps.executeUpdate();

            try (ResultSet rs =
                    ps.getGeneratedKeys()) {

                if (rs.next()) {

                    dv.setId(rs.getInt(1));
                }
            }
        }
    }

    public List<DetalleVenta> buscarPorIdVenta(int idVenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
