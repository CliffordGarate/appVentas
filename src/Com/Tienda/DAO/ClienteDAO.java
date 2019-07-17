/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.Tienda.DAO;

import Com.Tienda.Bean.Cliente;
import Com.Tienda.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ClienteDAO {
    //--------------LISTAR CON NOMBRE-----------------------------
   public static ArrayList<Cliente> listarclientexnombre(String nom){
        ArrayList<Cliente> listacli = new ArrayList<>();
        
     String sql= "SELECT nombres,idcliente FROM cliente WHERE nombres LIKE ?";
     Connection cn = Conexion.Abrir();
     Cliente cl;
     
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,nom+"%");
           
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                cl = new Cliente();
                cl.setId_clientes(rs.getInt(2));
                cl.setNombre(rs.getString(1));
                listacli.add(cl);
            }
            rs.close();
            ps.close();
            cn.close();
                    
            
        } catch (SQLException ex) {
            System.out.println("Error:"+ex);
        }
        return listacli;
    }
   //--------------LISTAR CON ID-----------------------------
   public static ArrayList<Cliente> listarclientxid(int id){
        ArrayList<Cliente> listacli = new ArrayList<>();
        
     String sql= "SELECT nombres,idcliente FROM cliente WHERE idcliente = ?";
     Connection cn = Conexion.Abrir();
     Cliente cl;
     
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,id);
           
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                cl = new Cliente();
                cl.setId_clientes(rs.getInt(2));
                cl.setNombre(rs.getString(1));
                listacli.add(cl);
            }
            rs.close();
            ps.close();
            cn.close();
                    
            
        } catch (SQLException ex) {
            System.out.println("Error:"+ex);
        }
        return listacli;
    }
}
