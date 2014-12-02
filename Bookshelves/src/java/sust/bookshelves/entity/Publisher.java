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
 * @author Sm19 & MahadiHasanNahid
 */
@Entity
@Table(name = "publisher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p"),
    @NamedQuery(name = "Publisher.findByPublisherId", query = "SELECT p FROM Publisher p WHERE p.publisherId = :publisherId"),
    @NamedQuery(name = "Publisher.findByPublishername", query = "SELECT p FROM Publisher p WHERE p.publishername = :publishername"),
    @NamedQuery(name = "Publisher.findByCountry", query = "SELECT p FROM Publisher p WHERE p.country = :country"),
    @NamedQuery(name = "Publisher.findByAddress", query = "SELECT p FROM Publisher p WHERE p.address = :address"),
    @NamedQuery(name = "Publisher.findByContactinfo", query = "SELECT p FROM Publisher p WHERE p.contactinfo = :contactinfo"),
    @NamedQuery(name = "Publisher.findByDescription", query = "SELECT p FROM Publisher p WHERE p.description = :description")})
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "publisher_id")
    private Integer publisherId;
    @Column(name = "publishername")
    private String publishername;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Column(name = "address")
    private String address;
    @Column(name = "contactinfo")
    private String contactinfo;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisherId")
    private List<Book> bookList;

    public Publisher() {
    }

    public Publisher(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Publisher(Integer publisherId, String country) {
        this.publisherId = publisherId;
        this.country = country;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public java.lang.Integer getPrimaryKey() {
        return getPublisherId();
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (publisherId != null ? publisherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if ((this.publisherId == null && other.publisherId != null) || (this.publisherId != null && !this.publisherId.equals(other.publisherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Publisher[ publisherId=" + publisherId + " ]";
    }

}
