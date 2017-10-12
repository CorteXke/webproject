/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

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
 * @author Dániel
 */
@Entity
@Table(name = "etterem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etterem.findAll", query = "SELECT e FROM Etterem e")
    , @NamedQuery(name = "Etterem.findById", query = "SELECT e FROM Etterem e WHERE e.id = :id")
    , @NamedQuery(name = "Etterem.findByNev", query = "SELECT e FROM Etterem e WHERE e.nev = :nev")
    , @NamedQuery(name = "Etterem.findByKiszolgalas", query = "SELECT e FROM Etterem e WHERE e.kiszolgalas = :kiszolgalas")
    , @NamedQuery(name = "Etterem.findByHigienia", query = "SELECT e FROM Etterem e WHERE e.higienia = :higienia")
    , @NamedQuery(name = "Etterem.findByMinoseg", query = "SELECT e FROM Etterem e WHERE e.minoseg = :minoseg")
    , @NamedQuery(name = "Etterem.findByAr", query = "SELECT e FROM Etterem e WHERE e.ar = :ar")
    , @NamedQuery(name = "Etterem.findByNyitvatartas", query = "SELECT e FROM Etterem e WHERE e.nyitvatartas = :nyitvatartas")
    , @NamedQuery(name = "Etterem.findByKep", query = "SELECT e FROM Etterem e WHERE e.kep = :kep")})
public class Etterem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nev")
    private String nev;
    @Basic(optional = false)
    @Column(name = "kiszolgalas")
    private int kiszolgalas;
    @Basic(optional = false)
    @Column(name = "higienia")
    private int higienia;
    @Basic(optional = false)
    @Column(name = "minoseg")
    private int minoseg;
    @Basic(optional = false)
    @Column(name = "ar")
    private int ar;
    @Basic(optional = false)
    @Column(name = "nyitvatartas")
    private String nyitvatartas;
    @Basic(optional = false)
    @Column(name = "kep")
    private String kep;

    public Etterem() {
    }

    public Etterem(Integer id) {
        this.id = id;
    }

    public Etterem(Integer id, String nev, int kiszolgalas, int higienia, int minoseg, int ar, String nyitvatartas, String kep) {
        this.id = id;
        this.nev = nev;
        this.kiszolgalas = kiszolgalas;
        this.higienia = higienia;
        this.minoseg = minoseg;
        this.ar = ar;
        this.nyitvatartas = nyitvatartas;
        this.kep = kep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getKiszolgalas() {
        return kiszolgalas;
    }

    public void setKiszolgalas(int kiszolgalas) {
        this.kiszolgalas = kiszolgalas;
    }

    public int getHigienia() {
        return higienia;
    }

    public void setHigienia(int higienia) {
        this.higienia = higienia;
    }

    public int getMinoseg() {
        return minoseg;
    }

    public void setMinoseg(int minoseg) {
        this.minoseg = minoseg;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public String getNyitvatartas() {
        return nyitvatartas;
    }

    public void setNyitvatartas(String nyitvatartas) {
        this.nyitvatartas = nyitvatartas;
    }

    public String getKep() {
        return kep;
    }

    public void setKep(String kep) {
        this.kep = kep;
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
        if (!(object instanceof Etterem)) {
            return false;
        }
        Etterem other = (Etterem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Etterem[ id=" + id + " ]";
    }
    
}
