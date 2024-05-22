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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Kreys
 */
@Entity
@Table(name = "t_user")
@NamedQueries({
    @NamedQuery(name = "TUser.findAll", query = "SELECT t FROM TUser t"),
    @NamedQuery(name = "TUser.findByLgId", query = "SELECT t FROM TUser t WHERE t.lgId = :lgId"),
    @NamedQuery(name = "TUser.findByStrImageUrl", query = "SELECT t FROM TUser t WHERE t.strImageUrl = :strImageUrl"),
    @NamedQuery(name = "TUser.findByStrName", query = "SELECT t FROM TUser t WHERE t.strName = :strName"),
    @NamedQuery(name = "TUser.findByStrPassword", query = "SELECT t FROM TUser t WHERE t.strPassword = :strPassword"),
    @NamedQuery(name = "TUser.findByStrPhoneNumber", query = "SELECT t FROM TUser t WHERE t.strPhoneNumber = :strPhoneNumber"),
    @NamedQuery(name = "TUser.findByStrSex", query = "SELECT t FROM TUser t WHERE t.strSex = :strSex"),
    @NamedQuery(name = "TUser.findByStrUsername", query = "SELECT t FROM TUser t WHERE t.strUsername = :strUsername")})
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_id", nullable = false)
    private Long lgId;
    @Column(name = "str_image_url", length = 255)
    private String strImageUrl;
    @Column(name = "str_name", length = 255)
    private String strName;
    @Column(name = "str_password", length = 255)
    private String strPassword;
    @Column(name = "str_phone_number", length = 255)
    private String strPhoneNumber;
    @Column(name = "str_sex", length = 255)
    private String strSex;
    @Column(name = "str_username", length = 255)
    private String strUsername;
    @JoinTable(name = "t_user_roles", joinColumns = {
        @JoinColumn(name = "t_user_lg_id", referencedColumnName = "lg_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "roles_lg_id", referencedColumnName = "lg_id", nullable = false)})
    @ManyToMany
    private List<TRole> tRoleList;

    public TUser() {
    }

    public TUser(Long lgId) {
        this.lgId = lgId;
    }

    public Long getLgId() {
        return lgId;
    }

    public void setLgId(Long lgId) {
        this.lgId = lgId;
    }

    public String getStrImageUrl() {
        return strImageUrl;
    }

    public void setStrImageUrl(String strImageUrl) {
        this.strImageUrl = strImageUrl;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public String getStrPhoneNumber() {
        return strPhoneNumber;
    }

    public void setStrPhoneNumber(String strPhoneNumber) {
        this.strPhoneNumber = strPhoneNumber;
    }

    public String getStrSex() {
        return strSex;
    }

    public void setStrSex(String strSex) {
        this.strSex = strSex;
    }

    public String getStrUsername() {
        return strUsername;
    }

    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }

    public List<TRole> getTRoleList() {
        return tRoleList;
    }

    public void setTRoleList(List<TRole> tRoleList) {
        this.tRoleList = tRoleList;
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
        if (!(object instanceof TUser)) {
            return false;
        }
        TUser other = (TUser) object;
        if ((this.lgId == null && other.lgId != null) || (this.lgId != null && !this.lgId.equals(other.lgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wishlist.auth.models.TUser[ lgId=" + lgId + " ]";
    }
    
}
