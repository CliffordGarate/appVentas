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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class EmpleadoDAO {
    public static ArrayList<Empleado> listarempleado(){
        ArrayList<Empleado> listaem = new ArrayList<>();
        
     String sql= "SELECT nombre FROM empleado";
     Connection cn = Conexion.Abrir();
     Empleado cl;
     
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
                     
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                cl = new Empleado();
                cl.setNombre(rs.getString(1));
                listaem.add(cl);
            }
            rs.close();
            ps.close();
            cn.close();
                    
            
        } catch (SQLException ex) {
            System.out.println("Error:"+ex);
        }
        return listaem;
    }
   
    
    
}
