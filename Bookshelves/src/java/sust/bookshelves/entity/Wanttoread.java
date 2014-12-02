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
@Table(name = "wanttoread")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wanttoread.findAll", query = "SELECT w FROM Wanttoread w"),
    @NamedQuery(name = "Wanttoread.findByWanttoreadId", query = "SELECT w FROM Wanttoread w WHERE w.wanttoreadId = :wanttoreadId")})
public class Wanttoread implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wanttoread_id")
    private Integer wanttoreadId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne(optional = false)
    private Book bookId;

    public Wanttoread() {
    }

    public Wanttoread(Integer wanttoreadId) {
        this.wanttoreadId = wanttoreadId;
    }

    public Integer getWanttoreadId() {
        return wanttoreadId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getWanttoreadId();
    }

    public void setWanttoreadId(Integer wanttoreadId) {
        this.wanttoreadId = wanttoreadId;
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
        hash += (wanttoreadId != null ? wanttoreadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wanttoread)) {
            return false;
        }
        Wanttoread other = (Wanttoread) object;
        if ((this.wanttoreadId == null && other.wanttoreadId != null) || (this.wanttoreadId != null && !this.wanttoreadId.equals(other.wanttoreadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Wanttoread[ wanttoreadId=" + wanttoreadId + " ]";
    }

}
