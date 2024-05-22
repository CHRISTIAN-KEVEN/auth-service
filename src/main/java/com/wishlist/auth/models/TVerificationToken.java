/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wishlist.auth.models;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Kreys
 */
@Entity
@Table(name = "t_verification_token")
@NamedQueries({
    @NamedQuery(name = "TVerificationToken.findAll", query = "SELECT t FROM TVerificationToken t"),
    @NamedQuery(name = "TVerificationToken.findByLgId", query = "SELECT t FROM TVerificationToken t WHERE t.lgId = :lgId"),
    @NamedQuery(name = "TVerificationToken.findByStrToken", query = "SELECT t FROM TVerificationToken t WHERE t.strToken = :strToken"),
    @NamedQuery(name = "TVerificationToken.findByLgUserId", query = "SELECT t FROM TVerificationToken t WHERE t.lgUserId = :lgUserId"),
    @NamedQuery(name = "TVerificationToken.findByDtExpirationDate", query = "SELECT t FROM TVerificationToken t WHERE t.dtExpirationDate = :dtExpirationDate"),
    @NamedQuery(name = "TVerificationToken.findByDtDateCreated", query = "SELECT t FROM TVerificationToken t WHERE t.dtDateCreated = :dtDateCreated"),
    @NamedQuery(name = "TVerificationToken.findByDtDateUpdated", query = "SELECT t FROM TVerificationToken t WHERE t.dtDateUpdated = :dtDateUpdated")})
public class TVerificationToken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lg_id", nullable = false)
    private Long lgId;
    @Basic(optional = false)
    @Column(name = "str_token", nullable = false, length = 255)
    private String strToken;
    @Basic(optional = false)
    @Column(name = "lg_user_id", nullable = false)
    private long lgUserId;
    @Basic(optional = false)
    @Column(name = "dt_expiration_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtExpirationDate;
    @Basic(optional = false)
    @Column(name = "dt_date_created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDateCreated;
    @Column(name = "dt_date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDateUpdated;

    public TVerificationToken() {
    }

    public TVerificationToken(Long lgId) {
        this.lgId = lgId;
    }

    public TVerificationToken(Long lgId, String strToken, long lgUserId, Date dtExpirationDate, Date dtDateCreated) {
        this.lgId = lgId;
        this.strToken = strToken;
        this.lgUserId = lgUserId;
        this.dtExpirationDate = dtExpirationDate;
        this.dtDateCreated = dtDateCreated;
    }

    public Long getLgId() {
        return lgId;
    }

    public void setLgId(Long lgId) {
        this.lgId = lgId;
    }

    public String getStrToken() {
        return strToken;
    }

    public void setStrToken(String strToken) {
        this.strToken = strToken;
    }

    public long getLgUserId() {
        return lgUserId;
    }

    public void setLgUserId(long lgUserId) {
        this.lgUserId = lgUserId;
    }

    public Date getDtExpirationDate() {
        return dtExpirationDate;
    }

    public void setDtExpirationDate(Date dtExpirationDate) {
        this.dtExpirationDate = dtExpirationDate;
    }

    public Date getDtDateCreated() {
        return dtDateCreated;
    }

    public void setDtDateCreated(Date dtDateCreated) {
        this.dtDateCreated = dtDateCreated;
    }

    public Date getDtDateUpdated() {
        return dtDateUpdated;
    }

    public void setDtDateUpdated(Date dtDateUpdated) {
        this.dtDateUpdated = dtDateUpdated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgId != null ? lgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TVerificationToken)) {
            return false;
        }
        TVerificationToken other = (TVerificationToken) object;
        if ((this.lgId == null && other.lgId != null) || (this.lgId != null && !this.lgId.equals(other.lgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wishlist.auth.models.TVerificationToken[ lgId=" + lgId + " ]";
    }
    
}
