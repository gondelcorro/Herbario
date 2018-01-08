/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DelKo
 */
@Entity
@Table(name = "familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f"),
    @NamedQuery(name = "Familia.findByFamId", query = "SELECT f FROM Familia f WHERE f.famId = :famId"),
    @NamedQuery(name = "Familia.findByFamNombre", query = "SELECT f FROM Familia f WHERE f.famNombre = :famNombre"),
    @NamedQuery(name = "Familia.findByArtEstado", query = "SELECT f FROM Familia f WHERE f.artEstado = :artEstado")})
public class Familia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fam_id")
    private Integer famId;
    @Basic(optional = false)
    @Column(name = "fam_nombre")
    private String famNombre;
    @Column(name = "art_estado")
    private Integer artEstado;
    @OneToMany( mappedBy = "idFam", orphanRemoval = true)
    private List<Genero> generoList;
    @OneToMany(mappedBy = "espIdFam", orphanRemoval = true)
    private List<Especie> especieList;

    public Familia() {
    }

    public Familia(Integer famId) {
        this.famId = famId;
    }

    public Familia(Integer famId, String famNombre) {
        this.famId = famId;
        this.famNombre = famNombre;
    }

    public Integer getFamId() {
        return famId;
    }

    public void setFamId(Integer famId) {
        this.famId = famId;
    }

    public String getFamNombre() {
        return famNombre;
    }

    public void setFamNombre(String famNombre) {
        this.famNombre = famNombre;
    }

    public Integer getArtEstado() {
        return artEstado;
    }

    public void setArtEstado(Integer artEstado) {
        this.artEstado = artEstado;
    }

    @XmlTransient
    public List<Genero> getGeneroList() {
        return generoList;
    }

    public void setGeneroList(List<Genero> generoList) {
        this.generoList = generoList;
    }

    @XmlTransient
    public List<Especie> getEspecieList() {
        return especieList;
    }

    public void setEspecieList(List<Especie> especieList) {
        this.especieList = especieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (famId != null ? famId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.famId == null && other.famId != null) || (this.famId != null && !this.famId.equals(other.famId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Familia[ famId=" + famId + " ]";
    }
    
}
