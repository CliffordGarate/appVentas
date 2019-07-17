/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.Tienda.DAO;

import Com.Tienda.Bean.Articulo;
import Com.Tienda.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArticuloDAO {
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static Connection cn;
    
    //----------------------LISTA PEQUEÑA DE ARTICULOS----------------------///
    public static ArrayList<Articulo> listararticulo(String nom){
        ArrayList<Articulo> listart = new ArrayList<>();
        String sql= "Select nombre,idarticulo,descripcion,precio from articulo where nombre like ?";
         cn = Conexion.Abrir();
         Articulo art;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nom+"%");
            rs = ps.executeQuery();
            
           while(rs.next()){
               art = new Articulo();
               art.setNombre(rs.getString(1));
               art.setId_articulo(rs.getInt(2));
               art.setDescripcion(rs.getString(3));
               art.setPrecio(rs.getFloat(4));
               
               listart.add(art);
           }
           cn.close();
           ps.close();
           rs.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en listar articulo: "+ex);
        }
        return listart;
    }
    
    
    
    
}
