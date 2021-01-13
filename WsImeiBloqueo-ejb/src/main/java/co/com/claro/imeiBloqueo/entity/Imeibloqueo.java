/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.imeiBloqueo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jimenezelkg
 */
@Entity
@Table(name = "IMEIBLOQUEO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imeibloqueo.findAll", query = "SELECT i FROM Imeibloqueo i")
    , @NamedQuery(name = "Imeibloqueo.findById", query = "SELECT i FROM Imeibloqueo i WHERE i.id = :id")
    , @NamedQuery(name = "Imeibloqueo.findByMsisdn", query = "SELECT i FROM Imeibloqueo i WHERE i.msisdn = :msisdn")
    , @NamedQuery(name = "Imeibloqueo.findByImei", query = "SELECT i FROM Imeibloqueo i WHERE i.imei = :imei")
    , @NamedQuery(name = "Imeibloqueo.findByReportType", query = "SELECT i FROM Imeibloqueo i WHERE i.reportType = :reportType")
    , @NamedQuery(name = "Imeibloqueo.findByReportDate", query = "SELECT i FROM Imeibloqueo i WHERE i.reportDate = :reportDate")
    , @NamedQuery(name = "Imeibloqueo.findByOperation", query = "SELECT i FROM Imeibloqueo i WHERE i.operation = :operation")
    , @NamedQuery(name = "Imeibloqueo.findByStatus", query = "SELECT i FROM Imeibloqueo i WHERE i.status = :status")})
public class Imeibloqueo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name = "IMEIBLOQUEO_SEQ",
            sequenceName = "IMEIBLOQUEO_SEQ",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "IMEIBLOQUEO_SEQ")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MSISDN")
    private long msisdn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IMEI")
    private long imei;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "REPORT_TYPE")
    private String reportType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPORT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "OPERATION")
    private String operation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STATUS")
    private String status;

    public Imeibloqueo() {
    }

    public Imeibloqueo(Long id) {
        this.id = id;
    }

    public Imeibloqueo(Long id, long msisdn, long imei, String reportType, Date reportDate, String operation, String status) {
        this.id = id;
        this.msisdn = msisdn;
        this.imei = imei;
        this.reportType = reportType;
        this.reportDate = reportDate;
        this.operation = operation;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(long msisdn) {
        this.msisdn = msisdn;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof Imeibloqueo)) {
            return false;
        }
        Imeibloqueo other = (Imeibloqueo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.claro.imeiBloqueo.entity.Imeibloqueo[ id=" + id + " ]";
    }

}
