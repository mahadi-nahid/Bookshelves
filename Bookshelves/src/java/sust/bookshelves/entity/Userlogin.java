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
 * @author Sm19 & MahadiHasanNahid
 */
@Entity
@Table(name = "userlogin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userlogin.findAll", query = "SELECT u FROM Userlogin u"),
    @NamedQuery(name = "Userlogin.findByUserloginId", query = "SELECT u FROM Userlogin u WHERE u.userloginId = :userloginId"),
    @NamedQuery(name = "Userlogin.findByPassword", query = "SELECT u FROM Userlogin u WHERE u.password = :password")})
public class Userlogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userlogin_id")
    private Integer userloginId;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne(optional = false)
    private User userId;

    public Userlogin() {
    }

    public Userlogin(Integer userloginId) {
        this.userloginId = userloginId;
    }

    public Userlogin(Integer userloginId, String password) {
        this.userloginId = userloginId;
        this.password = password;
    }

    public Integer getUserloginId() {
        return userloginId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getUserloginId();
    }

    public void setUserloginId(Integer userloginId) {
        this.userloginId = userloginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (userloginId != null ? userloginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userlogin)) {
            return false;
        }
        Userlogin other = (Userlogin) object;
        if ((this.userloginId == null && other.userloginId != null) || (this.userloginId != null && !this.userloginId.equals(other.userloginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Userlogin[ userloginId=" + userloginId + " ]";
    }

}
