/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
    @NamedQuery(name = "Genero.findByGenId", query = "SELECT g FROM Genero g WHERE g.genId = :genId"),
    @NamedQuery(name = "Genero.findByGenNombre", query = "SELECT g FROM Genero g WHERE g.genNombre = :genNombre"),
    @NamedQuery(name = "Genero.findByGenEstado", query = "SELECT g FROM Genero g WHERE g.genEstado = :genEstado")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gen_id")
    private Integer genId;
    @Basic(optional = false)
    @Column(name = "gen_nombre")
    private String genNombre;
    @Column(name = "gen_estado")
    private Integer genEstado;
    @JoinColumn(name = "id_fam", referencedColumnName = "fam_id")
    @ManyToOne(optional = false)
    private Familia idFam;
    @OneToMany(mappedBy = "espIdGen", orphanRemoval = true) // la 2da propiedad es para una eliminacion en cascada
    private List<Especie> especieList;

    public Genero() {
    }

    public Genero(Integer genId) {
        this.genId = genId;
    }

    public Genero(Integer genId, String genNombre) {
        this.genId = genId;
        this.genNombre = genNombre;
    }

    public Integer getGenId() {
        return genId;
    }

    public void setGenId(Integer genId) {
        this.genId = genId;
    }

    public String getGenNombre() {
        return genNombre;
    }

    public void setGenNombre(String genNombre) {
        this.genNombre = genNombre;
    }

    public Integer getGenEstado() {
        return genEstado;
    }

    public void setGenEstado(Integer genEstado) {
        this.genEstado = genEstado;
    }

    public Familia getIdFam() {
        return idFam;
    }

    public void setIdFam(Familia idFam) {
        this.idFam = idFam;
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
        hash += (genId != null ? genId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.genId == null && other.genId != null) || (this.genId != null && !this.genId.equals(other.genId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Genero[ genId=" + genId + " ]";
    }
    
}
