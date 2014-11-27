/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.bookshelves.entity;

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
 * @author Sm19
 */
@Entity
@Table(name = "catagory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catagory.findAll", query = "SELECT c FROM Catagory c"),
    @NamedQuery(name = "Catagory.findByCatagoryId", query = "SELECT c FROM Catagory c WHERE c.catagoryId = :catagoryId"),
    @NamedQuery(name = "Catagory.findByCatagoryname", query = "SELECT c FROM Catagory c WHERE c.catagoryname = :catagoryname")})
public class Catagory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "catagory_id")
    private Integer catagoryId;
    @Basic(optional = false)
    @Column(name = "catagoryname")
    private String catagoryname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catagoryId")
    private List<Book> bookList;

    public Catagory() {
    }

    public Catagory(Integer catagoryId) {
        this.catagoryId = catagoryId;
    }

    public Catagory(Integer catagoryId, String catagoryname) {
        this.catagoryId = catagoryId;
        this.catagoryname = catagoryname;
    }

    public Integer getCatagoryId() {
        return catagoryId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getCatagoryId();
    }

    public void setCatagoryId(Integer catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getCatagoryname() {
        return catagoryname;
    }

    public void setCatagoryname(String catagoryname) {
        this.catagoryname = catagoryname;
    }

    @XmlTransient
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catagoryId != null ? catagoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catagory)) {
            return false;
        }
        Catagory other = (Catagory) object;
        if ((this.catagoryId == null && other.catagoryId != null) || (this.catagoryId != null && !this.catagoryId.equals(other.catagoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Catagory[ catagoryId=" + catagoryId + " ]";
    }

}
