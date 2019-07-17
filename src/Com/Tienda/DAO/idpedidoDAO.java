/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.Tienda.DAO;

import Com.Tienda.Bean.Idpedido;
import Com.Tienda.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class idpedidoDAO {
    public static ArrayList<Idpedido> listaridpedido(){
        ArrayList<Idpedido> listidpe = new ArrayList<>();
        String sql = "SELECT idpedido from pedido_encabezado ORDER BY idpedido DESC LIMIT 1";
        Connection cn = Conexion.Abrir();
        Idpedido idp;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                idp = new Idpedido();
                idp.setIdpedido(rs.getInt(1));
                listidpe.add(idp);
            }
            cn.close();
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error aqui en idpedidoDAO: "+ ex);
        }
        return listidpe;
                
    }
}
