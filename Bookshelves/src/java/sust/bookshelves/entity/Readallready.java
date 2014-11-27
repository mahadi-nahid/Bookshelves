/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.bookshelves.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sm19
 */
@Entity
@Table(name = "readallready")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Readallready.findAll", query = "SELECT r FROM Readallready r"),
    @NamedQuery(name = "Readallready.findByReadId", query = "SELECT r FROM Readallready r WHERE r.readId = :readId")})
public class Readallready implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "read_id")
    private Integer readId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne(optional = false)
    private Book bookId;

    public Readallready() {
    }

    public Readallready(Integer readId) {
        this.readId = readId;
    }

    public Integer getReadId() {
        return readId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getReadId();
    }

    public void setReadId(Integer readId) {
        this.readId = readId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (readId != null ? readId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Readallready)) {
            return false;
        }
        Readallready other = (Readallready) object;
        if ((this.readId == null && other.readId != null) || (this.readId != null && !this.readId.equals(other.readId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Readallready[ readId=" + readId + " ]";
    }

}
