/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import gestion.Consultas;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        Consultas c= new Consultas();
        c.iniciar();
        
        c.completarIds();
        
        
    }
    
}
