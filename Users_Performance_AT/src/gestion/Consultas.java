/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

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
    int[] id_Apostador;
    String[] email,fecha_registro,fecha_recarga,fecha_apuesta,fecha_retiro;
    int contApostadores;

    public Consultas() {
        id_Apostador= new int[100000];
        email= new String[100000];
        fecha_registro= new String[100000];
        
        contApostadores=0;
        
    }
    
    public void iniciar(){
        
        
        for (int i = 0; i < 100000; i++) {
            
            id_Apostador[i]=0;
            email[i]="vacio";
            fecha_registro[i]="vacio";
            
            
        }
        
        
        
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
             
             
             
             id_Apostador[contApostadores]=id;
             
             this.email[contApostadores]=email;
             this.fecha_registro[contApostadores]=fecha_registro;        
             
             contApostadores++;

             
         }
        
        
    }
    
    
    public void completarApuestas(){
        
        for (int i = 0; i < contApostadores; i++) {
            
            
            System.out.println(id_Apostador[i]+"****"+email[i]+"****"+fecha_registro[i]);
            
            
        }
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
