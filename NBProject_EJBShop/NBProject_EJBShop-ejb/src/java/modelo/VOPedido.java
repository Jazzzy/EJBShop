/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gladi
 */
@Entity
@Table(name = "pedidos")
public class VOPedido implements Serializable {

    //To be mapped into database
    @Column(name = "precioTotal")
    private float precioTotal;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name ="nombreUsuario")
    private String nombreUsuario;

    @Column (name= "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public VOPedido(float precioTotal, String nombreUsuario) {
        this.precioTotal = precioTotal;
        //this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.fecha = new Date();
    }

    public VOPedido() {
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
