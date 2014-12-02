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
@Table(name = "statuslike")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statuslike.findAll", query = "SELECT s FROM Statuslike s"),
    @NamedQuery(name = "Statuslike.findByStatuslikeId", query = "SELECT s FROM Statuslike s WHERE s.statuslikeId = :statuslikeId")})
public class Statuslike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "statuslike_id")
    private Integer statuslikeId;
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    @ManyToOne(optional = false)
    private Status statusId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Statuslike() {
    }

    public Statuslike(Integer statuslikeId) {
        this.statuslikeId = statuslikeId;
    }

    public Integer getStatuslikeId() {
        return statuslikeId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getStatuslikeId();
    }

    public void setStatuslikeId(Integer statuslikeId) {
        this.statuslikeId = statuslikeId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statuslikeId != null ? statuslikeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statuslike)) {
            return false;
        }
        Statuslike other = (Statuslike) object;
        if ((this.statuslikeId == null && other.statuslikeId != null) || (this.statuslikeId != null && !this.statuslikeId.equals(other.statuslikeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Statuslike[ statuslikeId=" + statuslikeId + " ]";
    }

}
