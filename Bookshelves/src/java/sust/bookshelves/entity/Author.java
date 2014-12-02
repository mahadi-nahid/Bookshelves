package sust.bookshelves.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sm19 & MahadiHasanNahid
 */
@Entity
@Table(name = "author")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findByAuthorId", query = "SELECT a FROM Author a WHERE a.authorId = :authorId"),
    @NamedQuery(name = "Author.findByFname", query = "SELECT a FROM Author a WHERE a.fname = :fname"),
    @NamedQuery(name = "Author.findByLname", query = "SELECT a FROM Author a WHERE a.lname = :lname"),
    @NamedQuery(name = "Author.findByDob", query = "SELECT a FROM Author a WHERE a.dob = :dob"),
    @NamedQuery(name = "Author.findByDod", query = "SELECT a FROM Author a WHERE a.dod = :dod"),
    @NamedQuery(name = "Author.findByCountry", query = "SELECT a FROM Author a WHERE a.country = :country"),
    @NamedQuery(name = "Author.findByDescription", query = "SELECT a FROM Author a WHERE a.description = :description")})
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "author_id")
    private Integer authorId;
    @Basic(optional = false)
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "dod")
    @Temporal(TemporalType.DATE)
    private Date dod;
    @Column(name = "country")
    private String country;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private List<Book> bookList;

    public Author() {
    }

    public Author(Integer authorId) {
        this.authorId = authorId;
    }

    

    public Author(Integer authorId, String fname) {
        this.authorId = authorId;
        this.fname = fname;
    }

    public Integer getAuthorId() {
        return authorId;
    }
    public java.lang.Integer getPrimaryKey() {
        return getAuthorId();
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDod() {
        return dod;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        hash += (authorId != null ? authorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authorId == null && other.authorId != null) || (this.authorId != null && !this.authorId.equals(other.authorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sust.bookshelves.entity.Author[ authorId=" + authorId + " ]";
    }

}
