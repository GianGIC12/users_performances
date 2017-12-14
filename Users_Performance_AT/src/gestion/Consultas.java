/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import beans.ApostadorBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Consultas {
    
    String sql;
   
    ApostadorBean[] apostadores;
    int contApostadores;

    public Consultas() {
       
        
        apostadores= new ApostadorBean[10000];
        
        contApostadores=0;
        
    }
    
    public void iniciar(){
        
       
        
        
        
    }
    
    
    
    public void completarIds() throws SQLException{
        
        Conexion objCon = new Conexion();
        
         objCon.conectar();
        
         sql = "select id,email, created_at, token_email from db_apuestatotal_prod.user_user where token_email is not null";

        PreparedStatement stm = objCon.getCon().prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
         while (rs.next()) {
             
             int id=rs.getInt("id");
             String email= rs.getString("email");
             String token_email= rs.getString("token_email");
             String fecha_registro= rs.getString("created_at").substring(0, 10);
             
             ApostadorBean apostador= new ApostadorBean();
             apostador.iniciar();
             
             
             apostador.setId_apostador(id);
             apostador.setEmail(email);
             apostador.setFecha_registro(fecha_registro);
             
             System.out.println(id);
             
             apostadores[contApostadores]=apostador;
             
             contApostadores++;

             
         }
        
        
    }
    
    
    public void completarApuestas(){
        
        for (int i = 0; i < contApostadores; i++) {
            
            int contApuestas=0;
            
         
            
            
            
            
        }
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
