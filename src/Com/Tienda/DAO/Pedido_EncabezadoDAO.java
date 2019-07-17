/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.Tienda.DAO;

import Com.Tienda.Bean.Empleado;
import Com.Tienda.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Com.Tienda.Bean.Pedido_Encabezado;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Dell
 */
public class Pedido_EncabezadoDAO {
    
      public static void insertarpedidoencabezado(Pedido_Encabezado pe ) {

        //instruccion sql para inserta un empleado
        String sql = "insert into pedido_encabezado(idpedido,fecha,total,idempleado,idcliente)values(?,?,?,?,?)"; //el idempleado se autoenumera por lo tanto no lo menciono.
        //abrimos la conexion a la B.D.
        Connection cn = Conexion.Abrir();
        try {
            //Objeto ps que ejecuta la sentencia sql
            PreparedStatement ps = cn.prepareStatement(sql);   // LA SENTENCIA GENERA UNA EXCEPCION TRY-CATCH
            //Asignamos valores a los parametro que estan en la sentencia ?,?,?,?
           ps.setInt(1, pe.getIdpedido());
            ps.setDate(2, pe.getFecha());
            ps.setFloat(3, pe.getTotal());
            ps.setInt(4, pe.getIdempleado());
            ps.setInt(5, pe.getIdcliente());
            //ejecutamos "Update" se usa para sentencias SQL (insert, Update y Delete)
            ps.executeUpdate();
            //cerramos ps y cn
            ps.close();
            cn.close();
           
        } catch (SQLException ex) {
            System.out.println("Error aqui en insertar "+ex);
        }

    }
      //----------------------CONERVTIR NOMBRE EMPLEADO AH IDEMPLEADO--------------
      public static  ArrayList<Empleado>conversionempleado(String nom){
          ArrayList<Empleado> convemple = new ArrayList<>();
          String sql = "select idempleado from empleado where nombre = ?"; //el idempleado se autoenumera por lo tanto no lo menciono.
        Connection cn = Conexion.Abrir();
        Empleado em;
        try {
           
            PreparedStatement ps = cn.prepareStatement(sql);   
            ps.setString(1,nom);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                em = new Empleado();
                em.setIdempleado(rs.getInt(1));
                convemple.add(em);
            }
          
            rs.close();
            ps.close();
            cn.close();
           
        } catch (SQLException ex) {
            System.out.println("Error aqui en conversion empleado "+ex);
        }
        return convemple;
      }
      
}
