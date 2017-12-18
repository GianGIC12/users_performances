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
        
         sql = "select id,email, created_at, token_email from db_apuestatotal_prod.user_user where token_email is not null and  created_at>='2017-08-01'"
                 +" limit 10";

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
             
             
             
             apostadores[contApostadores]=apostador;
             
             contApostadores++;

             
         }
         
         
         objCon.desconectar();
        
        
    }
    
    
    public void completarIdWallet() throws SQLException{
        
        Conexion objCon = new Conexion();
        
        objCon.conectar();
        
        for (int i = 0; i < contApostadores; i++) {
       
            
             sql="select id,iduser from db_apuestatotal_prod.wallet where iduser="+apostadores[i].getId_apostador();
            
        PreparedStatement stm = objCon.getCon().prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
      
        
        while (rs.next()) {
            
            int id=rs.getInt("id");
            
     apostadores[i].setId_wallet(id);
            
            
            
        }
            System.out.println(apostadores[i].getId_apostador()+"   "+ apostadores[i].getId_wallet());
             
        }
       
        objCon.desconectar();
        
        
        
        
        
        
    }
    
    
    
    
    public void completarApuestas() throws SQLException{
        
        
        Conexion objCon = new Conexion();
            
            objCon.conectar();
        
        for (int i = 0; i < contApostadores; i++) {
            
            int contApuestas=0;
            
         
            
            
            sql="select created_at from db_apuestatotal_prod.user_bet where idUser="
                +apostadores[i].getId_apostador();
            
          //   sql="select created_at from db_apuestatotal_prod.user_bet where idUser="
            //        +15;
 
            PreparedStatement stm = objCon.getCon().prepareStatement(sql);

        ResultSet rs = stm.executeQuery();
        
        String[] apuesta_real=new String[10000];
        
         while (rs.next()) {
             
             String fecha_apuesta=rs.getString("created_at").substring(0,10);
             
             apuesta_real[contApuestas]=fecha_apuesta;
             
             
             contApuestas++;
         }
         
           apostadores[i].setFecha_apuesta(apuesta_real);
           apostadores[i].setContApuesta(contApuestas);
        
            System.out.println(contApuestas);
            for (int j = 0; j < contApuestas; j++) {
                
                System.out.println( apostadores[i].getFecha_apuesta()[j]);     
                
            }
        
            
            
            
            
        }
        
         objCon.desconectar();
        
        
    }
    
     public void completarRecargas() throws SQLException{
        
        
        Conexion objCon = new Conexion();
            
            objCon.conectar();
        
        for (int i = 0; i < contApostadores; i++) {
            
            int contRecargas=0;
  
            sql="select created_at,updated_at from db_apuestatotal_prod.wallet_transaction where idWallet="
                +apostadores[i].getId_wallet()+" and status='2'";
            
          //   sql="select created_at from db_apuestatotal_prod.user_bet where idUser="
            //        +15;
 
            PreparedStatement stm = objCon.getCon().prepareStatement(sql);

        ResultSet rs = stm.executeQuery();
        
        String[] recarga_real=new String[10000];
        
         while (rs.next()) {
             
             String fecha_recarga=rs.getString("updated_at").substring(0,10);
             
             recarga_real[contRecargas]=fecha_recarga;
             
             
             System.out.println("recargando...............");
             
             contRecargas++;
         }
         
           apostadores[i].setFecha_recarga(recarga_real);
           apostadores[i].setContRecarga(contRecargas);
        
            System.out.println(apostadores[i].getId_apostador()+"********************"+apostadores[i].getContRecarga());
           
        
            
            
            
            
        }
        
         objCon.desconectar();
        
        
    }
    
    
    
    public void recorreApuestas(){
        
        for (int i = 0; i < contApostadores; i++) {
            
            for (int j = 0; j < apostadores[i].getContApuesta(); j++) {
            
                
                System.out.println(apostadores[i].getId_apostador()+" Fecha apuesta" 
                + apostadores[i].getFecha_apuesta()[j]+" id_wallet"+ apostadores[i].getId_wallet());
                
                
            }
            
            
        }
    
        
        
        
        
    }
    
     public void recorreRecargas(){
        
        for (int i = 0; i < contApostadores; i++) {
            System.out.println("probando**"+apostadores[i].getContRecarga());
            for (int j = 0; j < apostadores[i].getContRecarga(); j++) {
            
                
                System.out.println(apostadores[i].getId_apostador()+" Fecha recarga" 
                + apostadores[i].getFecha_recarga()[j]+" id_wallet"+ apostadores[i].getId_wallet());
                
                
            }
            
            
        }
    
        
        
        
        
    }
}
