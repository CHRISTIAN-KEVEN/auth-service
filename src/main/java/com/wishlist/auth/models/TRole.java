/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wishlist.auth.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Kreys
 */
@Entity
@Table(name = "t_role")
@NamedQueries({
    @NamedQuery(name = "TRole.findAll", query = "SELECT t FROM TRole t"),
    @NamedQuery(name = "TRole.findByLgId", query = "SELECT t FROM TRole t WHERE t.lgId = :lgId"),
    @NamedQuery(name = "TRole.findByStrName", query = "SELECT t FROM TRole t WHERE t.strName = :strName")})
public class TRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_id", nullable = false)
    private Long lgId;
    @Column(name = "str_name", length = 255)
    private String strName;
    @ManyToMany(mappedBy = "tRoleList")
    private List<TUser> tUserList;

    public TRole() {
    }

    public TRole(Long lgId) {
        this.lgId = lgId;
    }

    public Long getLgId() {
        return lgId;
    }

    public void setLgId(Long lgId) {
        this.lgId = lgId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public List<TUser> getTUserList() {
        return tUserList;
    }

    public void setTUserList(List<TUser> tUserList) {
        this.tUserList = tUserList;
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
        if (!(object instanceof TRole)) {
            return false;
        }
        TRole other = (TRole) object;
        if ((this.lgId == null && other.lgId != null) || (this.lgId != null && !this.lgId.equals(other.lgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wishlist.auth.models.TRole[ lgId=" + lgId + " ]";
    }
    
}
