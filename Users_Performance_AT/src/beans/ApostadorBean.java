/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author user
 */
public class ApostadorBean {
    
    int id_apostador;
    String email,fecha_registro,fecha_recarga,fecha_apuesta,fecha_retiro;

    public ApostadorBean() {
    }

    public ApostadorBean(int id_apostador, String email, String fecha_registro, String fecha_recarga, String fecha_apuesta, String fecha_retiro) {
        this.id_apostador = id_apostador;
        this.email = email;
        this.fecha_registro = fecha_registro;
        this.fecha_recarga = fecha_recarga;
        this.fecha_apuesta = fecha_apuesta;
        this.fecha_retiro = fecha_retiro;
    }

    public int getId_apostador() {
        return id_apostador;
    }

    public void setId_apostador(int id_apostador) {
        this.id_apostador = id_apostador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_recarga() {
        return fecha_recarga;
    }

    public void setFecha_recarga(String fecha_recarga) {
        this.fecha_recarga = fecha_recarga;
    }

    public String getFecha_apuesta() {
        return fecha_apuesta;
    }

    public void setFecha_apuesta(String fecha_apuesta) {
        this.fecha_apuesta = fecha_apuesta;
    }

    public String getFecha_retiro() {
        return fecha_retiro;
    }

    public void setFecha_retiro(String fecha_retiro) {
        this.fecha_retiro = fecha_retiro;
    }
    
    
    
    
}
