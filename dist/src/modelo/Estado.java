/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DelKo
 */
@Entity
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findById", query = "SELECT e FROM Estado e WHERE e.id = :id"),
    @NamedQuery(name = "Estado.findByUbicacionpaisid", query = "SELECT e FROM Estado e WHERE e.ubicacionpaisid = :ubicacionpaisid"),
    @NamedQuery(name = "Estado.findByEstadonombre", query = "SELECT e FROM Estado e WHERE e.estadonombre = :estadonombre")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ubicacionpaisid")
    private Integer ubicacionpaisid;
    @Basic(optional = false)
    @Column(name = "estadonombre")
    private String estadonombre;

    public Estado() {
    }

    public Estado(Integer id) {
        this.id = id;
    }

    public Estado(Integer id, String estadonombre) {
        this.id = id;
        this.estadonombre = estadonombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUbicacionpaisid() {
        return ubicacionpaisid;
    }

    public void setUbicacionpaisid(Integer ubicacionpaisid) {
        this.ubicacionpaisid = ubicacionpaisid;
    }

    public String getEstadonombre() {
        return estadonombre;
    }

    public void setEstadonombre(String estadonombre) {
        this.estadonombre = estadonombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Estado[ id=" + id + " ]";
    }
    
}
