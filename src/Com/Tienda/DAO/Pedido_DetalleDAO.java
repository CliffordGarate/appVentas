/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.Tienda.DAO;

import Com.Tienda.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Com.Tienda.Bean.Pedido_Detalle;


public class Pedido_DetalleDAO {
   
   
   
      public static void insertarpedidodetalle(Pedido_Detalle pd ) {

        //instruccion sql para inserta un empleado
        String sql = "insert into pedido_detalle(idarticulo,idpedido,precio,cantidad,subtotal)values(?,?,?,?,?)"; //el idempleado se autoenumera por lo tanto no lo menciono.
        //abrimos la conexion a la B.D.
        Connection cn = Conexion.Abrir();
        try {
            //Objeto ps que ejecuta la sentencia sql
            PreparedStatement ps = cn.prepareStatement(sql);   // LA SENTENCIA GENERA UNA EXCEPCION TRY-CATCH
            //Asignamos valores a los parametro que estan en la sentencia ?,?,?,?
            ps.setInt(1, pd.getIdarticulo());
            ps.setInt(2, pd.getIdpedido());
            ps.setFloat(3, pd.getPrecio());
            ps.setInt(4, pd.getCantidad());
            ps.setFloat(5, pd.getSubtotal());
            //ejecutamos "Update" se usa para sentencias SQL (insert, Update y Delete)
            ps.executeUpdate();
            //cerramos ps y cn
            ps.close();
            cn.close();
           
        } catch (SQLException ex) {
            System.out.println("Error aqui en insertar "+ex);
        }

    }
}
