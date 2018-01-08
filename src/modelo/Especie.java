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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DelKo
 */
@Entity
@Table(name = "especie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especie.findAll", query = "SELECT e FROM Especie e"),
    @NamedQuery(name = "Especie.findByEspId", query = "SELECT e FROM Especie e WHERE e.espId = :espId"),
    @NamedQuery(name = "Especie.findByEspNombre", query = "SELECT e FROM Especie e WHERE e.espNombre = :espNombre"),
    @NamedQuery(name = "Especie.findByEspNomVul", query = "SELECT e FROM Especie e WHERE e.espNomVul = :espNomVul"),
    @NamedQuery(name = "Especie.findByEspRecolector", query = "SELECT e FROM Especie e WHERE e.espRecolector = :espRecolector"),
    @NamedQuery(name = "Especie.findByEspAcompanante", query = "SELECT e FROM Especie e WHERE e.espAcompanante = :espAcompanante"),
    @NamedQuery(name = "Especie.findByEspFechaRecol", query = "SELECT e FROM Especie e WHERE e.espFechaRecol = :espFechaRecol"),
    @NamedQuery(name = "Especie.findByEspNumColecc", query = "SELECT e FROM Especie e WHERE e.espNumColecc = :espNumColecc"),
    @NamedQuery(name = "Especie.findByEspPais", query = "SELECT e FROM Especie e WHERE e.espPais = :espPais"),
    @NamedQuery(name = "Especie.findByEspProv", query = "SELECT e FROM Especie e WHERE e.espProv = :espProv"),
    @NamedQuery(name = "Especie.findByEspDpto", query = "SELECT e FROM Especie e WHERE e.espDpto = :espDpto"),
    @NamedQuery(name = "Especie.findByEspLocalidad", query = "SELECT e FROM Especie e WHERE e.espLocalidad = :espLocalidad"),
    @NamedQuery(name = "Especie.findByEspObservaciones", query = "SELECT e FROM Especie e WHERE e.espObservaciones = :espObservaciones"),
    @NamedQuery(name = "Especie.findByEspFecIngreso", query = "SELECT e FROM Especie e WHERE e.espFecIngreso = :espFecIngreso"),
    @NamedQuery(name = "Especie.findByEspDeterPor", query = "SELECT e FROM Especie e WHERE e.espDeterPor = :espDeterPor"),
    @NamedQuery(name = "Especie.findByEspDuplicado", query = "SELECT e FROM Especie e WHERE e.espDuplicado = :espDuplicado"),
    @NamedQuery(name = "Especie.findByEspDetalleDup", query = "SELECT e FROM Especie e WHERE e.espDetalleDup = :espDetalleDup"),
    @NamedQuery(name = "Especie.findByEspEstado", query = "SELECT e FROM Especie e WHERE e.espEstado = :espEstado")})
public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "esp_id")
    private Integer espId;
    @Basic(optional = false)
    @Column(name = "esp_nombre")
    private String espNombre;
    @Basic(optional = false)
    @Column(name = "esp_nom_vul")
    private String espNomVul;
    @Basic(optional = false)
    @Column(name = "esp_recolector")
    private String espRecolector;
    @Basic(optional = false)
    @Column(name = "esp_acompanante")
    private String espAcompanante;
    @Column(name = "esp_fecha_recol")
    private String espFechaRecol;
    @Column(name = "esp_num_colecc")
    private String espNumColecc;
    @Column(name = "esp_pais")
    private String espPais;
    @Column(name = "esp_prov")
    private String espProv;
    @Column(name = "esp_dpto")
    private String espDpto;
    @Column(name = "esp_localidad")
    private String espLocalidad;
    @Column(name = "esp_observaciones")
    private String espObservaciones;
    @Column(name = "esp_fec_ingreso")
    private String espFecIngreso;
    @Column(name = "esp_deter_por")
    private String espDeterPor;
    @Lob
    @Column(name = "esp_imagen")
    private byte[] espImagen;
    @Column(name = "esp_duplicado")
    private Integer espDuplicado;
    @Column(name = "esp_detalle_dup")
    private String espDetalleDup;
    @Column(name = "esp_estado")
    private Integer espEstado;
    @JoinColumn(name = "esp_id_gen", referencedColumnName = "gen_id")
    @ManyToOne
    private Genero espIdGen;
    @JoinColumn(name = "esp_id_fam", referencedColumnName = "fam_id")
    @ManyToOne
    private Familia espIdFam;

    public Especie() {
    }

    public Especie(Integer espId) {
        this.espId = espId;
    }

    public Especie(Integer espId, String espNombre, String espNomVul, String espRecolector, String espAcompanante) {
        this.espId = espId;
        this.espNombre = espNombre;
        this.espNomVul = espNomVul;
        this.espRecolector = espRecolector;
        this.espAcompanante = espAcompanante;
    }

    public Integer getEspId() {
        return espId;
    }

    public void setEspId(Integer espId) {
        this.espId = espId;
    }

    public String getEspNombre() {
        return espNombre;
    }

    public void setEspNombre(String espNombre) {
        this.espNombre = espNombre;
    }

    public String getEspNomVul() {
        return espNomVul;
    }

    public void setEspNomVul(String espNomVul) {
        this.espNomVul = espNomVul;
    }

    public String getEspRecolector() {
        return espRecolector;
    }

    public void setEspRecolector(String espRecolector) {
        this.espRecolector = espRecolector;
    }

    public String getEspAcompanante() {
        return espAcompanante;
    }

    public void setEspAcompanante(String espAcompanante) {
        this.espAcompanante = espAcompanante;
    }

    public String getEspFechaRecol() {
        return espFechaRecol;
    }

    public void setEspFechaRecol(String espFechaRecol) {
        this.espFechaRecol = espFechaRecol;
    }

    public String getEspNumColecc() {
        return espNumColecc;
    }

    public void setEspNumColecc(String espNumColecc) {
        this.espNumColecc = espNumColecc;
    }

    public String getEspPais() {
        return espPais;
    }

    public void setEspPais(String espPais) {
        this.espPais = espPais;
    }

    public String getEspProv() {
        return espProv;
    }

    public void setEspProv(String espProv) {
        this.espProv = espProv;
    }

    public String getEspDpto() {
        return espDpto;
    }

    public void setEspDpto(String espDpto) {
        this.espDpto = espDpto;
    }

    public String getEspLocalidad() {
        return espLocalidad;
    }

    public void setEspLocalidad(String espLocalidad) {
        this.espLocalidad = espLocalidad;
    }

    public String getEspObservaciones() {
        return espObservaciones;
    }

    public void setEspObservaciones(String espObservaciones) {
        this.espObservaciones = espObservaciones;
    }

    public String getEspFecIngreso() {
        return espFecIngreso;
    }

    public void setEspFecIngreso(String espFecIngreso) {
        this.espFecIngreso = espFecIngreso;
    }

    public String getEspDeterPor() {
        return espDeterPor;
    }

    public void setEspDeterPor(String espDeterPor) {
        this.espDeterPor = espDeterPor;
    }

    public byte[] getEspImagen() {
        return espImagen;
    }

    public void setEspImagen(byte[] espImagen) {
        this.espImagen = espImagen;
    }

    public Integer getEspDuplicado() {
        return espDuplicado;
    }

    public void setEspDuplicado(Integer espDuplicado) {
        this.espDuplicado = espDuplicado;
    }

    public String getEspDetalleDup() {
        return espDetalleDup;
    }

    public void setEspDetalleDup(String espDetalleDup) {
        this.espDetalleDup = espDetalleDup;
    }

    public Integer getEspEstado() {
        return espEstado;
    }

    public void setEspEstado(Integer espEstado) {
        this.espEstado = espEstado;
    }

    public Genero getEspIdGen() {
        return espIdGen;
    }

    public void setEspIdGen(Genero espIdGen) {
        this.espIdGen = espIdGen;
    }

    public Familia getEspIdFam() {
        return espIdFam;
    }

    public void setEspIdFam(Familia espIdFam) {
        this.espIdFam = espIdFam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (espId != null ? espId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especie)) {
            return false;
        }
        Especie other = (Especie) object;
        if ((this.espId == null && other.espId != null) || (this.espId != null && !this.espId.equals(other.espId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Especie[ espId=" + espId + " ]";
    }
    
}
