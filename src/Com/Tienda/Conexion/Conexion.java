/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.Tienda.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexion {
   
    private static String url="jdbc:mysql://localhost/tienda";
    private static String usuario= "root";
    private static String pass="12345678";
    private static Connection cn;
    
    public static Connection Abrir(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection)DriverManager.getConnection(url,usuario,pass);
            
        } catch (Exception ex) {
            System.out.println("Error: "+ ex);
        }
         return cn;
    }
   
}
