/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.imeiBloqueo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jimenezelkg
 */
@Entity
@Table(name = "GAR_CAV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GarCav.findAll", query = "SELECT g FROM GarCav g")
    , @NamedQuery(name = "GarCav.findById", query = "SELECT g FROM GarCav g WHERE g.id = :id")
    , @NamedQuery(name = "GarCav.findByCodeCav", query = "SELECT g FROM GarCav g WHERE g.codeCav = :codeCav")
    , @NamedQuery(name = "GarCav.findByNameCav", query = "SELECT g FROM GarCav g WHERE g.nameCav = :nameCav")
    , @NamedQuery(name = "GarCav.findByAddress", query = "SELECT g FROM GarCav g WHERE g.address = :address")
    , @NamedQuery(name = "GarCav.findByCst", query = "SELECT g FROM GarCav g WHERE g.cst = :cst")
    , @NamedQuery(name = "GarCav.findByModel", query = "SELECT g FROM GarCav g WHERE g.model = :model")})
public class GarCav implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODE_CAV")
    private short codeCav;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NAME_CAV")
    private String nameCav;
    @Size(max = 250)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CST")
    private String cst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MODEL")
    private String model;

    public GarCav() {
    }

    public GarCav(BigDecimal id) {
        this.id = id;
    }

    public GarCav(BigDecimal id, short codeCav, String nameCav, String cst, String model) {
        this.id = id;
        this.codeCav = codeCav;
        this.nameCav = nameCav;
        this.cst = cst;
        this.model = model;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public short getCodeCav() {
        return codeCav;
    }

    public void setCodeCav(short codeCav) {
        this.codeCav = codeCav;
    }

    public String getNameCav() {
        return nameCav;
    }

    public void setNameCav(String nameCav) {
        this.nameCav = nameCav;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
        if (!(object instanceof GarCav)) {
            return false;
        }
        GarCav other = (GarCav) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.claro.imeiBloqueo.entity.GarCav[ id=" + id + " ]";
    }
    
}
