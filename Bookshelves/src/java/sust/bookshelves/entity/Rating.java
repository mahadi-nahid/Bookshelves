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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sm19
 */
@Entity
@Table(name = "rating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r"),
    @NamedQuery(name = "Rating.findByRatingId", query = "SELECT r FROM Rating r WHERE r.ratingId = :ratingId"),
    @NamedQuery(name = "Rating.findByCounter", query = "SELECT r FROM Rating r WHERE r.counter = :counter"),
    @NamedQuery(name = "Rating.findByCurrentrating", query = "SELECT r FROM Rating r WHERE r.currentrating = :currentrating")})
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rating_id")
    private Integer ratingId;
    @Basic(optional = false)
    @Column(name = "counter")
    private int counter;
    @Basic(optional = false)
    @Column(name = "currentrating")
    private double currentrating;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @OneToOne(optional = false)
    private Book bookId;

    public Rating() {
    }

    public Rating(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Rating(Integer ratingId, int counter, double currentrating) {
        this.ratingId = ratingId;
        this.counter = counter;
        this.currentrating = currentrating;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getRatingId();
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getCurrentrating() {
        return currentrating;
    }

    public void setCurrentrating(double currentrating) {
        this.currentrating = currentrating;
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
        hash += (ratingId != null ? ratingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.ratingId == null && other.ratingId != null) || (this.ratingId != null && !this.ratingId.equals(other.ratingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Rating[ ratingId=" + ratingId + " ]";
    }

}
