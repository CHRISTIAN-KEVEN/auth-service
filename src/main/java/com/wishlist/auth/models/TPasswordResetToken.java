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
@Table(name = "t_password_reset_token")
@NamedQueries({
    @NamedQuery(name = "TPasswordResetToken.findAll", query = "SELECT t FROM TPasswordResetToken t"),
    @NamedQuery(name = "TPasswordResetToken.findByStrEmail", query = "SELECT t FROM TPasswordResetToken t WHERE t.strEmail = :strEmail"),
    @NamedQuery(name = "TPasswordResetToken.findByStrToken", query = "SELECT t FROM TPasswordResetToken t WHERE t.strToken = :strToken"),
    @NamedQuery(name = "TPasswordResetToken.findByDtExpiryDate", query = "SELECT t FROM TPasswordResetToken t WHERE t.dtExpiryDate = :dtExpiryDate")})
public class TPasswordResetToken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "str_email", nullable = false, length = 200)
    private String strEmail;
    @Basic(optional = false)
    @Column(name = "str_token", nullable = false, length = 60)
    private String strToken;
    @Basic(optional = false)
    @Column(name = "dt_expiry_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtExpiryDate;

    public TPasswordResetToken() {
    }

    public TPasswordResetToken(String strEmail) {
        this.strEmail = strEmail;
    }

    public TPasswordResetToken(String strEmail, String strToken, Date dtExpiryDate) {
        this.strEmail = strEmail;
        this.strToken = strToken;
        this.dtExpiryDate = dtExpiryDate;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrToken() {
        return strToken;
    }

    public void setStrToken(String strToken) {
        this.strToken = strToken;
    }

    public Date getDtExpiryDate() {
        return dtExpiryDate;
    }

    public void setDtExpiryDate(Date dtExpiryDate) {
        this.dtExpiryDate = dtExpiryDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (strEmail != null ? strEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPasswordResetToken)) {
            return false;
        }
        TPasswordResetToken other = (TPasswordResetToken) object;
        if ((this.strEmail == null && other.strEmail != null) || (this.strEmail != null && !this.strEmail.equals(other.strEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wishlist.auth.models.TPasswordResetToken[ strEmail=" + strEmail + " ]";
    }
    
}
