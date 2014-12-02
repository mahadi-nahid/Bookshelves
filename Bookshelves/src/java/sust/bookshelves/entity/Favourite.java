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
 * @author Sm19 & MahadiHasanNahid
 */
@Entity
@Table(name = "favourite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favourite.findAll", query = "SELECT f FROM Favourite f"),
    @NamedQuery(name = "Favourite.findByFavouriteId", query = "SELECT f FROM Favourite f WHERE f.favouriteId = :favouriteId")})
public class Favourite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "favourite_id")
    private Integer favouriteId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne(optional = false)
    private Book bookId;

    public Favourite() {
    }

    public Favourite(Integer favouriteId) {
        this.favouriteId = favouriteId;
    }

    public Integer getFavouriteId() {
        return favouriteId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getFavouriteId();
    }

    public void setFavouriteId(Integer favouriteId) {
        this.favouriteId = favouriteId;
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
        hash += (favouriteId != null ? favouriteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favourite)) {
            return false;
        }
        Favourite other = (Favourite) object;
        if ((this.favouriteId == null && other.favouriteId != null) || (this.favouriteId != null && !this.favouriteId.equals(other.favouriteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Favourite[ favouriteId=" + favouriteId + " ]";
    }

}
